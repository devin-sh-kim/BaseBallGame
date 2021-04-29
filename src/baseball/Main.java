package baseball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Player user = new UserPlayer();
        Player computer = new ComputerPlayer();

        boolean continueGame;
        do {
            continueGame = play(user, computer);
        } while (continueGame);

    }

    public static boolean play(Player attacker, Player defender){

        Ball defenceBall = defender.submitBall();

        boolean endGame;

        do{

            Ball attackBall = attacker.submitBall();
            Result judge = Umpire.judge(attackBall, defenceBall);
            endGame = judge.isThreeStrike();

        }while (!endGame);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 ");

        return isContinueGame();
    }

    private static boolean isContinueGame() {

        boolean continueGame = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();

        if(input == 1){
            continueGame = true;
        }

        return continueGame;
    }
}
