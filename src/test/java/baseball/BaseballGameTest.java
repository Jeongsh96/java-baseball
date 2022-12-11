package baseball;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameTest {
    @Test
    void strikeCounterTest(){
        BaseballGame game = new BaseballGame();
        List<Integer> userInput = Arrays.asList(3,6,9);
        List<Integer> answer = Arrays.asList(1,6,9);

        int result = game.strikeCounter(answer,userInput);

        assertThat(result).isEqualTo(2);
    };
    @Test
    void ballCounterTest(){
        BaseballGame game = new BaseballGame();
        List<Integer> userInput = Arrays.asList(3,6,9);
        List<Integer> answer = Arrays.asList(1,3,9);

        int result = game.strikeCounter(answer,userInput);

        assertThat(result).isEqualTo(1);
    };
}