import java.util.Locale;
import java.util.Scanner;

public class IMC {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        clavier.useLocale(Locale.ENGLISH);
        double poids = 70;
        double taille = 1.74;

        System.out.print("Donner votre taille en m :  ");
        taille = clavier.nextDouble();
        clavier.nextLine();
        System.out.print("Donner votre poids en kg : ");
        poids = clavier.nextDouble();

        double imc = poids/(taille*taille);

        System.out.println("Pour "+poids+" kg, et "+taille+" m. L'IMC est : "+imc);

        clavier.close();


    }
}
