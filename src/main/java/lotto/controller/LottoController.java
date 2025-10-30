package lotto.controller;

import lotto.domain.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        displayWinningResults();
        displayProfitRate();
    }

    //발행한 로또 수량 및 번호 출력
    private void displayIssuedLottos(){

    }
    //당첨 내역 출력
    private void displayWinningResults(){

    }
    //수익률 출력
    private void displayProfitRate(){

    }

    private void prepareLottoGame(){
        buyLottos();
        displayIssuedLottos();
        getLuckyNumbers();
        getBonusNumber();
    }

    //로또 구매
    private void buyLottos(){
        outputView.printInputMoneyMessage();
        int price = inputView.getInteger();
        lottoService.buyLottos(price);
    }

    //당첨 번호 받기
    private void getLuckyNumbers(){

    }

    private void getBonusNumber(){

    }

}
