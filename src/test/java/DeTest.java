import framework.elements.De;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/******************************************************
                        DeTest
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
@ExtendWith(MockitoExtension.class)
public class DeTest {
    @Mock
    De de1;
    De de2;

    @BeforeEach
    void init(){
        de1 = new De(6);
        de2 = new De(6);
    }

    @Test
    public void deInferieurTest() throws Exception {
        Field currentFace = De.class.getDeclaredField("currentFace");
        currentFace.setAccessible(true);
        currentFace.set(de1, 4);
        currentFace.set(de2, 5);
        assertTrue(de1.compareTo(de2) < 0);
    }

    @Test
    public void deSuperieurTest() throws Exception {
        Field currentFace = De.class.getDeclaredField("currentFace");
        currentFace.setAccessible(true);
        currentFace.set(de1, 4);
        currentFace.set(de2, 5);
        assertTrue(de2.compareTo(de1)>0);
    }

    @Test
    public void memeDeTest() throws Exception {
        Field currentFace = De.class.getDeclaredField("currentFace");
        currentFace.setAccessible(true);
        currentFace.set(de1, 4);
        currentFace.set(de2, 4);
        assertTrue(de1.compareTo(de2)==0);
    }

    @Test
    public void deNullTest() throws Exception {
        Field currentFace = De.class.getDeclaredField("currentFace");
        currentFace.setAccessible(true);
        currentFace.set(de1, 4);
        assertThrows(NullPointerException.class, () -> {
            de1.compareTo(null);
        });
    }

    @Test
    public void deRangeTest() throws Exception {
        de1.roulerDe();
        Field nbFacesField = de1.getClass().getDeclaredField("nbFaces");
        nbFacesField.setAccessible(true);
        int nbFaces = nbFacesField.getInt(de1);
        assertTrue(de1.getCurrentFace() >= 1 && de1.getCurrentFace() <= nbFaces );
    }

    //Exemple de mock pour d'autres tests, à enlever plus tard
    /*
        De de = mock(De.class, withSettings().defaultAnswer(Answers.CALLS_REAL_METHODS).useConstructor(6));
        doAnswer(invocationOnMock -> {
            de.setCurrentFace(4);
            return  null;
        }).when(de).roulerDe();
        de.roulerDe();
        System.out.println(de.getCurrentFace());

        */

}
