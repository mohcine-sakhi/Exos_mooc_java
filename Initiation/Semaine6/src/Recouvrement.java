import java.util.Scanner;

public class Recouvrement {
    private static final int DIM = 10;
    private static final Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        boolean[][] grille = new boolean[DIM][DIM];
        int x, y, taille;
        char direction;

        do{
            do{
                System.out.print("Entrez coord. x: ");
                x = clavier.nextInt();
                clavier.nextLine();
                if(x < 0){
                    afficheGrille(grille);
                    return;
                }
            }while (x < 0 || x >= DIM);

            do{
                System.out.print("Entrez coord. y: ");
                y = clavier.nextInt();
                clavier.nextLine();
                if(y < 0){
                    afficheGrille(grille);
                    return;
                }
            }while (y < 0 || y >= DIM);

            do{
                System.out.print("Entrez direction (N,S,E,O): ");
                direction = clavier.nextLine().toUpperCase().charAt(0);
            }while ( ! (direction == 'E' || direction == 'O' || direction == 'S' || direction == 'N'));

            do{
                System.out.print("Entrez taille: ");
                taille = clavier.nextInt();
            }while (taille < 1 || taille > DIM);

            String resultat = "";
            if(remplitGrille(grille, x, y, direction, taille)){
                resultat = "SUCCES";
            }else{
                resultat = "ECHEC";
            }

            System.out.println("Placement en ("+x+","+y+") direction "+direction+" longueur "+taille+" -> "+resultat);
        }while(x >= 0 && y >= 0);


    }

    public static boolean remplitGrille(boolean[][] grille, int ligne, int colonne, char direction, int longueur){
        if(grille[ligne][colonne]){
            return false;
        }
        boolean deplacement = true;
        if(direction == 'E'){
            if(colonne + longueur > grille[ligne].length){ //la longureur est plus grande que les cases vides
                return false;
            }else{
                int j = colonne;
                while(j < colonne+longueur && deplacement){
                    if(grille[ligne][j]){ //on verifie si les cases sont vides
                        deplacement = false;
                    }
                    ++j;
                }
                if(deplacement){ // effectuer le deplacement si c possible
                    for( j = colonne; j < colonne + longueur; ++j){
                        grille[ligne][j] = true;
                    }
                }
            }
        }else if(direction == 'O') {
            if (colonne + 1 - longueur < 0) { //la longureur est plus grande que les cases vides
                return false;
            } else {
                int j = colonne;
                while (j >= colonne + 1 - longueur && deplacement) {
                    if (grille[ligne][j]) { //on verifie si les cases sont vides
                        deplacement = false;
                    }
                    --j;
                }
                if (deplacement) { // effectuer le deplacement si c possible
                    for (j = colonne; j >= colonne + 1 - longueur; --j) {
                        grille[ligne][j] = true;
                    }
                }
            }
        }else if(direction == 'S'){
            if(ligne + longueur > grille.length){ //la longureur est plus grande que les cases vides
                return false;
            }else{
                int i = ligne;
                while(i < ligne + longueur && deplacement){
                    if(grille[i][colonne]){ //on verifie si les cases sont vides
                        deplacement = false;
                    }
                    ++i;
                }
                if(deplacement){ // effectuer le deplacement si c possible
                    for( i = ligne; i < colonne + longueur; ++i){
                        grille[i][colonne] = true;
                    }
                }
            }
        }else if(direction == 'N'){
            if (ligne + 1 - longueur < 0) { //la longureur est plus grande que les cases vides
                return false;
            } else {
                int i = ligne;
                while (i >= ligne + 1 - longueur && deplacement) {
                    if (grille[i][colonne]) { //on verifie si les cases sont vides
                        deplacement = false;
                    }
                    --i;
                }
                if (deplacement) { // effectuer le deplacement si c possible
                    for (i = ligne; i >= ligne + 1 - longueur; --i) {
                        grille[i][colonne] = true;
                    }
                }
            }
        }
        return deplacement;
    }

    public static void afficheGrille(boolean[][] grille){
        System.out.println("Résultat des placements :");
        System.out.print("  ");
        for(int i = 0; i < grille.length; ++i){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i = 0; i < grille.length; ++i){
            System.out.print(i+" ");
            for(int j = 0; j < grille[i].length; ++j){
                if(grille[i][j]){
                    System.out.print("# ");
                }else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
