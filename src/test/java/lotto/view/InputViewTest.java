package lotto.view;

import lotto.domain.InputValidator;
import lotto.domain.Lotto;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {


    InputValidator inputValidator = new InputValidator();
    InputView inputView = new InputView(inputValidator);

    @Test
    void 로또_구입_금액_입력_예외(){

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                ()->inputValidator.validatePriceofLottos("5!!4")
        );

        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
    }

}