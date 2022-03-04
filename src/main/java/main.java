import bunco.JeuBunco;
import framework.game.IJeu;

public class main {
    public static void main(String args[]){
        IJeu jeu = new JeuBunco().initialiserJeu();

        jeu.lancerJeu();
    }
}
