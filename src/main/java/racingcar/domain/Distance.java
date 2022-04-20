package racingcar.domain;

public class Distance {
    private Integer value;

    private Distance(Integer value) {
        this.value = value;
    }

    public static Distance init() {
        return new Distance(0);
    }

    public Integer getValue() {
        return this.value;
    }
}
