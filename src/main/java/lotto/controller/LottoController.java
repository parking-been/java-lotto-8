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

    private void displayIssuedLottos(){
        outputView.printIssuedLottos(lottoService.getAllLottos());
    }

    private void calculateTheResults(){
        lottoService.calculateResult();
    }

    private void displayTheResults(){
        outputView.printTheResultsMap(lottoService.getScore());
    }

    private void displayProfitRate(){
        outputView.printProfitRate(lottoService.calculateProfitRate());
    }

    private void prepareLottoGame(){
        buyLottos();
        displayIssuedLottos();
        getLuckyandBonusNumbers();
    }

    private void buyLottos(){
        outputView.printInputMoneyMessage();
        int price = inputView.getInteger();
        lottoService.buyLottos(price);
    }

    private void getLuckyandBonusNumbers(){
        outputView.printIputLuckyNumbers();
        List<Integer> luckyNumbers = inputView.getListOfNumbers();
        outputView.printInputBonusNumber();
        int bonusNumber = inputView.getInteger();
        lottoService.setWinningLotto(luckyNumbers,bonusNumber);
    }

}
