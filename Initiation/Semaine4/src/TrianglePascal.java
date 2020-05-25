import java.util.Locale;
import java.util.Scanner;

public class TrianglePascal {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);

        System.out.print("Donner la taille du triangle de pascal : ");
        int taille = clavier.nextInt();
        int[][] pascal = new int[taille][];

        pascal[0] = new int[1];
        pascal[0][0] = 1;


        for(int i =1; i < pascal.length; ++i){
            pascal[i] = new int[i+1];
            for(int j = 0; j <= i; ++j){
                if(j == 0 || i == j){
                    pascal[i][j] = 1;
                }else{
                    pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
                }
            }
        }

        for(int i = 0; i < pascal.length; ++i){
            for(int j = 0; j <= i; ++j){
                System.out.print(pascal[i][j]+" ");
            }
            System.out.println();
        }
        clavier.close();


    }
}
