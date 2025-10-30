package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    LottoResult lottoResult = new LottoResult();

    @Test
    void updateScore_동작_확인(){
        assertAll(
                ()->{
                    lottoResult.updateScore(6,1);
                    assertThat(lottoResult.getScore()).isEqualTo(List.of(1,0,0,0,0,0));
                },
                ()->{
                    lottoResult.updateScore(6,0);
                    assertThat(lottoResult.getScore()).isEqualTo(List.of(2,0,0,0,0,0));
                },
                ()->{
                    lottoResult.updateScore(5,0);
                    assertThat(lottoResult.getScore()).isEqualTo(List.of(2,0,1,0,0,0));
                },
                ()->{
                    lottoResult.updateScore(5,1);
                    assertThat(lottoResult.getScore()).isEqualTo(List.of(2,1,1,0,0,0));
                }
        );

    }
}