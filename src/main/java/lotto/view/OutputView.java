package lotto.view;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_LUCK_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String OUTPUT_NUM_OF_LOTTOS = "\n%d개를 구매했습니다.\n";
    public static final String OUTPUT_PRINT_REUSLTS = """
            당첨 통계
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개""";
    public static final String OUTPUT_PROFIT_RATE = "총 수익률은 %.2f%%입니다.";

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

    public void printTheResults(List<Integer> score){
        List<Integer> reversed = score.reversed();
        String result = String.format(OUTPUT_PRINT_REUSLTS, reversed.toArray());
        System.out.println(result);
    }

    public void printProfitRate(double rate){
        System.out.printf(OUTPUT_PROFIT_RATE,rate);
    }
}
