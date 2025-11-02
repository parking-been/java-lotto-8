package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    WinningLotto winningLotto = new WinningLotto();

    @Test
    @DisplayName("주어진 로또가 정답 번호와 얼마나 일치하는지 확인하는 기능")
    void 매치율_성능_평가() {
        winningLotto.saveAll(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(winningLotto.compareWithLotto(lotto)).containsExactly(3, 1);
    }
}