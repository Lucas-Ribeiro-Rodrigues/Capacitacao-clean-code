package enums;

import java.util.Arrays;

public enum ScoreLabelEnum {
    LOVE("Love", 0),
    FIFTEEN("Fifteen", 1),
    THIRTY("Thirty", 2),
    FORTY("Forty", 3),
    DEUCE("Deuce", -1);

    private String score;

    private int point;

    ScoreLabelEnum(String label, int point) {
        this.score = label;
        this.point = point;
    }

    public String getScore() {
        return this.score;
    }

    public int getPoint() {
        return this.point;
    }

    public static String getScoreFromPoint(int point) {
        return Arrays.stream(ScoreLabelEnum.values())
                .filter(scoreLabelEnum -> scoreLabelEnum.getPoint() == point)
                .findFirst()
                .orElse(DEUCE)
                .getScore();
    }
}
