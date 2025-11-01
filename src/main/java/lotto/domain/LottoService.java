package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final LottoRepository lottoRepository;
    private final LottoGenerator lottoGenerator;
    private final WinningLotto winningLotto;
    private final LottoResult lottoResult;
    private int paidMoney = 0 ;

    public LottoService(LottoRepository lottoRepository, LottoGenerator lottoGenerator, WinningLotto winningLotto, LottoResult lottoResult) {
        this.lottoRepository = lottoRepository;
        this.lottoGenerator = lottoGenerator;
        this.winningLotto = winningLotto;
        this.lottoResult = lottoResult;

    }

    public void buyLottos(int price){
        ArrayList<Lotto> listOfLottos = lottoGenerator.createLottos(price);
        lottoRepository.saveAll(listOfLottos);
        paidMoney += price;
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

    public Map<Rank, Integer> getScore(){
        return lottoResult.getScore();
    }

    public double calculateProfitRate(){
        return ((double) getTotalReword() / getTotalPaid())*100;
    }

    private long getTotalReword(){
        return lottoResult.getTotalReword();
    }

    private int getTotalPaid(){
        return paidMoney;
    }
}
