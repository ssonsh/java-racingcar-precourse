package racingcar.domain;

public class Car {
    private Name name;

    private Car(Name name) {
        this.name = name;
    }

    public static Car from(Name name) {
        return new Car(name);
    }

    public String getName() {
        return this.name.getValue();
    }
}
