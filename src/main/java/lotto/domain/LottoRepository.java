package lotto.domain;

import java.util.ArrayList;

public class LottoRepository {
    private ArrayList<Lotto> lottos;
    private LottoGenerator lottoGenerator;
    public LottoRepository(LottoGenerator lottoGenerator) {
        this.lottos = new ArrayList<>();
        this.lottoGenerator = lottoGenerator;
    }
}
