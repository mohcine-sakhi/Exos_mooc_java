import java.util.Locale;
import java.util.Scanner;

public class elementsEnIndice {
    private static Scanner clavier = new Scanner(System.in);
    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        int taille;
        do{
            System.out.print("Donner la taille du tableau : ");
             taille = clavier.nextInt();
        }while(taille < 1 || taille > 10);


        int[] tab1 = new int[taille];
        System.out.println("Saisie des élémnts du tableau");
        for(int i =0; i < tab1.length; ++i){
            System.out.print("T["+i+"] = ");
            tab1[i] = clavier.nextInt();
        }
        // recherche du plus grand nombre dans les indices impairs
        int max = tab1[1];
        for(int i = 1; i < tab1.length; i += 2){
            if(tab1[i] > max){
                max = tab1[i];
            }
        }

        int[] tab2 = new int[max+1];
        for(int i = 0; i < tab1.length; i += 2){
            tab2[tab1[i+1]] = tab1[i];
        }

        System.out.println("Affichage du tableau obtenu");
            for(int val : tab2){
                System.out.print(val+" ");
            }

        clavier.close();
    }
}
