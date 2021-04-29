package baseball;

/**
 * 판정 결과
 */
public class Result {

    private final int strikeCount;
    private final int ballCount;

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isThreeStrike(){
        return strikeCount == 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(strikeCount != 0) sb.append(strikeCount).append(" 스트라이크 ");
        if(ballCount != 0) sb.append(ballCount).append(" 볼 ");
        if(strikeCount == 0 && ballCount == 0) sb.append("낫싱");
        return sb.toString();
    }
}
