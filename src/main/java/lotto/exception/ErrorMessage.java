package lotto.exception;

public enum ErrorMessage {

    INVALID_NULL_INPUT("[ERROR] 입력이 제대로 이루어지지 않았습니다. (빈칸이나 null값을 가집니다)"),
    INVALID_NUMBER_INPUT("[ERROR] 입력값이 숫자가 아닙니다."),
    INVALID_PRICE_INPUT("[ERROR] 구입금액이 1000원 단위가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
