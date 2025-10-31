package lotto.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView = new OutputView();
    
    
    //need test how? => 고치기
    @Test
    void 출력_검증(){
        outputView.printTheResults(List.of(1,2,3,4,5));
    }

}