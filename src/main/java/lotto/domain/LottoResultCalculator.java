package lotto.domain;

public class LottoResultCalculator {
    private WinningLotto winningLotto;
    private LottoResult lottoResult;
    public LottoResultCalculator(WinningLotto winningLotto, LottoResult lottoResult) {
        this.winningLotto = winningLotto;
        this.lottoResult = lottoResult;
    }
}
