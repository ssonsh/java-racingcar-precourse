package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.engine.Engine;

public class Cars {
    private List<Car> values;

    private Cars(List<Car> values) {
        this.values = values;
    }

    public static Cars from(List<Car> values) {
        return new Cars(values);
    }

    public static Cars of(List<Name> names, Engine engine) {
        List<Car> results = new ArrayList<>();
        for (Name name : names) {
            results.add(Car.of(name, engine));
        }
        return new Cars(results);
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return this.values.size();
    }

    private boolean isEmpty() {
        return this.values == null || this.values.isEmpty();
    }

    public void add(Car car) {
        this.values.add(car);
    }

    public void run() {
        for (Car car : this.values) {
            car.run();
        }
    }

    public Car getIdx(int index) {
        return this.values.get(index);
    }
}
