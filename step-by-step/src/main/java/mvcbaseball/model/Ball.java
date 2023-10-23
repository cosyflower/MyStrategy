package mvcbaseball.model;

public class Ball {
    private final int digit;
    private final int value;

    public Ball(int digit, int value) {
        this.digit = digit;
        this.value = value;
    }

    public Result compareBallCondition(Ball otherBall) {
        // 조건 만족하는 개수 확인하기
        int trueCount = 0;
        getSameConditionCount(otherBall, trueCount);

        if (trueCount == 2) {
            return Result.STRIKE;
        }

        if (trueCount == 1) {
            return Result.BALL;
        }

        return Result.NOTHING;
    }

    private void getSameConditionCount(Ball otherBall, int trueCount) {
        if (hasSameValue(otherBall)) {
            trueCount++;
        }

        if (hasSameDigit(otherBall)) {
            trueCount++;
        }
    }

    private boolean hasSameValue(Ball otherBall) {
        return value == otherBall.getValue();
    }

    private boolean hasSameDigit(Ball otherBall) {
        return digit == otherBall.getDigit();
    }

    public int getDigit() {
        return digit;
    }

    public int getValue() {
        return value;
    }
}
