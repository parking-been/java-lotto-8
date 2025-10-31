package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRules {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    public static final int TOTAL_COUNT = 6;
    private static final boolean DUPLICATE_FLAG = false;

    public static void lottoNumbersValidator(List<Integer> numbers){
        validateLength(numbers);
        validateDuplicate(numbers);
        for (int number : numbers){
            validateLowAndUpperBound(number);
        }
    }

    public static void bonusNumberValidator(int number){
        validateLowAndUpperBound(number);
    }

    private static void validateDuplicate(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_DUPLICATE.getMessage());
        }
    }

    private static void validateLength(List<Integer> numbers){
        if (numbers.size()!=TOTAL_COUNT){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_COUNT.getMessage());
        }
    }

    private static void validateLowAndUpperBound(int number){
        if (number< LOWER_BOUND|| number>UPPER_BOUND){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_OUT_OF_UPPER_AND_LOWER_BOUND.getMessage());
        }
    }

}
