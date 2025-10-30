package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Integer> luckyNumbers;
    private int bonusNumber;

    public void saveAll(List<Integer> luckyNumbers, int bonusNumber){
        this.luckyNumbers = new ArrayList<>();
        this.luckyNumbers.addAll(luckyNumbers);
        this.bonusNumber = bonusNumber;
    }
}
