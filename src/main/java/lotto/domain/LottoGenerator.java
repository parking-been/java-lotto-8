package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int LOTTO_PRICE = 1000;

    public ArrayList<Lotto> createLottos(int price){
        int countOfLottos = validateCount(price);
        ArrayList<Lotto> newLottos = new ArrayList<>();
        for (int i=0;i<countOfLottos;i++){
            newLottos.add(createLottowithRandomValue());
        }
        return newLottos;
    }

    private int validateCount(int price){
        //1000원에 나누어 떨어지는가 확인
        if (price%LOTTO_PRICE!=0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_INPUT.getMessage());
        };
        return price/LOTTO_PRICE;
    }

    private Lotto createLottowithRandomValue(){
        //List<Integer> randomNumbers = randomValueGenerator.getRandomNumbers();
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoRules.LOWER_BOUND,
                LottoRules.UPPER_BOUND,
                LottoRules.TOTAL_COUNT);
        return new Lotto(randomNumbers);
    }

}
