package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseballGame {

    public static List<Integer> gameAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }


    public static HashMap<String, Integer> getResult(List<Integer> answer, List<Integer> userInput) {
        HashMap<String, Integer> result = new HashMap<>();
        int strike = strikeCounter(answer, userInput);
        int ball = ballCounter(answer, userInput);
        result.put("strike", strike);
        result.put("ball", ball);

        return result;
    }

    public static int strikeCounter(List<Integer> answer, List<Integer> userInput) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (answer.get(index).equals(userInput.get(index))) {
                strike++;
            }
        }
        return strike;
    }

    public static int ballCounter(List<Integer> answer, List<Integer> userInput) {
        int ball = 0;

        for (int index = 0; index < 3; index++) {
            if (answer.contains(userInput.get(index)) && !(userInput.get(index).equals(answer.get(index)))) {
                ball++;

            }
        }
        return ball;
    }

}
