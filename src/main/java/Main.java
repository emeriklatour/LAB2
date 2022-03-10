import bunco.JeuBunco;
import framework.game.IJeu;

public class Main {
    public static void main(String[] args){
        IJeu jeu = new JeuBunco().initialiserJeu();

        jeu.lancerJeu();
    }
}
