import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Decharge {
    private static DecimalFormat df = new DecimalFormat("#.000");

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    public static double calculerDistance(int x1, int y1, int x2, int y2){
       return Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
    }

    public static int plusProche(int x, int y, int[] coordonneesHabitations){
        double distance = Double.MAX_VALUE;
        int position = 0;
        for(int i =0; i < coordonneesHabitations.length; i += 2){
            if(calculerDistance(x, y, coordonneesHabitations[i], coordonneesHabitations[i+1]) < distance){
                distance = calculerDistance(x, y, coordonneesHabitations[i], coordonneesHabitations[i+1]);
                position = i / 2 ;
            }
        }

        return position;
    }

    public static int[] troisPlusProches(int x, int y, int[] coordonneesHabitations){
        int[] temp = new int[coordonneesHabitations.length];
        //Preparer une copie du tableau pour ne pas alterer le tableau objet du traitement
        for(int i =0; i < temp.length; ++i){
            temp[i] = coordonneesHabitations[i];
        }

        int[] troisPlusProches = new int[2 * 3];
        for(int i = 0; i < troisPlusProches.length / 2; ++i){
            int position = plusProche(x, y, temp);
            troisPlusProches[2 * i] = temp[2 * position];
            troisPlusProches[2 * i + 1] = temp[2 * position + 1];

            temp[2 * position] = Integer.MAX_VALUE;
            temp[2 * position+1] = Integer.MAX_VALUE;
        }

        return troisPlusProches;
    }

    public static int[] meilleurePlace(int x, int y, int[] coordonneesHabitations){
        int[] troisPlusProches = troisPlusProches(x, y, coordonneesHabitations);
        int[] meilleurePlace = new int[2];

        meilleurePlace[0] = (troisPlusProches[0] + troisPlusProches[2] + troisPlusProches[4] ) / 3;
        meilleurePlace[1] = (troisPlusProches[1] + troisPlusProches[3] + troisPlusProches[5] ) / 3;

        return meilleurePlace;
    }

    /*******************************************
     * Ne rien modifier apres cette ligne.
     *******************************************/

    public static void afficheTroisPlusProches(int x, int y, int[] coordonneesHabitations) {
        int[] tpp = troisPlusProches(x, y, coordonneesHabitations);

        System.out.println("(" + x + "," + y + ") est a :");
        for (int i = 0 ; i < 3 ; i++) {
            System.out.println("    " + df.format(calculerDistance(x, y, tpp[2*i], tpp[2*i+1])) + " de (" + tpp[2*i] + "," + tpp[2*i+1] + ")");
        }
    }



    //PROGRAMME PRINCIPAL
    public static void main(String args[]) {

        int[] coordonneesHabitations = {
                9, 30, 18, 8, 3, 18, 25, 36
        };

        // Lecture des donnees
        Scanner clavier = new Scanner(System.in);
        System.out.print("Entrez la coordonnee x de la decharge: ");
        int x = clavier.nextInt();
        System.out.print("Entrez le coordonnee y de la decharge: ");
        int y = clavier.nextInt();

        // trouve les coordonnees de l'habitation la plus proche
        // (identifiees par l'indice correspondant dans le tableau
        // de coordonnees)
        int plusProche = plusProche(x, y, coordonneesHabitations);
        System.out.println("--- Question 1 ---");
        System.out.println("Coordonnees de l'habitation la plus proche de la decharge :");
        System.out.println("(" + coordonneesHabitations[plusProche * 2] + "," + coordonneesHabitations[plusProche * 2 + 1] + ") ; distance = " +
                df.format(calculerDistance(x, y, coordonneesHabitations[plusProche * 2], coordonneesHabitations[plusProche * 2 + 1]))  + " metres");

        // trouve les coordonnees des 3 habitations les plus proches et affiche les coordonnees

        System.out.println("--- Question 2 ---");
        System.out.println("Coordonnees des 3 habitations les plus proches de la decharge :");
        afficheTroisPlusProches(x, y, coordonneesHabitations);

        // affiche le centre de gravite des 3 plus proches (la meilleure place)
        int[] grav = meilleurePlace(x, y, coordonneesHabitations);
        System.out.println("--- Question 3 ---");
        System.out.println("Coordonnees de la meilleure place pour la decharge :");
        System.out.println("(" + grav[0] + "," + grav[1] + ")");
        clavier.close();
    }

}
	