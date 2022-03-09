import bunco.StrategieBunco;
import framework.collections.GameCollection;
import framework.elements.De;
import framework.elements.Joueur;
import framework.game.Jeu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/******************************************************
                    StrategieBuncoTest
 * Cours:  LOG121
 * Laboratoire: Laboratoire 2
 * @author Emerik Latour, Lucas Cimino, Philippe Tanguay-Gaudreau
 * @date 2022/03/02
 *******************************************************/
@ExtendWith(MockitoExtension.class)
public class StrategieBuncoTest {
    //TODO - Implémenter quand StrategieBunco sera finie

    @Mock
    Jeu jeu;
    StrategieBunco strategie;
    Field currentFace;


    @BeforeEach
    void init() throws NoSuchFieldException {
        GameCollection<Joueur> joueurs = new GameCollection<>();
        joueurs.add(new Joueur("Joueur 1"));
        joueurs.add(new Joueur("Joueur 2"));
        joueurs.add(new Joueur("Joueur 3"));

        GameCollection<De> des = new GameCollection<>();
        for (int i = 0; i < 3; i++){
            des.add(new De(6));
        }

        jeu = new Jeu(joueurs,des,new StrategieBunco(),1);

        strategie = spy(new StrategieBunco());

        currentFace = De.class.getDeclaredField("currentFace");
        currentFace.setAccessible(true);


    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void calculerScoreTourBuncoTest() throws Exception{
        Iterator<De> des = jeu.getAllDes();
        while (des.hasNext()){
            De de = des.next();
            currentFace.set(de, 1);
        }

        doNothing().when(strategie).roulerLesDes(any());

        strategie.calculerScoreTour(jeu);

        Joueur gagnant = jeu.getAllJoueurs().next();

        assertEquals(21, gagnant.getScore());
        assertEquals(1, jeu.getCurrentJoueur());

    }

    @Test
    public void calculerScoreTourMiniBuncoTest() throws Exception{
        Iterator<De> des = jeu.getAllDes();
        while (des.hasNext()){
            De de = des.next();
            currentFace.set(de, 5);
        }

        doNothing().when(strategie).roulerLesDes(any());

        strategie.calculerScoreTour(jeu);

        Joueur gagnant = jeu.getAllJoueurs().next();

        assertEquals(5, gagnant.getScore());
        assertEquals(0, jeu.getCurrentJoueur());
    }

    @Test
    public void calculerScoreTour1PointTest() throws Exception{
        De de = jeu.getAllDes().next();

        currentFace.set(de,1);

        doNothing().when(strategie).roulerLesDes(any());

        strategie.calculerScoreTour(jeu);

        Joueur gagnant = jeu.getAllJoueurs().next();

        assertEquals(1, gagnant.getScore());
        assertEquals(0, jeu.getCurrentJoueur());
    }

    @Test
    public void calculerScoreTour0PointTest() throws Exception{
        De de = jeu.getAllDes().next();

        currentFace.set(de,3);

        doNothing().when(strategie).roulerLesDes(any());

        strategie.calculerScoreTour(jeu);

        Joueur gagnant = jeu.getAllJoueurs().next();

        assertEquals(0, gagnant.getScore());
        assertEquals(1, jeu.getCurrentJoueur());
    }

    @Test
    public void calculerGagnantTest(){
        Iterator<Joueur> joueurs = jeu.getAllJoueurs();
        Joueur joueur = null;

        for (int i = 0; i < 2; i++) {
            joueur = joueurs.next();
        }

        joueur.setScore(35);

        jeu.calculerGagnant();

        assertEquals(1, jeu.getIndexGagnant());

    }

}
