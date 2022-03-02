import framework.elements.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

/******************************************************
                    JoueurTest
 * Cours:  LOG121
 * Projet: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
@ExtendWith(MockitoExtension.class)
public class JoueurTest {
    @Mock
    Joueur j1;
    Joueur j2;

    @BeforeEach
    void init() throws Exception{
        j1 = new Joueur("Joueur 1");
        j2 = new Joueur("Joueur 2");
        j1.setScore(25);
        j2.setScore(50);
    }

    @Test
    public void joueurInferieurTest(){
        assertTrue(j1.compareTo(j2) < 0);
    }

    @Test
    public void joueurSuperieurTest(){
        assertTrue(j2.compareTo(j1) > 0);
    }

    @Test
    public void joueurEgauxTest() throws Exception{
        Field score = Joueur.class.getDeclaredField("score");
        score.setAccessible(true);
        score.set(j2, 25);
        assertTrue(j1.compareTo(j2)==0);
    }

    @Test
    public void joueurNullTest(){
        assertThrows(NullPointerException.class, () -> {
            j1.compareTo(null);
        });
    }

    /*
    * Ci-dessous, on vérifie que les setters ont instanciés les valeurs souhaitées
    * et que les getters retournent celles-ci.
    */

    @Test
    public void scoreTest(){
        j1.setScore(29);
        assertEquals(j1.getScore(), 29);
    }

    @Test
    public void nameTest(){
        //Le nom a été donné dans le constructeur par la méthode init(), ont test le getter
        assertEquals(j1.getName(), "Joueur 1");
    }
}
