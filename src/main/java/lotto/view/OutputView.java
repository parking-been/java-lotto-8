package lotto.view;

public class OutputView {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_LUCK_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void printInputMoneyMessage(){
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public void printIputLuckNumbers(){
        System.out.println(INPUT_LUCK_NUMBERS);
    }

    public void printInputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
