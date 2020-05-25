import java.util.Locale;
import java.util.Scanner;

public class MultMat {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        int[][] mat1;
        int[][] mat2;
        int[][] prod;

        int lignes1, colonnes1, lignes2, colonnes2;

        System.out.print("Donner le nb de lignes de la 1 matrice : ");
        lignes1 = clavier.nextInt();
        System.out.print("Donner le nb de colonnes de la 1 matrice : ");
        colonnes1 = clavier.nextInt();

        System.out.print("Donner le nb de lignes de la 2 matrice : ");
        lignes2 = clavier.nextInt();
        System.out.print("Donner le nb de colonnes de la 2 matrice : ");
        colonnes2 = clavier.nextInt();

        if(colonnes1 != lignes2){
            System.out.println("colonnes1 != lignes2, impossible de faire la multiplication des deux matrices");
        }else{
            mat1 = new int[lignes1][colonnes1];
            mat2 = new int[lignes2][colonnes2];
            prod = new int[lignes1][colonnes2];

            System.out.println("Saisie de la 1 matrice");
                for(int i = 0; i< mat1.length; ++i){
                    for(int j = 0; j < mat1[0].length; ++j){
                        System.out.print("M1["+i+"]["+j+"] = ");
                        mat1[i][j] = clavier.nextInt();
                    }
                }
                System.out.println();

            System.out.println("Saisie de la 2 matrice");
                for(int i = 0; i< mat2.length; ++i){
                    for(int j = 0; j < mat2[0].length; ++j){
                        System.out.print("M2["+i+"]["+j+"] = ");
                        mat2[i][j] = clavier.nextInt();
                    }
                }
                System.out.println();

            System.out.println("Le produit des 2 matrices");
            for(int i = 0; i< mat1.length; ++i){
                for(int j = 0; j < mat2[0].length; ++j){
                   for(int k = 0; k < mat2.length; ++k) {
                       prod[i][j] += mat1[i][k] * mat2[k][j];

                   }

                }
            }

            for(int[] ligne : prod){
                for(int colonne : ligne){
                    System.out.print(colonne+" ");
                }
                System.out.println();
            }
        }
        clavier.close();
    }
}
