package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private LottoRepository lottoRepository;

    private LottoResultCalculator lottoResultCalculator;
    private LottoGenerator lottoGenerator;
    private LottoResult lottoResult;
    private WinningLotto winningLotto;

    public LottoService(LottoRepository lottoRepository, LottoResultCalculator lottoResultCalculator, LottoGenerator lottoGenerator, WinningLotto winningLotto, LottoResult lottoResult) {
        this.lottoRepository = lottoRepository;
        this.lottoResultCalculator = lottoResultCalculator;
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
}
