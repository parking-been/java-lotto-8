package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private LottoRepository lottoRepository;
    private LottoGenerator lottoGenerator;
    private LottoResult lottoResult;
    private WinningLotto winningLotto;
    private int paidmoney;
    public LottoService(LottoRepository lottoRepository, LottoGenerator lottoGenerator, WinningLotto winningLotto, LottoResult lottoResult) {
        this.lottoRepository = lottoRepository;
        this.lottoGenerator = lottoGenerator;
        this.lottoResult = lottoResult;
        this.winningLotto = winningLotto;
    }

    public void buyLottos(int price){
        ArrayList<Lotto> listOfLottos = lottoGenerator.createLottos(price);
        lottoRepository.saveAll(listOfLottos);
        paidmoney = price;
    }

    public List<Lotto> getAllLottos(){
        return lottoRepository.findAll();
    }

    public void setWinningLotto(List<Integer> luckyNumbers, int bonusNumber){
        LottoNumbersValidator.lottoNumbersValidator(luckyNumbers);
        LottoNumbersValidator.bonusNumberValidator(bonusNumber);
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

    public double calculateProfitRate(){
        return ((double) getTotalReword() / getTotalPaid())*100;
    }

    private int getTotalReword(){
        return lottoResult.getTotalReword();
    }

    private int getTotalPaid(){
        return paidmoney;
    }
}
