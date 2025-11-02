package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();
    
    @Test
    void 로또_레포지토리_생성_테스트() {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    ArrayList<Lotto> lottos = lottoGenerator.createLottos(1000);
                    assertThat(lottos.get(0).getNumbers()).isEqualTo(List.of(8, 21, 23, 41, 42, 43));

                    },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    @DisplayName("입력 금액이 1000원 단위로 떨어지지 않을때 예외 처리")
    void 로또_레포지토리_생성_예외_테스트() {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                            ()->lottoGenerator.createLottos(1020));
                    assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_PRICE_INPUT.getMessage());

                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }


}