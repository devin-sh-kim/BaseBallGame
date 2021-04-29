package baseball;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 서로 다른 3개의 숫자(구질)
 */
public class Ball {

    private final List<Integer> digits = new ArrayList<>();

    public Ball(){
        this.generateDigits();
    }

    public Ball(String playerInput){
        if(playerInput == null) throw new IllegalArgumentException("player input is null");
        if(playerInput.length() != 3) throw new IllegalArgumentException("player input length is not 3");
        for (int i = 0; i < playerInput.length(); i++) {
            digits.add(Integer.parseInt(String.valueOf(playerInput.charAt(i))));
        }
    }

    public List<Integer> getDigits() {
        return Collections.unmodifiableList(this.digits);
    }

    private void generateDigits(){
        while(digits.size() < 3) {
            int randomDigit = RandomUtil.getRandomInt(Const.MIN_BALL_NUMBER, Const.MAX_BALL_NUMBER);
            this.addDigit(randomDigit);
        }
    }

    private void addDigit(int digit){
        if(digits.contains(digit)) {
            return;
        }
        digits.add(digit);
    }

    @Override
    public String toString() {
        return this.digits.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
