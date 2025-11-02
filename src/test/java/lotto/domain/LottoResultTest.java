package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoResultTest {
    LottoResult lottoResult = new LottoResult();

    @Test
    void 생성확인() {
        assertThat(lottoResult.getScore()).isEqualTo(Map.of(
                Rank.First, 0,
                Rank.Second, 0,
                Rank.Third, 0,
                Rank.Fourth, 0,
                Rank.Fifth, 0
        ));
    }

    @Test
    void 스코어_업데이트_확인() {
        lottoResult.updateScore(3, 0);
        lottoResult.updateScore(5, 0);
        lottoResult.updateScore(3, 0);
        lottoResult.updateScore(5, 1);
        lottoResult.updateScore(5, 1);
        assertThat(lottoResult.getScore()).isEqualTo(Map.of(
                Rank.First, 0,
                Rank.Second, 2,
                Rank.Third, 1,
                Rank.Fourth, 0,
                Rank.Fifth, 2
        ));
    }

    @Test
    void 수익_계산() {
        LottoResult lottoResult_test1 = new LottoResult(Map.of(
                Rank.First, 1,
                Rank.Second, 0,
                Rank.Third, 1,
                Rank.Fourth, 0,
                Rank.Fifth, 2
        ));
        assertThat(lottoResult_test1.getTotalReword()).isEqualTo(
                2_000_000_000L + 1_500_000L + 5_000L * 2
        );
    }

}