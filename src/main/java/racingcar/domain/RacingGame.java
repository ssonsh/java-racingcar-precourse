package racingcar.domain;

public class RacingGame {
    private final Cars cars;
    private final RacingGameStep racingGameStep;

    private RacingGame(Cars cars, RacingGameStep racingGameStep) {
        this.cars = cars;
        this.racingGameStep = racingGameStep;
    }

    public static RacingGame of(Cars cars, RacingGameStep racingGameStep) {
        return new RacingGame(cars, racingGameStep);
    }

    public void play(){
        for (int i = 0; i < racingGameStep.getValue(); i++) {
            this.cars.run();
        }
    }
}
