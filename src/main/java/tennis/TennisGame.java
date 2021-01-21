package tennis;

import enums.ScoreLabelEnum;
import to.Player;

public class TennisGame {

    private static final String EQUAL_POINTS_SUFFIX = "All";

    protected Player player1;

    protected Player player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.incrementScore();
        } else if (playerName.equals(player2.getName())) {
            player2.incrementScore();
        }
    }

    public String getScore() {
        return onePlayerWonOrHasAdvantage(player1, player2) ? getWinOrAdvantageScore(player1, player2) :
                getPointsScore(player1, player2);
    }

    private boolean onePlayerWonOrHasAdvantage(Player player1, Player player2) {
        return (player1.getPoints() >= 4 || player2.getPoints() >= 4) && player1.getPoints() != player2.getPoints();
    }

    private String getWinOrAdvantageScore(Player player1, Player player2) {
        int pointsDifference = Math.abs(player1.getPoints() - player2.getPoints());

        Player winningPlayer = findWinningPlayer(player1, player2);

        return pointsDifference == 1 ? String.format("Advantage %s", winningPlayer.getName()) : String.format("Win " +
                "for %s", winningPlayer.getName());
    }

    private String getPointsScore(Player player1, Player player2) {
        int player1Points = player1.getPoints();
        int player2Points = player2.getPoints();

        return player1Points == player2Points ? getEqualPointsScore(player1Points) : getDiffPointsScore(player1Points
                , player2Points);
    }

    private Player findWinningPlayer(Player player1, Player player2) {
        return player1.getPoints() > player2.getPoints() ? player1 : player2;
    }

    private String getEqualPointsScore(int player1Score) {
        String scorePlayer1 = ScoreLabelEnum.getScoreFromPoint(player1Score);

        return scorePlayer1.equals(ScoreLabelEnum.DEUCE.getScore()) ? ScoreLabelEnum.DEUCE.getScore() :
                scorePlayer1 + "-" + EQUAL_POINTS_SUFFIX;
    }

    private String getDiffPointsScore(int player1Score, int player2Score) {
        String scorePlayer1 = ScoreLabelEnum.getScoreFromPoint(player1Score);
        String scorePlayer2 = ScoreLabelEnum.getScoreFromPoint(player2Score);

        return scorePlayer1 + "-" + scorePlayer2;
    }
}
