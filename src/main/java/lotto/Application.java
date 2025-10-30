package lotto;

import lotto.controller.LottoController;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoRepository lottoRepository = new LottoRepository(lottoGenerator);

        WinningLotto winningLotto = new WinningLotto();
        LottoResult lottoResult = new LottoResult();
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningLotto, lottoResult);

        LottoService lottoService = new LottoService(lottoRepository, lottoResultCalculator);
        LottoController lottoController = new LottoController(inputView, outputView, lottoService);

        lottoController.run();

    }
}
