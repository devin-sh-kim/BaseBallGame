package baseball;

import java.util.List;

/**
 * 심판
 */
public class Umpire {

    public static Result judge(Ball attack, Ball defence){

        int strikeCount = getStrikeCount(attack, defence);
        int ballCount = getBallCount(attack, defence);

        Result result = new Result(strikeCount, ballCount);
        System.out.println(result);

        return result;
    }

    private static int getStrikeCount(Ball attack, Ball defence) {
        int strikeCount = 0;

        List<Integer> attackDigits = attack.getDigits();
        List<Integer> defenceDigits = defence.getDigits();

        for (int i = 0; i < Const.BALL_DIGIT_LENGTH; i++) {
            strikeCount += attackDigits.get(i).equals(defenceDigits.get(i)) ? 1 : 0;
        }
        return strikeCount;
    }

    private static int getBallCount(Ball attack, Ball defence) {
        int ballCount = 0;

        for (int i = 0; i < Const.BALL_DIGIT_LENGTH; i++) {
            ballCount += getBallCountAtPosition(attack.getDigits().get(i), defence.getDigits(), i);
        }

        return ballCount;
    }

    private static int getBallCountAtPosition(int attackDigit, List<Integer> defenceDigits, int position) {
        int ballCount = 0;
        for (int i = 0; i < Const.BALL_DIGIT_LENGTH; i++) {
            if(i == position){
                continue;
            }
            ballCount += attackDigit == defenceDigits.get(i) ? 1 : 0;
        }

        return ballCount;
    }


}
