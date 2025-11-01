package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    void 문자열_에서_정수로_바꾸는_기능(){
        assertThat(inputValidator.validateStringToInteger("2")).isEqualTo(2);
    }

    @Test
    void 문자열_에서_정수_리스트로_바꾸는_기능(){
        assertAll(
                ()-> assertThat(inputValidator.validateStringToIntList("2,3")).isEqualTo(List.of(2,3)),
                ()-> assertThat(inputValidator.validateStringToIntList("2")).isEqualTo(List.of(2))

        );
    }

    @Test
    void 문자열_안에_숫자가_아닌_문자가_있을시_예외(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()-> inputValidator.validateStringToInteger("~!3"));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
    }

    @Test
    void 문자열_안에_숫자_외_구분자가_아닌_문자가_있을시_예외(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()-> inputValidator.validateStringToIntList("1,2+"));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
    }

}