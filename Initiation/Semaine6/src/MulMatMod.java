import java.util.Locale;
import java.util.Scanner;

public class MulMatMod {
        private static Scanner clavier = new Scanner(System.in);

        public static void main(String[] args) {
            clavier.useLocale(Locale.ENGLISH);

            int[][] mat1 = lireMatrice();
            int[][] mat2 = lireMatrice();
            int[][] prod;

            if(mat1[0] .length!= mat2.length){
                System.out.println("le nombre des colonnes de la 1 matrice est different du nombre des lignes de la 2 matrice" +
                        ", impossible de faire la multiplication des deux matrices");
            }else{
                System.out.println("Le produit des 2 matrices");
                prod = multiplierMatrice(mat1, mat2);

                afficherMatrice(prod);
            }
            clavier.close();
        }


//=========================fonction pour lire un nombre positif========
    static int lireEntier(String message) {
        int n = 0;
        do {
            System.out.print(message);
            n = clavier.nextInt();
        } while (n < 1);
        return n;
    }
//========================fonction pour lire une matrice==============
    static int[][] lireMatrice(){
        System.out.println("Saisie de la matrice");

        int lignes = lireEntier(" Nombre de lignes : ");
        int colonnes = lireEntier(" Nombre de colonnes : ");

        int[][] mat = new int[lignes][colonnes];

        for(int i = 0; i< mat.length; ++i){
            for(int j = 0; j < mat[0].length; ++j){
                System.out.print("M["+i+"]["+j+"] = ");
                mat[i][j] = clavier.nextInt();
            }
        }

        return mat;
    }
//========================fonction pour faire le produit de deux matrices==============
      static int[][]  multiplierMatrice(int[][] mat1, int[][] mat2){
         int[][] prod = new int[mat1.length][mat2[0].length];
          for(int i = 0; i< mat1.length; ++i){
              for(int j = 0; j < mat2[0].length; ++j){
                  for(int k = 0; k < mat2.length; ++k) {
                      prod[i][j] += mat1[i][k] * mat2[k][j];

                  }

              }
          }

          return prod;
    }

//========================fonction pour afficher une matrice==============

    static void afficherMatrice(int[][] prod){
        for(int[] ligne : prod){
            for(int colonne : ligne){
                System.out.print(colonne+" ");
            }
            System.out.println();
        }
    }
}
