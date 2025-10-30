package lotto.domain;

public class LottoService {
    private LottoRepository lottoRepository;
    private LottoResultCalculator lottoResultCalculator;

    public LottoService(LottoRepository lottoRepository, LottoResultCalculator lottoResultCalculator) {
        this.lottoRepository = lottoRepository;
        this.lottoResultCalculator = lottoResultCalculator;
    }
}
