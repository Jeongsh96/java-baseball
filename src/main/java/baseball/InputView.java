package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int getNumbers(){
        //LinkedHashMap<Integer, Integer> usersNumbers = new LinkedHashMap<Integer, Integer>();
        List<Integer> userNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);
        return inputNumber;
    }

    public List<Integer> connectedNumbersDivider(int inputNumber){
        //LinkedHashMap<Integer, Integer> usersNumbers = new LinkedHashMap<Integer, Integer>();
        List<Integer> userNumbers = new ArrayList<>();
        int firstNumber = inputNumber/100;
        int secondNumber = inputNumber%100/10;
        int thirdNumber = inputNumber%10;

        userNumbers.add(firstNumber);
        userNumbers.add(secondNumber);
        userNumbers.add(thirdNumber);
        return userNumbers;
    }


    public void inputNumbersValidity(int inputNumber1,int inputNumber2, int inputNumber3){
        if(inputNumber1 > 9){ //입력된 세자리수가 999이상일 경우
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자가 입력되었습니다");
        }
        if(inputNumber1 == 0 || inputNumber2 == 0 || inputNumber3==0){  // 0이 포함되어 있을 경우
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자가 입력되었습니다");
        }
        if(inputNumber1==inputNumber2 || inputNumber2 == inputNumber3 || inputNumber3 == inputNumber1){
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자가 입력되었습니다");
        }
    }
}
