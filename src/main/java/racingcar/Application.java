package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.generator.RacingGameNumberGenerator;
import racingcar.view.PlayerInput;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new PlayerInput(),
                new RacingGameNumberGenerator());
        racingGameController.execute();
    }
}
