package lotto.view;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView = new OutputView();
    
    
    //need test how? => 고치기
    @Test
    void 출력_검증(){
        outputView.printTheResultsMap(
                Map.of(
                        Rank.First , 1,
                        Rank.Second, 0,
                        Rank.Third, 1,
                        Rank.Fourth, 0,
                        Rank.Fifth, 2
                )

        );
    }

}