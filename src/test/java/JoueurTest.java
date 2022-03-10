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
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * Contient les tests unitaires de la classe Joueur
 */
@ExtendWith(MockitoExtension.class)
public class JoueurTest {
    @Mock
    Joueur j1;
    Joueur j2;

    /**
     * Initialise la configuration pour chaque test unitaire.
     */
    @BeforeEach
    void init(){
        j1 = new Joueur("Joueur 1");
        j2 = new Joueur("Joueur 2");
        j1.setScore(25);
        j2.setScore(50);
    }

    /**
     * Compare 2 Joueurs et verifie que le premier est inferieur a l'autre.
     */
    @Test
    public void joueurInferieurTest(){
        assertTrue(j1.compareTo(j2) < 0);
    }

    /**
     * Compare 2 Joueurs et verifie que le premier est superieur a l'autre.
     */
    @Test
    public void joueurSuperieurTest(){
        assertTrue(j2.compareTo(j1) > 0);
    }

    /**
     * Compare 2 Joueurs et verifie que les 2 sont egaux.
     * @throws Exception si l'attribut prive devant être change (score) n'existe pas ou n'est pas accessible.
     */
    @Test
    public void joueurEgauxTest() throws Exception{
        Field score = Joueur.class.getDeclaredField("score"); //throws NoSuchFieldException
        score.setAccessible(true);
        score.set(j2, 25); //throws IllegalAccessException
        assertEquals(0, j1.compareTo(j2));
    }

    /**
     * Compare 1 joueur avec 1 joueur null et verifie que l'exception est lance.
     */
    @Test
    public void joueurNullTest(){
        assertThrows(NullPointerException.class, () -> {
            j1.compareTo(null);
        });
    }

    /*
    * On verifie que le setter a instancie la valeur souhaitee
    * pour l'attribut score et que le getter retourne celle-ci.
    */
    @Test
    public void scoreTest(){
        j1.setScore(29);
        assertEquals(j1.getScore(), 29);
    }

    /*
     * On verifie que le setter a instancie la valeur souhaitee
     * pour l'attribut name et que le getter retourne celle-ci.
     */
    @Test
    public void nameTest(){
        //Le nom a ete donne dans le constructeur par la methode init(), ont test le getter
        assertEquals(j1.getName(), "Joueur 1");
    }
}
