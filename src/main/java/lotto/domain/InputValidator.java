package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String delimiter = ",";

    public int validateStringToInteger(String value){
        try{
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }

    }

    public List<Integer> validateStringToIntList(String value){
        String[] numbers = value.split(delimiter);
        List<Integer> result = new ArrayList<>();
        for (String number : numbers){
            result.add(validateStringToInteger(number));
        }
        return result;
    }

    //아래는 private로 구성

}
