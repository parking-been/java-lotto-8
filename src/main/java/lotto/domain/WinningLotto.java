package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Integer> luckyNumbers;
    private int bonusNumber;

    public void saveAll(List<Integer> luckyNumbers, int bonusNumber){
        //LottoRules.lottoNumbersValidator(luckyNumbers);
        LottoRules.lottoNumbersAndBonusNumberValidator(luckyNumbers, bonusNumber);
        this.luckyNumbers = new ArrayList<>();
        this.luckyNumbers.addAll(luckyNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int[] compareWithLotto(Lotto lotto){

        List<Integer> numberList = lotto.getNumbers();
        int count = 0;
        int flag = 0;
        for (Integer number : numberList){
            if (luckyNumbers.contains(number)){
                count+=1;
            }
            if (bonusNumber==number) flag = 1;
        }
        int[] result = {count, flag};
        return result;
    }
}
