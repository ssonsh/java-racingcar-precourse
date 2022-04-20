package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private List<Car> testCars;

    @BeforeEach
    void beforeEach() {
        testCars = new ArrayList<>();
        testCars.add(Car.from(Name.from("자동차_1")));
        testCars.add(Car.from(Name.from("자동차_2")));
        testCars.add(Car.from(Name.from("자동차_3")));
        testCars.add(Car.from(Name.from("자동차_4")));
        testCars.add(Car.from(Name.from("자동차_5")));
    }


    @Test
    @DisplayName("1급 컬랙션을 이용해 여러대 자동차를 생성하여 관리할 수 있다.")
    void generate01() {
        // given
        // when
        Cars cars = Cars.from(testCars);

        Assertions.assertEquals(5, cars.size());
    }


    @Test
    @DisplayName("Cars 도메인에 Car 도메인을 동적으로 추가할 수 있다.")
    void generate02() {
        // given
        // when
        Cars cars = Cars.from(testCars);
        cars.add(Car.from(Name.from("신차_1")));
        cars.add(Car.from(Name.from("신차_2")));

        Assertions.assertEquals(7, cars.size());
    }
}
