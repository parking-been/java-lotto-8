package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run(){
        prepareLottoGame();
        calculateTheResults();
        displayTheResults();
        displayProfitRate();
    }

    //발행한 로또 수량 및 번호 출력
    private void displayIssuedLottos(){
        outputView.printIssuedLottos(lottoService.getAllLottos());
    }

    private void calculateTheResults(){
        lottoService.calculateResult();
    }

    //당첨 내역 출력
    private void displayTheResults(){

    }
    //수익률 출력
    private void displayProfitRate(){

    }

    private void prepareLottoGame(){
        buyLottos();
        displayIssuedLottos();
        getLuckyandBonusNumbers();
    }

    //로또 구매
    private void buyLottos(){
        outputView.printInputMoneyMessage();
        int price = inputView.getInteger();
        lottoService.buyLottos(price);
    }

    //당첨 번호 받기
    private void getLuckyandBonusNumbers(){
        outputView.printIputLuckyNumbers();
        List<Integer> luckyNumbers = inputView.getListOfNumbers();
        outputView.printInputBonusNumber();
        int bonusNumber = inputView.getInteger();
        lottoService.setWinningLotto(luckyNumbers,bonusNumber);
    }

}
