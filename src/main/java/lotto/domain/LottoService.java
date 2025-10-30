package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private LottoRepository lottoRepository;
    private LottoGenerator lottoGenerator;
    private LottoResult lottoResult;
    private WinningLotto winningLotto;

    public LottoService(LottoRepository lottoRepository, LottoGenerator lottoGenerator, WinningLotto winningLotto, LottoResult lottoResult) {
        this.lottoRepository = lottoRepository;
        this.lottoGenerator = lottoGenerator;
        this.lottoResult = lottoResult;
        this.winningLotto = winningLotto;
    }

    public void buyLottos(int price){
        ArrayList<Lotto> listOfLottos = lottoGenerator.createLottos(price);
        lottoRepository.saveAll(listOfLottos);
    }

    public List<Lotto> getAllLottos(){
        return lottoRepository.findAll();
    }

    public void setWinningLotto(List<Integer> luckyNumbers, int bonusNumber){
        winningLotto.saveAll(luckyNumbers,bonusNumber);
    }

    public void calculateResult(){
        List<Lotto> lottos = lottoRepository.findAll();
        for (Lotto lotto: lottos){
            int[] result = winningLotto.compareWithLotto(lotto);
            lottoResult.updateScore(result[0],result[1]);
        }
    }

    public List<Integer> getScore(){
        return lottoResult.getScore();
    }

    public int getTotalReword(){
        return lottoResult.getTotalReword();
    }
}
