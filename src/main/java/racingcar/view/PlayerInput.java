package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ExceptionMessage;
import racingcar.constant.RacingGameMessage;
import racingcar.domain.Name;

public class PlayerInput {

    private static final String INPUT_CAR_NAMES_SEPARATOR = ",";

    public List<Name> inputNames() {
        System.out.println(RacingGameMessage.GUIDE_MESSAGE_INPUT_CAR_NAMES);
        String inputNames = Console.readLine();

        try {
            validateInputNames(inputNames);
            return convertBy(inputNames);
        } catch (Exception e) {
            System.out.println(ExceptionMessage.INVALID_INPUT_CAR_NAMES);
            return inputNames();
        }
    }

    private List<Name> convertBy(String inputNames) {
        List<Name> names = new ArrayList<>();
        String[] splitInputNames = inputNames.split(INPUT_CAR_NAMES_SEPARATOR);
        for (String inputName : splitInputNames) {
            names.add(Name.from(inputName));
        }
        return names;
    }

    private void validateInputNames(String inputNames) {
        if (isEmpty(inputNames)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_CAR_NAMES);
        }
    }

    private boolean isEmpty(String inputNames) {
        return inputNames == null || inputNames.length() == 0;
    }
}
