package baseball;

public class ComputerPlayer implements Player{
    @Override
    public Ball submitBall() {
        return new Ball(); // 랜덤으로 구질을 생성
    }
}
