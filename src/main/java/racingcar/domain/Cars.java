package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> values;

    private Cars(List<Car> values) {
        this.values = values;
    }

    public static Cars from(List<Car> values) {
        return new Cars(values);
    }

    public int size() {
        if(isEmpty()){
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

    public void run(){
        for (Car car : this.values) {
            car.run();
        }
    }

    public Car getIdx(int index) {
        return this.values.get(index);
    }
}
