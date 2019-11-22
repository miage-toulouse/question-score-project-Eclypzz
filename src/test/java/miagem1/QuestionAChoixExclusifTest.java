package miagem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionAChoixExclusifTest {

    QuestionAChoixExclusif question;
    // Given When Then : l'état du monde
    @Before
    public void setUp() throws Exception {
        //given : une instance de question à choix exclusif
        question = new QuestionAChoixExclusif("un énoncé",2);

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
        //when : quand l'étudiant fournit l'indice de la bonne réponse
    int indiceEtudiant = 2;
    // and : on demande le score de l'indice à la question
    float resScore = question.getScoreForIndice(indiceEtudiant);
    //then : le score obtenu est 100
    assertEquals(100f,resScore,0.01f);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        //when : quand l'étudiant fournit l'indice de la bonne réponse
        int indiceEtudiant = 3;
        int indiceEtudiant2 = 1;

        // and : on demande le score de l'indice à la question
        float resScore = question.getScoreForIndice(indiceEtudiant);
        float resScore2 = question.getScoreForIndice(indiceEtudiant2);

        //then : le score obtenu est 0
        assertEquals(0f,resScore,0.01f);
        assertEquals(0f,resScore2,0.01f);

    }
}