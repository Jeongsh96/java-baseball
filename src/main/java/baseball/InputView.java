package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

    public static int retry(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input;
        while(true){
            try{
                input = Console.readLine();
                retryValidity(input);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }
    public static void retryValidity(String input){
        String pattern = "^[1-2]$";
        if(Pattern.matches(pattern,input)){
            throw new IllegalArgumentException("[ERROR] 1 또는 2 중 하나를 입력해주세요");
        }
    }

}
