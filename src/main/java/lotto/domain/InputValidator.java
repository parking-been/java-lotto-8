package lotto.domain;

import lotto.exception.ErrorMessage;

public class InputValidator {
    public int validatePriceofLottos(String value){
        try{
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }

    }

    public void validatewinningNumber(){

    }

    //아래는 private로 구성

}
