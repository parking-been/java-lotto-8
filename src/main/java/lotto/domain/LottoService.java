package lotto.domain;

import java.util.ArrayList;

public class LottoService {
    private LottoRepository lottoRepository;
    private LottoResultCalculator lottoResultCalculator;
    private LottoGenerator lottoGenerator;
    public LottoService(LottoRepository lottoRepository, LottoResultCalculator lottoResultCalculator, LottoGenerator lottoGenerator) {
        this.lottoRepository = lottoRepository;
        this.lottoResultCalculator = lottoResultCalculator;
        this.lottoGenerator = lottoGenerator;
    }

    public void buyLottos(int price){
        ArrayList<Lotto> listOfLottos = lottoGenerator.createLottos(price);

    }
}
