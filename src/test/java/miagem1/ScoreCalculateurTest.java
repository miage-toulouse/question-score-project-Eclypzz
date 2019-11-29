package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {
    private QuestionAChoixMultiple questionAChoixMultiple;
    private ScoreCalculateur scoreCalculateur;
    @Before
    public void setUp() throws Exception {

         questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
         scoreCalculateur = new ScoreCalculateur();
    }

    @Test
    public void calculeScoreToutesBonnesReponses() {
        float  resScore = scoreCalculateur.calculeScore(new ArrayList<Integer>(Arrays.asList(2,3,5)),questionAChoixMultiple);

        assertEquals(100f,resScore,0.01f);
    }

    @Test
    public void calculeScore2BonnesReponses() {
        float  resScore = scoreCalculateur.calculeScore(new ArrayList<Integer>(Arrays.asList(2,3)),questionAChoixMultiple);

        assertEquals((2f*100f/3f),resScore,0.01f);
    }

    @Test
    public void calculeScoreMauvaises() {
        float  resScore = scoreCalculateur.calculeScore(new ArrayList<Integer>(Arrays.asList(1,4)),questionAChoixMultiple);
        assertEquals(0f,resScore,0.01f);
    }

    @Test
    public void calculeScoreToutesReponses() {
        float  resScore = scoreCalculateur.calculeScore(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)),questionAChoixMultiple);
        assertEquals(0f,resScore,0.01f);
    }

    @Test
    public void calculeScore1Mauvaise2BonnesReponses() {
        float  resScore = scoreCalculateur.calculeScore(new ArrayList<Integer>(Arrays.asList(1,2,3)),questionAChoixMultiple);
        assertEquals(16.66f,resScore,0.01f);
    }
}