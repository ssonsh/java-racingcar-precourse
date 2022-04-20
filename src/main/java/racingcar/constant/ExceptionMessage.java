package racingcar.constant;

public class ExceptionMessage {
    public static final String CAR_NAME_IS_NOT_EMPTY = "[ERROR] 자동차 이름은 빈값일 수 없습니다.";
    public static final String CAR_NAME_IS_DONT_OVER_SIZE = String.format("[ERROR] 자동차 이름은 최대 %s자를 넘을 수 없습니다.",
            Conditions.NAME_MAX_SIZE);
}
