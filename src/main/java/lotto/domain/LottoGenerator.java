package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int LOTTO_PRICE = 1000;
    private final RandomValueGenerator randomValueGenerator;

    public LottoGenerator(RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    public ArrayList<Lotto> createLottos(int price){
        int countOfLottos = validateCount(price);
        ArrayList<Lotto> newLottos = new ArrayList<>();
        for (int i=0;i<countOfLottos;i++){
            newLottos.add(createLotto());
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

    private Lotto createLotto(){
        List<Integer> randomNumbers = randomValueGenerator.getRandomNumbers();
        LottoNumbersValidator.lottoNumbersValidator(randomNumbers);
        return new Lotto(randomNumbers);
    }

}
