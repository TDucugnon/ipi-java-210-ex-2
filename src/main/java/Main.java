import java.util.Scanner;

public class Main {
    static final short MAX_PTS_VIE = 100;
    static final short PTS_BOUCLIER = 25;
    static final short MAX_ATTAQUE_ENNEMI = 5;
    static final short MAX_VIE_ENNEMI = 30;
    static final short MAX_ATTAQUE_JOUEUR = 5;
    static final short REGENERATION_BOUCLIER_PAR_TOUR = 10;

    static String nomPersonnage;
    static short ptsDeVie;
    static short ptsBouclier;
    static short nbEnnemisTues = 0;
    static boolean bouclierActif = true;
        public static void main(String[] args)
        {
            System.out.println("Hello World");
        }
        static void initPersonnage() {
            System.out.println("Saisir le nom de votre personnage");
            Scanner scanner = new Scanner(System.in);
            nomPersonnage = scanner.next();
            ptsDeVie = MAX_PTS_VIE;
            ptsBouclier = bouclierActif ? ptsBouclier : 0;
            System.out.println("OK " + Util.color(nomPersonnage, Color.GREEN) + " ! C'est parti !");
        }

        static boolean hasard(double pourcentage) {
            return  Math.random() > pourcentage;
        }
        static short nombreAuHasard(short nb) {
            return (short) Math.round(Math.random() * nb);
        }
        static short attaqueJoueur(short nbEnnemiPointVie) {
            short degat = nombreAuHasard(MAX_ATTAQUE_JOUEUR);
            System.out.println(Util.color(nomPersonnage, Color.GREEN) + "attaque"
            + Util.color("l'ennemi !", Color.YELLOW) + "il lui fait perdre" + Util.color(ptsDeVie, Color.PURPLE)
            + "points de dommages");
            nbEnnemiPointVie -= degat;
            return nbEnnemiPointVie;
        }
        static void afficherPersonnage() {
            System.out.print(Util.color(nomPersonnage, Color.GREEN) + " (" + Util.color(ptsDeVie, Color.RED));
                if (bouclierActif) {
                    System.out.print(" " + Util.color(ptsBouclier, Color.BLUE));
                }
            System.out.print(")");
        }
        static short attaqueEnnemi() {
            short degatEnnemi =  nombreAuHasard(MAX_ATTAQUE_ENNEMI);
            System.out.print("L'" + Util.color("ennemie", Color.YELLOW) + "attaque"
            + Util.color(nomPersonnage, Color.GREEN) + "!" + "il lui fait" + degatEnnemi + "points de dommages !");

            if (ptsBouclier > 0) {
                short degatrecu -= ptsBouclier

            }



        }



}


    /**
     *
     * @param args
     */
