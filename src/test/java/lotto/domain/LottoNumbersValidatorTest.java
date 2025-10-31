package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersValidatorTest {

    @Test
    @DisplayName("예외에 걸리지 않는 값이 들어갔을때")
    void 로또_번호_검증(){
        LottoRules.lottoNumbersValidator(List.of(1,2,3,4,5,6));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/fail/lottoNumbersValidation.csv", numLinesToSkip = 1)
    @DisplayName("숫자의 범위가 넘어갔을 때, 개수가 맞지 않을 때, 중복이 발생할 때")
    void 로또_번호_검증_예외_확인(String input, ErrorMessage expectedError){

        List<Integer> array = Arrays.stream(input.split(","))
                                    .map(Integer::parseInt)
                                    .toList();
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                ()-> LottoRules.lottoNumbersValidator(array)
        );

        assertThat(e.getMessage()).isEqualTo(expectedError.getMessage());

    }


}