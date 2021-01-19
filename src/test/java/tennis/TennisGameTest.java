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
    public void testePlayer1GanhouPonto() {
        tennisGame.m_score1 = 0;
        tennisGame.m_score2 = 0;

        tennisGame.wonPoint(PLAYER_1_NAME);

        Assert.assertEquals(1, tennisGame.m_score1);
    }

    @Test
    public void testePlayer2GanhouPonto() {
        tennisGame.m_score1 = 0;
        tennisGame.m_score2 = 0;

        tennisGame.wonPoint(PLAYER_2_NAME);

        Assert.assertEquals(1, tennisGame.m_score2);
    }

    @Test
    public void testeDeuce() {
        tennisGame.m_score1 = 4;
        tennisGame.m_score2 = 4;

        Assert.assertEquals("Deuce", tennisGame.getScore());
    }

    @Test
    public void testeLoveAll() {
        tennisGame.m_score1 = 0;
        tennisGame.m_score2 = 0;

        Assert.assertEquals("Love-All", tennisGame.getScore());
    }

    @Test
    public void testeFifteenAll() {
        tennisGame.m_score1 = 1;
        tennisGame.m_score2 = 1;

        Assert.assertEquals("Fifteen-All", tennisGame.getScore());
    }

    @Test
    public void testeThirtyAll() {
        tennisGame.m_score1 = 2;
        tennisGame.m_score2 = 2;

        Assert.assertEquals("Thirty-All", tennisGame.getScore());
    }

    @Test
    public void testLoveFifteen() {
        tennisGame.m_score1 = 0;
        tennisGame.m_score2 = 1;

        Assert.assertEquals("Love-Fifteen", tennisGame.getScore());
    }

    @Test
    public void testLoveThirty() {
        tennisGame.m_score1 = 0;
        tennisGame.m_score2 = 2;

        Assert.assertEquals("Love-Thirty", tennisGame.getScore());
    }

    @Test
    public void testLoveForty() {
        tennisGame.m_score1 = 0;
        tennisGame.m_score2 = 3;

        Assert.assertEquals("Love-Forty", tennisGame.getScore());
    }

    @Test
    public void testFifteenLove() {
        tennisGame.m_score1 = 1;
        tennisGame.m_score2 = 0;

        Assert.assertEquals("Fifteen-Love", tennisGame.getScore());
    }

    @Test
    public void testThirtyLove() {
        tennisGame.m_score1 = 2;
        tennisGame.m_score2 = 0;

        Assert.assertEquals("Thirty-Love", tennisGame.getScore());
    }

    @Test
    public void testFortyLove() {
        tennisGame.m_score1 = 3;
        tennisGame.m_score2 = 0;

        Assert.assertEquals("Forty-Love", tennisGame.getScore());
    }


    @Test
    public void testFifteenThirty() {
        tennisGame.m_score1 = 1;
        tennisGame.m_score2 = 2;

        Assert.assertEquals("Fifteen-Thirty", tennisGame.getScore());
    }


    @Test
    public void testFifteenForty() {
        tennisGame.m_score1 = 1;
        tennisGame.m_score2 = 3;

        Assert.assertEquals("Fifteen-Forty", tennisGame.getScore());
    }


    @Test
    public void testThirtyFifteen() {
        tennisGame.m_score1 = 2;
        tennisGame.m_score2 = 1;

        Assert.assertEquals("Thirty-Fifteen", tennisGame.getScore());
    }

    @Test
    public void testThirtyForty() {
        tennisGame.m_score1 = 2;
        tennisGame.m_score2 = 3;

        Assert.assertEquals("Thirty-Forty", tennisGame.getScore());
    }

    @Test
    public void testFortyFifteen() {
        tennisGame.m_score1 = 3;
        tennisGame.m_score2 = 1;

        Assert.assertEquals("Forty-Fifteen", tennisGame.getScore());
    }

    @Test
    public void testFortyThirty() {
        tennisGame.m_score1 = 3;
        tennisGame.m_score2 = 2;

        Assert.assertEquals("Forty-Thirty", tennisGame.getScore());
    }

    @Test
    public void testAdvantagePlayer1() {
        tennisGame.m_score1 = 4;
        tennisGame.m_score2 = 3;

        Assert.assertEquals(String.format("Advantage %s", PLAYER_1_NAME), tennisGame.getScore());
    }

    @Test
    public void testAdvantagePlayer2() {
        tennisGame.m_score1 = 3;
        tennisGame.m_score2 = 4;

        Assert.assertEquals(String.format("Advantage %s", PLAYER_2_NAME), tennisGame.getScore());
    }

    @Test
    public void testPlayer1Win() {
        tennisGame.m_score1 = 4;
        tennisGame.m_score2 = 2;

        Assert.assertEquals(String.format("Win for %s", PLAYER_1_NAME), tennisGame.getScore());
    }

    @Test
    public void testPlayer2Win() {
        tennisGame.m_score1 = 2;
        tennisGame.m_score2 = 4;

        Assert.assertEquals(String.format("Win for %s", PLAYER_2_NAME), tennisGame.getScore());
    }

}
