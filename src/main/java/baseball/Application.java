package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static baseball.OutputView.*;
import static baseball.InputView.*;
import static baseball.BaseballGame.*;

public class Application {
    public static void main(String[] args) {
        startGame();
        List<Integer> userAnswer;
        boolean correct = true;
        boolean retry=true;
        while(retry){
            List<Integer> gameAnswer = gameAnswer();
            while (correct) {
                userAnswer = checkUserInputValidity();
                correct = printResult(gameAnswer, userAnswer);
            }
            finish();
            int retryValue = retry();
            if(retryValue==1){
                retry = true;
                correct = true;
            }
            if(retryValue == 2){
                retry = false;
            }
        }
    }
}
