import framework.elements.De;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        FieldSetter.setField(de1, de1.getClass().getDeclaredField("currentFace"), 4);
        FieldSetter.setField(de2, de2.getClass().getDeclaredField("currentFace"), 5);
        assertTrue(de1.compareTo(de2) < 0);
    }

    @Test
    public void deSuperieurTest() throws Exception {
        FieldSetter.setField(de1, de1.getClass().getDeclaredField("currentFace"), 4);
        FieldSetter.setField(de2, de2.getClass().getDeclaredField("currentFace"), 5);
        assertTrue(de2.compareTo(de1)>0);
    }

    @Test
    public void memeDeTest() throws Exception {
        FieldSetter.setField(de1, de1.getClass().getDeclaredField("currentFace"), 4);
        FieldSetter.setField(de2, de2.getClass().getDeclaredField("currentFace"), 4);
        assertTrue(de1.compareTo(de2)==0);
    }

    @Test
    public void deNullTest() throws Exception {
        FieldSetter.setField(de1, de1.getClass().getDeclaredField("currentFace"), 4);
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


}
