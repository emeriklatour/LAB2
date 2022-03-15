import framework.elements.De;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

/******************************************************
                        DeTest
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/

/**
 * Contient les tests unitaires de la classe De.
 */
@ExtendWith(MockitoExtension.class)
public class DeTest {
    @Mock
    De de1;
    De de2;

    /**
     * Initialise la configuration pour chaque test unitaire.
     */
    @BeforeEach
    void init(){
        de1 = new De(6);
        de2 = new De(6);
    }

    /**
     * Compare 2 des et verifie que le premier est inferieur a l'autre.
     * @throws Exception si l'attribut prive devant être change (currentFace) n'existe pas ou n'est pas accessible.
     */
    @Test
    public void deInferieurTest() throws Exception {
        Field currentFace = De.class.getDeclaredField("currentFace"); //throws NoSuchFieldException
        currentFace.setAccessible(true);
        currentFace.set(de1, 4); //throws IllegalAccessException
        currentFace.set(de2, 5); //throws IllegalAccessException
        assertTrue(de1.compareTo(de2) < 0);
    }

    /**
     * Compare 2 des et verifie que le premier est superieur a l'autre.
     * @throws Exception si l'attribut prive devant être change (currentFace) n'existe pas ou n'est pas accessible.
     */
    @Test
    public void deSuperieurTest() throws Exception {
        Field currentFace = De.class.getDeclaredField("currentFace"); //throws NoSuchFieldException
        currentFace.setAccessible(true);
        currentFace.set(de1, 4); //throws IllegalAccessException
        currentFace.set(de2, 5); //throws IllegalAccessException
        assertTrue(de2.compareTo(de1)>0);
    }

    /**
     * Compare 2 des et verifie que les 2 sont egaux.
     * @throws Exception si l'attribut prive devant être change (currentFace) n'existe pas ou n'est pas accessible.
     */
    @Test
    public void memeDeTest() throws Exception {
        Field currentFace = De.class.getDeclaredField("currentFace"); //throws NoSuchFieldException
        currentFace.setAccessible(true);
        currentFace.set(de1, 4); //throws IllegalAccessException
        currentFace.set(de2, 4); //throws IllegalAccessException
        assertEquals(0, de1.compareTo(de2));
    }

    /**
     * Compare 1 de avec 1 de null et verifie que l'exception est lance.
     * @throws Exception si l'attribut prive devant être change (currentFace) n'existe pas ou n'est pas accessible.
     */
    @Test
    public void deNullTest() throws Exception {
        Field currentFace = De.class.getDeclaredField("currentFace"); //throws NoSuchFieldException
        currentFace.setAccessible(true);
        currentFace.set(de1, 4); //throws IllegalAccessException
        assertThrows(NullPointerException.class, () -> {
            de1.compareTo(null);
        });
    }

    /**
     * Verifie que la methode roulerDe() ne roule pas plus bas que 1 et plus haut que la nombre de faces donnees.
     * @throws Exception si l'attribut prive devant être change (nbFaces) n'existe pas ou n'est pas accessible.
     */
    @Test
    public void deRangeTest() throws Exception {
        de1.roulerDe();
        Field nbFacesField = de1.getClass().getDeclaredField("nbFaces"); //throws NoSuchFieldException
        nbFacesField.setAccessible(true);
        int nbFaces = nbFacesField.getInt(de1); //throws IllegalAccessException
        assertTrue(de1.getCurrentFace() >= 1 && de1.getCurrentFace() <= nbFaces );
    }
}
