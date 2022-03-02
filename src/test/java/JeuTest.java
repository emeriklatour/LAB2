import framework.bunco.JeuBunco;
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
 * Projet: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
@ExtendWith(MockitoExtension.class)
public class JeuTest {

    @Mock
    Jeu jeu;

    @BeforeEach
    void init(){
        JeuBunco bunco = new JeuBunco();
        jeu = (Jeu) bunco.initialiserJeu();
    }

    @Test
    public void getAllJoueursTest(){
        assertNotNull(jeu.getAllJoueurs());
    }

    @Test
    public void getAllDesTest(){
        assertNotNull(jeu.getAllDes());
    }

    @Test
    public void getCurrentTurnNbTest() throws Exception{
        Field turnNb = Jeu.class.getDeclaredField("currentTurnNb");
        turnNb.setAccessible(true);
        turnNb.set(jeu, 3);
        assertEquals(jeu.getCurrentTurnNb(), 3);
    }

    @Test
    public void indexGagnantTest(){
        jeu.setIndexGagnant(2);
        assertEquals(jeu.getIndexGagnant(), 2);
    }

    @Test
    public void currentJoueurTest(){
        jeu.setCurrentJoueur(1);
        assertEquals(jeu.getCurrentJoueur(), 1);
    }

    @Test
    public void lancerJeuTest(){
        //TODO - Quand stratégieBunco va être faite
    }

}
