package baseball;

import java.util.HashMap;
import java.util.List;

import static baseball.BaseballGame.*;

public class OutputView {


    public static void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public static void finish(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static boolean printResult(List<Integer> answer, List<Integer>user){
        HashMap<String,Integer> result = getResult(answer, user);
        printHint(result.get("strike"),result.get("ball"));
        if(result.get("strike").equals(3)){
            return false;
        }
        return true;
    }

    public static void printHint(int strike, int ball){
        if(strike>0 && ball ==0){
            System.out.println(strike + "스트라이크");
        }
        if(strike==0 && ball >0){
            System.out.println(ball + "볼");
        }
        if(strike ==0 && ball==0){
            System.out.println("낫싱");
        }
        if(strike>0 && ball>0){
            System.out.printf(ball+"볼 "+strike+"스트라이크\n");
        }
    }
}
