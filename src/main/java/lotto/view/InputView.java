package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;

import java.util.NoSuchElementException;

public class InputView {
    public String getInput(){
        try{
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NULL_INPUT.getMessage());
        }

    }
}
