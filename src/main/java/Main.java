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



            static void initPersonnage() {
            System.out.println("Saisir le nom de votre personnage");
            Scanner scanner = new Scanner(System.in);
            nomPersonnage = scanner.next();
            ptsDeVie = MAX_PTS_VIE;
            ptsBouclier = bouclierActif ? PTS_BOUCLIER : 0;
            System.out.println("OK " + Util.color(nomPersonnage, Color.GREEN) + " ! C'est parti !");
        }

            static short nombreAuHasard(short nb) {
            return (short) Math.round(Math.random() * nb);
        }
            static boolean hasard(double pourcentage) {
            return  Math.random() > pourcentage;
        }
        static short attaqueJoueur(short nbEnnemiPointVie) {
            short degat = nombreAuHasard(MAX_ATTAQUE_JOUEUR);
            System.out.println(Util.color(nomPersonnage, Color.GREEN) + " attaque l'" + Util.color ("ennemi ", Color.YELLOW)
             + "! Il lui fait perdre " + Util.color(degat, Color.PURPLE)+ " points de dommages");

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
        static void attaqueEnnemi() {
            short degatEnnemi =  nombreAuHasard(MAX_ATTAQUE_ENNEMI);
            System.out.print("L'" + Util.color("ennemi ", Color.YELLOW) + "attaque "
            + Util.color(nomPersonnage, Color.GREEN) + " ! ");
            System.out.print("Il lui fait " + degatEnnemi + " points de dommages ! ");

            if (ptsBouclier > 0) {
                short degatrecu =  (short) Math.min(ptsBouclier, degatEnnemi);
                System.out.print("Le bouclier perd " + Util.color(degatrecu, Color.BLUE) + " points. ");
                ptsBouclier -= degatrecu;
                degatEnnemi -= degatrecu;
            }
            if (degatEnnemi > 0) {
                System.out.print(Util.color(nomPersonnage, Color.GREEN) + " perd " + Util.color(degatEnnemi, Color.RED) + " points de vie !" );
                ptsDeVie -= degatEnnemi;
            }
            System.out.println();
        }
        static short attaque(short nbPointEnn, boolean joueurFp) {
            if (nbPointEnn <= 0 || ptsDeVie <= 0) {
                return nbPointEnn;
            }
            else if (joueurFp) {
                nbPointEnn = attaqueJoueur(nbPointEnn);
            }
            else {
                attaqueEnnemi();
            }
            return nbPointEnn;
        }
            static short[] initEnnemis() {
            System.out.println("Combien souhaitez-vous combattre d'ennemis ? ");
            Scanner scannerE = new Scanner(System.in);
            short nbEnnemis = scannerE.nextShort();
            System.out.println("Génération des ennemis...");
            short[] tableauEnn = new short[nbEnnemis];

            for (int i = 0; i < nbEnnemis; i++ ) {
                tableauEnn[i] = (short) nombreAuHasard(MAX_VIE_ENNEMI);
                System.out.println("Ennemi numéro " + (i + 1) + " : " + Util.color(tableauEnn[i], Color.PURPLE));
            }
            return tableauEnn;
        }


    public static void main(String[] args)
    {

        initPersonnage();

        short[] nbEnn = initEnnemis();
        short f = 0;
        for (short listEnnemi : nbEnn) {
            System.out.println("combat avec un ennemi possédant " + Util.color(listEnnemi, Color.PURPLE) + " points de vie" );
            afficherPersonnage();
            System.out.println(" vs ennemie ("  + Util.color((listEnnemi), Color.PURPLE) + ")");
            boolean chance = hasard(0.5);
            while (ptsDeVie > 0 && listEnnemi > 0) {
                listEnnemi = attaque(listEnnemi, chance);
                if (chance) {
                    chance = false;
                } else {
                    chance = true;
                }
                afficherPersonnage();
                System.out.println(" vs ennemie ("  + Util.color((listEnnemi), Color.PURPLE) + ")");
            }
            if (ptsDeVie <= 0) {
                System.out.println((Util.color(nomPersonnage, Color.GREEN) + " est mort mais a tué " + nbEnnemisTues +
                        " ennemis !"));
                System.exit(0);
            } else {
                nbEnnemisTues += 1;
                f += 1;
                if (f == nbEnn.length) {
                    System.out.println(Util.color(nomPersonnage, Color.GREEN) + " a tué tous les ennemis !");
                    System.exit(0);
                }
                System.out.println("L'ennemi est mort ! Au suivant !");
                if (ptsBouclier > 0) {
                System.out.println("Régénération du bouclier : +10");
                ptsBouclier += REGENERATION_BOUCLIER_PAR_TOUR;
                    if (ptsBouclier > 25) {
                        ptsBouclier = 25;
                    }
            }
                System.out.println("Saisisser S pour passer au combat suivant ou n'importe quoi d'autre pour fuir...");
                Scanner scannertest = new Scanner(System.in);
                String lettre = scannertest.nextLine();
                if (!lettre.equals("S")) {
                    System.out.println("Courage fuyons !");
                    System.out.println("Vous avez tué " + nbEnnemisTues + " ennemis mais êtes partis lâchement avant la fin...");
                    System.exit(0);
                } else {
                    continue;
                }



            }
        }
}
}









    /**
     *
     * @param args
     */
