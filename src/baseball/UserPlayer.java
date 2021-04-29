package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserPlayer implements Player{
    @Override
    public Ball submitBall() {
        // System.in 으로 구질을 생성

        String userInput = null;

        Scanner scanner = new Scanner(System.in);

        boolean valid = false;

        while(!valid) {
            printUserInputMessage();
            userInput = scanner.next();
            valid = validateUserInput(userInput);
        }

        return new Ball(userInput);
    }

    private void printUserInputMessage() {
        System.out.print(Const.MESSAGE_INPUT);
    }

    private boolean validateUserInput(String userInput) {

        if(userInput == null){
            System.out.println("NULL");
            return false;
        }

        if(userInput.length() != Const.BALL_DIGIT_LENGTH){
            System.out.println("LENGTH");
            return false;
        }

        if(!Pattern.matches(Const.USER_INPUT_RULE, userInput)){
            System.out.println("REGEX");
            return false;
        }

        return true;
    }
}
