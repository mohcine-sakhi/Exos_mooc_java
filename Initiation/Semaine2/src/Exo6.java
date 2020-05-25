import java.util.Locale;
import java.util.Scanner;

public class Exo6 {
    private static Scanner clavier = new Scanner(System.in);
    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);

        System.out.print("Entrez un nombre entier : ");
        int nb = clavier.nextInt();

        if(nb>0){
            if( nb%2 == 0){
                System.out.println( "Le nombre est positif et pair");
            }else{
                System.out.println( "Le nombre est positif et impair");
            }
        }else if(nb<0){
            if( nb%2 == 0){
                System.out.println( "Le nombre est négatif et pair");
            }else{
                System.out.println( "Le nombre est négatif et impair");
            }
        }else{
            System.out.println("Le nombre est zéro (et il est pair)");
        }


        clavier.close();


    }
}
