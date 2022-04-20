package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ExceptionMessage;

class CarTest {

    @Test
    @DisplayName("이름을 가진 Car 도메인을 생성한다.")
    void generate01(){
        // given
        // when
        Car car = Car.from(Name.from("자동차_1"));

        // then
        Assertions.assertEquals("자동차_1", car.getName());
    }

    @ParameterizedTest
    @DisplayName("이름을 가진 Car 도메인을 생성한다. ParameterizedTest 이용")
    @ValueSource(strings = {"자동차_1", "자동차_2"})
    void generate02(String value){
        // given
        // when
        Car car = Car.from(Name.from(value));

        // then
        Assertions.assertEquals(value, car.getName());
    }

    @ParameterizedTest
    @DisplayName("5자가 넘는 이름을 가진 자동차 도메인 생성")
    @ValueSource(strings = {"자동차_11111", "자동차_22222"})
    void generateException01(String value){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.from(Name.from(value)))
                .withMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("이름이 공란인 자동차 도메인 생성")
    @ValueSource(strings = {""})
    void generateException02(String value){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.from(Name.from(value)))
                .withMessageContaining("[ERROR]");
    }

}