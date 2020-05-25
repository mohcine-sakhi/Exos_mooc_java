import java.util.Locale;
import java.util.Scanner;

public class RoseBlanche {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);

        System.out.print("Combien avez-vous reçu d'argent (Frs) ? ");
        int somme = clavier.nextInt();

        int fournitures = somme*3/4;
        somme -= fournitures;

        int reste = somme % 3;
        somme /= 3;

        int cafe = somme / 2;
        reste += somme % 2;

        int flash = somme / 4;
        reste += somme % 4;

        int billet = somme / 3;
        reste += somme % 3;

        System.out.println("Livre et Fournitures: "+fournitures+" Frs");
        System.out.println("Vous pouvez ensuite acheter:");
        System.out.println(cafe+" cafés");
        System.out.println(flash+" numéros du Flash Informatique");
        System.out.println(billet+" billets de métro");
        System.out.println("et il vous restera "+reste+" Frs pour les roses blanches.");


        clavier.close();

    }
}
