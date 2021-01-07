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
            ptsBouclier = PTS_BOUCLIER;
            System.out.println("OK " + Util.color(nomPersonnage, Color.GREEN) + " ! C'est parti !");
        }

        static boolean hasard(double pourcentage) {
            return pourcentage < Math.random();
        }
        static nombreAuHasard(short nb) {
            Math.random(0, nb)
        }

    }


    /**
     *
     * @param args
     */
