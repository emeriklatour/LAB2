import bunco.JeuBunco;
import framework.game.Jeu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;


/******************************************************
                        JeuTest
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * Contient les tests unitaires de la classe Jeu.
 */
@ExtendWith(MockitoExtension.class)
public class JeuTest {
    @Mock
    Jeu jeu;

    /**
     * Initialise la configuration pour chaque test unitaire.
     */
    @BeforeEach
    void init(){
        JeuBunco bunco = new JeuBunco();
        jeu = (Jeu) bunco.initialiserJeu();
    }

    /**
     * Verifie que la methode getAllJoueurs() retourne bel et bien la liste de joueurs.
     */
    @Test
    public void getAllJoueursTest(){
        assertNotNull(jeu.getAllJoueurs());
    }

    /**
     * Verifie que la methode getAllJoueurs() retourne bel et bien la liste de des.
     */
    @Test
    public void getAllDesTest(){
        assertNotNull(jeu.getAllDes());
    }

    /**
     * Verifie que la methode getCurrentTurnNb() retourne le bon numero de tour courant.
     * @throws Exception si l'attribut prive devant être change (currentTurnNb) n'existe pas ou n'est pas accessible.
     */
    @Test
    public void getCurrentTurnNbTest() throws Exception{
        Field turnNb = Jeu.class.getDeclaredField("currentTurnNb"); //throws NoSuchFieldException
        turnNb.setAccessible(true);
        turnNb.set(jeu, 3); //throws IllegalAccessException
        assertEquals(jeu.getCurrentTurnNb(), 3);
    }

    /**
     * Verifie que le setter et le getter de l'attribut indexGagnant fonctionne comme prevu.
     */
    @Test
    public void indexGagnantTest(){
        jeu.setIndexGagnant(2);
        assertEquals(jeu.getIndexGagnant(), 2);
    }

    /**
     * Verifie que le setter et le getter de l'attribut currentJoueur fonctionne comme prevu.
     */
    @Test
    public void currentJoueurTest(){
        jeu.setCurrentJoueur(1);
        assertEquals(jeu.getCurrentJoueur(), 1);
    }

    /**
     * Verifie que la methode lancerJeu fonctionne et que le jeu se termine après le nombre de tours prevu.
     * N.B. Si le nombre de tours est 6, le jeu effectue 6 tours et arrête au 7e.
     */
    @Test
    public void lancerJeuTest(){
        jeu.lancerJeu();
        assertEquals(7, jeu.getCurrentTurnNb());
    }

}
