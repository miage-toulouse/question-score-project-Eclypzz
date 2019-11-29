package miagem1;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {
    private QuestionAChoixMultiple question;
    private ArrayList<Integer> indicesBonnesReponses;

    @Before
    public void setUp() throws Exception {
        //given : une instance de question à choix multiple
        indicesBonnesReponses = new ArrayList<Integer>() ;
        indicesBonnesReponses.add(1);
        indicesBonnesReponses.add(2);
        question = new QuestionAChoixMultiple("un énoncé",indicesBonnesReponses);

    }

    @Test
    public void testGetEnonce() {
        //when : quand on demande son énoncé à la question
        String resEnonce = question.getEnonce();
        //then : l'énoncé retourné est l'énoncé fourni à la construction de la question
        assertEquals("un énoncé",resEnonce);
    }


    @Test
    public void testGetScoreForIndiceBonneReponse() {
    int indice = 1;
    float  resScore = question.getScoreForIndice(indice);
    assertEquals(50f,resScore,0.01f);
    }

    @Test
    public void testGetScoreForIndiceMauvaise() {
        int indice = 4;
        float  resScore = question.getScoreForIndice(indice);
        assertEquals(0f,resScore,0.01f);
    }
}