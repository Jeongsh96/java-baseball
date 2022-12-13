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


}
