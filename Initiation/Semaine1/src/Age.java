import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Age {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        clavier.useLocale(Locale.ENGLISH);
        System.out.print("Donner votre age : ");

        int age = clavier.nextInt();

        int anneeDeNaissance  = LocalDate.now().getYear() - age;

        System.out.println("Votre année de naissance est : "+anneeDeNaissance);

        clavier.close();

    }
}
