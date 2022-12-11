package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {


    public int strikeCounter(List<Integer> answer, List<Integer> userInput) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (answer.get(index) == userInput.get(index)) {
                strike++;
            }
        }
        return strike;
    }

    public int ballCounter(List<Integer> answer, List<Integer> userInput) {
        int ball = 0;

        for (int index = 0; index < 3; index++) {
            if (answer.contains(userInput.get(index)) && !(userInput.get(index).equals(answer.get(index)))) {
                ball++;

            }
        }
        return ball;
    }
}
