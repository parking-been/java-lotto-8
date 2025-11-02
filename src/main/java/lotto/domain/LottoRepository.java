package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final ArrayList<Lotto> lottos;

    public LottoRepository() {
        this.lottos = new ArrayList<>();
    }

    public void saveAll(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> findAll() {
        return List.copyOf(lottos);
    }

    public int getSize() {
        return lottos.size();
    }
}
