package tennis;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TennisGameTest {

    private static final String PLAYER_1_NAME = "player1Name";

    private static final String PLAYER_2_NAME = "player2Name";

    private static TennisGame tennisGame;

    @BeforeClass
    public static void setUp() {
        tennisGame = new TennisGame(PLAYER_1_NAME, PLAYER_2_NAME);
    }

    @Test
    public void testPlayer1WonPoint() {
        tennisGame.player1.setPoints(0);
        tennisGame.player2.setPoints(0);

        tennisGame.wonPoint(PLAYER_1_NAME);

        Assert.assertEquals(1, tennisGame.player1.getPoints());
    }

    @Test
    public void testPlayer2WonPoint() {
        tennisGame.player1.setPoints(0);
        tennisGame.player2.setPoints(0);

        tennisGame.wonPoint(PLAYER_2_NAME);

        Assert.assertEquals(1, tennisGame.player2.getPoints());
    }

    @Test
    public void testExternalPlayerWonPoint() {
        tennisGame.player1.setPoints(0);
        tennisGame.player2.setPoints(0);

        tennisGame.wonPoint("João");

        Assert.assertEquals(0, tennisGame.player1.getPoints());
        Assert.assertEquals(0, tennisGame.player2.getPoints());
    }

    @Test
    public void testDeuce() {
        tennisGame.player1.setPoints(4);
        tennisGame.player2.setPoints(4);

        Assert.assertEquals("Deuce", tennisGame.getScore());
    }

    @Test
    public void testLoveAll() {
        tennisGame.player1.setPoints(0);
        tennisGame.player2.setPoints(0);

        Assert.assertEquals("Love-All", tennisGame.getScore());
    }

    @Test
    public void testFifteenAll() {
        tennisGame.player1.setPoints(1);
        tennisGame.player2.setPoints(1);

        Assert.assertEquals("Fifteen-All", tennisGame.getScore());
    }

    @Test
    public void testThirtyAll() {
        tennisGame.player1.setPoints(2);
        tennisGame.player2.setPoints(2);

        Assert.assertEquals("Thirty-All", tennisGame.getScore());
    }

    @Test
    public void testLoveFifteen() {
        tennisGame.player1.setPoints(0);
        tennisGame.player2.setPoints(1);

        Assert.assertEquals("Love-Fifteen", tennisGame.getScore());
    }

    @Test
    public void testLoveThirty() {
        tennisGame.player1.setPoints(0);
        tennisGame.player2.setPoints(2);

        Assert.assertEquals("Love-Thirty", tennisGame.getScore());
    }

    @Test
    public void testLoveForty() {
        tennisGame.player1.setPoints(0);
        tennisGame.player2.setPoints(3);

        Assert.assertEquals("Love-Forty", tennisGame.getScore());
    }

    @Test
    public void testFifteenLove() {
        tennisGame.player1.setPoints(1);
        tennisGame.player2.setPoints(0);

        Assert.assertEquals("Fifteen-Love", tennisGame.getScore());
    }

    @Test
    public void testThirtyLove() {
        tennisGame.player1.setPoints(2);
        tennisGame.player2.setPoints(0);

        Assert.assertEquals("Thirty-Love", tennisGame.getScore());
    }

    @Test
    public void testFortyLove() {
        tennisGame.player1.setPoints(3);
        tennisGame.player2.setPoints(0);

        Assert.assertEquals("Forty-Love", tennisGame.getScore());
    }


    @Test
    public void testFifteenThirty() {
        tennisGame.player1.setPoints(1);
        tennisGame.player2.setPoints(2);

        Assert.assertEquals("Fifteen-Thirty", tennisGame.getScore());
    }


    @Test
    public void testFifteenForty() {
        tennisGame.player1.setPoints(1);
        tennisGame.player2.setPoints(3);

        Assert.assertEquals("Fifteen-Forty", tennisGame.getScore());
    }


    @Test
    public void testThirtyFifteen() {
        tennisGame.player1.setPoints(2);
        tennisGame.player2.setPoints(1);

        Assert.assertEquals("Thirty-Fifteen", tennisGame.getScore());
    }

    @Test
    public void testThirtyForty() {
        tennisGame.player1.setPoints(2);
        tennisGame.player2.setPoints(3);

        Assert.assertEquals("Thirty-Forty", tennisGame.getScore());
    }

    @Test
    public void testFortyFifteen() {
        tennisGame.player1.setPoints(3);
        tennisGame.player2.setPoints(1);

        Assert.assertEquals("Forty-Fifteen", tennisGame.getScore());
    }

    @Test
    public void testFortyThirty() {
        tennisGame.player1.setPoints(3);
        tennisGame.player2.setPoints(2);

        Assert.assertEquals("Forty-Thirty", tennisGame.getScore());
    }

    @Test
    public void testAdvantagePlayer1() {
        tennisGame.player1.setPoints(4);
        tennisGame.player2.setPoints(3);

        Assert.assertEquals(String.format("Advantage %s", PLAYER_1_NAME), tennisGame.getScore());
    }

    @Test
    public void testAdvantagePlayer2() {
        tennisGame.player1.setPoints(3);
        tennisGame.player2.setPoints(4);

        Assert.assertEquals(String.format("Advantage %s", PLAYER_2_NAME), tennisGame.getScore());
    }

    @Test
    public void testPlayer1Win() {
        tennisGame.player1.setPoints(4);
        tennisGame.player2.setPoints(2);

        Assert.assertEquals(String.format("Win for %s", PLAYER_1_NAME), tennisGame.getScore());
    }

    @Test
    public void testPlayer2Win() {
        tennisGame.player1.setPoints(2);
        tennisGame.player2.setPoints(4);

        Assert.assertEquals(String.format("Win for %s", PLAYER_2_NAME), tennisGame.getScore());
    }

}
