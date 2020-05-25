import java.util.Locale;
import java.util.Scanner;

public class ProduitScalaire {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        int tailleMax = 10;
        int[] v1 = new int[tailleMax];
        int[] v2 = new int[tailleMax];
        int taille;

        do{
            System.out.print("Entrer la taille des vecteurs : ");
            taille = clavier.nextInt();
        }while(taille <= 0 || taille > tailleMax);

        System.out.println("Entrer le 1 vecteur : ");
        for(int i = 0; i < taille; ++i){
            System.out.print("v1["+i+"] = ");
            v1[i] = clavier.nextInt();
        }

        System.out.println();
        System.out.println("Entrer le 2 vecteur : ");
        for(int i = 0; i < taille; ++i){
            System.out.print("v2["+i+"]= "+" ");
            v2[i] = clavier.nextInt();
        }

        int produitScalaire = 0;
        for(int i = 0; i < taille; ++i){
           produitScalaire += v1[i] * v2[i];
        }
        System.out.println("Le produit scalaire est : "+produitScalaire);
        clavier.close();
    }
}
