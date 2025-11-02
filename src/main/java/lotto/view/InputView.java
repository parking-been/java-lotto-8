package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputValidator;
import lotto.exception.ErrorMessage;

import java.util.List;
import java.util.NoSuchElementException;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getInteger() {
        String value = getInput().trim();
        return inputValidator.validateStringToInteger(value);
    }

    public List<Integer> getListOfNumbers() {
        String value = getInput().trim();
        return inputValidator.validateStringToIntList(value);
    }


    public String getInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NULL_INPUT.getMessage());
        }

    }
}
