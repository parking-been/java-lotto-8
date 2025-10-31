package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            runApplication();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            //throw e;
        }

    }

    public static void runApplication(){
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();
        LottoRepository lottoRepository = new LottoRepository();
        WinningLotto winningLotto = new WinningLotto();
        LottoResult lottoResult = new LottoResult();
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        LottoGenerator lottoGenerator = new LottoGenerator(randomValueGenerator);
        LottoService lottoService = new LottoService(lottoRepository, lottoGenerator, winningLotto, lottoResult);
        LottoController lottoController = new LottoController(inputView, outputView, lottoService);

        lottoController.run();
    }
}
