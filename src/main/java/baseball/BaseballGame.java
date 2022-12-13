package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseballGame {

    public static List<Integer> connectedNumbersDivider(int inputNumber) {
        //LinkedHashMap<Integer, Integer> usersNumbers = new LinkedHashMap<Integer, Integer>();
        List<Integer> userNumbers = new ArrayList<>();
        int firstNumber = inputNumber / 100;
        int secondNumber = inputNumber % 100 / 10;
        int thirdNumber = inputNumber % 10;

        userNumbers.add(firstNumber);
        userNumbers.add(secondNumber);
        userNumbers.add(thirdNumber);
        return userNumbers;
    }


    public static void inputNumbersValidity(List<Integer> inputNumber) {
        if(inputNumber.size()<3){
            throw new IllegalArgumentException("[ERROR] 3자리의 수를 입력하세요");
        }
        if (inputNumber.get(0) > 9) { //입력된 세자리수가 999이상일 경우
            throw new IllegalArgumentException("[ERROR] 3자리의 수를 입력하세요");
        }
        if (inputNumber.get(0) == 0 || inputNumber.get(1) == 0 || inputNumber.get(2) == 0) {  // 0이 포함되어 있을 경우
            throw new IllegalArgumentException("[ERROR] 1-9 사이의 수를 입력하세요");
        }
        if (inputNumber.get(0).equals(inputNumber.get(1)) || inputNumber.get(1).equals(inputNumber.get(2)) || inputNumber.get(2).equals(inputNumber.get(0))) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public  List<Integer> gameAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public HashMap<String, Integer> getResult(List<Integer> answer, List<Integer> userInput) {
        HashMap<String, Integer> result = new HashMap<>();
        int strike = strikeCounter(answer, userInput);
        int ball = ballCounter(answer, userInput);
        result.put("strike", strike);
        result.put("ball", ball);

        return result;
    }

    public int strikeCounter(List<Integer> answer, List<Integer> userInput) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (answer.get(index).equals(userInput.get(index))) {
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
