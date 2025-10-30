package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_LUCK_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String OUTPUT_NUM_OF_LOTTOS = "\n%d개를 구매했습니다.\n";

    public void printInputMoneyMessage(){
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public void printIputLuckyNumbers(){
        System.out.println(INPUT_LUCK_NUMBERS);
    }

    public void printInputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printIssuedLottos(List<Lotto> lottos){
        System.out.printf(OUTPUT_NUM_OF_LOTTOS,lottos.size());
        for (Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
