package lotto.exception;

public enum ErrorMessage {

    INVALID_NULL_INPUT("[ERROR] 입력이 제대로 이루어지지 않았습니다. (빈칸이나 null값을 가집니다)"),
    INVALID_NUMBER_INPUT("[ERROR] 입력값이 숫자가 아닙니다."),
    INVALID_PRICE_INPUT("[ERROR] 구입금액이 1000원 단위가 아닙니다."),
    INVALID_NUMBERS_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_NUMBERS_DUPLICATE("[ERROR] 로또 번호에 중복이 있습니다."),
    INVALID_NUMBERS_OUT_OF_UPPER_AND_LOWER_BOUND("[ERROR] 로또 번호의 숫자 범위는 1~45까지 입니다."),
    INVALID_LUCKY_NUMBERS_CONTAINS_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
