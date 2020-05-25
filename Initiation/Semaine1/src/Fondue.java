import java.util.Locale;
import java.util.Scanner;

public class Fondue {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);

        final int BASE = 4;
        double fromage = 800.0;
        double eau = 2.0;
        double ail = 2.0;
        double pain = 400.0;

        System.out.print("Entrer le nombre de personnes conviées à la fondue : " );
        int nbConvives = clavier.nextInt();

        double quantiteFromage = (fromage * nbConvives)/BASE;
        double quantiteEau = (eau * nbConvives)/BASE;
        double quantiteAil = (ail * nbConvives)/BASE;
        double quantitePain = (pain * nbConvives)/BASE;

        System.out.println("Pour faire une fondue fribourgeoise pour "+nbConvives+" personnes, il vous faut :");
        System.out.println("- "+quantiteFromage+" gr de Vacherin fribourgeois");
        System.out.println("- "+quantiteEau+" dl d'eau");
        System.out.println("- "+quantiteAil+" gousse(s) d'ail");
        System.out.println("- "+quantitePain+" gr de pain");
        System.out.println("- du poivre à volonté");

        clavier.close();

    }
}
