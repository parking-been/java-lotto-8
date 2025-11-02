package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_LUCK_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String OUTPUT_NUM_OF_LOTTOS = "\n%d개를 구매했습니다.\n";
    public static final String OUTPUT_PRINT_RESULTS_HEADER = "\n당첨 통계\n---";
    public static final String OUTPUT_PRINT_RESULTS_BODY_WO_BONUS = "%d개 일치 (%,d원) - %d개";
    public static final String OUTPUT_PRINT_RESULTS_BODY_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    public static final String OUTPUT_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

    public void printInputMoneyMessage(){
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public void printIputLuckyNumbers(){
        System.out.println(INPUT_LUCK_NUMBERS);
    }

    public void printInputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printIssuedLottos(List<Lotto> lottos) {
        System.out.printf(OUTPUT_NUM_OF_LOTTOS,lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public void printTheResultsMap(Map<Rank, Integer> score) {
        System.out.println(OUTPUT_PRINT_RESULTS_HEADER);
        Rank[] ranks = Rank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            String tmp = OUTPUT_PRINT_RESULTS_BODY_WO_BONUS;
            if (ranks[i].getHitBonus() == 1) tmp = OUTPUT_PRINT_RESULTS_BODY_WITH_BONUS;
            System.out.println(String.format(tmp, ranks[i].getHitCount(), ranks[i].getReward(), score.get(ranks[i])));
        }
    }

    public void printProfitRate(double rate) {
        System.out.printf(OUTPUT_PROFIT_RATE,rate);
    }
}
