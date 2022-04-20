package racingcar.domain;

public class Car {
    private Name name;
    private Distance distance;

    private Car(Name name) {
        this.name = name;
        this.distance = Distance.init();
    }

    public static Car from(Name name) {
        return new Car(name);
    }

    public String getName() {
        return this.name.getValue();
    }

    public Integer getDistance() {
        return this.distance.getValue();
    }
}
