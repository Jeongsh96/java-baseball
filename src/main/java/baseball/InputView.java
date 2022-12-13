package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {


    public static int getNumbers() {
        //LinkedHashMap<Integer, Integer> usersNumbers = new LinkedHashMap<Integer, Integer>();
        List<Integer> userNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();

        int inputNumber = Integer.parseInt(input);

        return inputNumber;
    }

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
        if (inputNumber.size() < 3) {
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

    public static List<Integer> checkUserInputValidity() {
        List<Integer> userNumber = new ArrayList<>();
        while (true) {
            try {
                userNumber = connectedNumbersDivider(getNumbers());
                inputNumbersValidity(userNumber);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return userNumber;
    }
}
