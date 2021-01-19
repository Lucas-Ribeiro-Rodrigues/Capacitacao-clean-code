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
}
