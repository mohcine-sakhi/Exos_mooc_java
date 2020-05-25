import java.util.Locale;
import java.util.Scanner;

public class Degre3 {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        System.out.print("Entrer a (int) : ");
        int a = clavier.nextInt();

        System.out.print("Entrer b (int) : ");
        int b = clavier.nextInt();

        System.out.print("Entrer c (int) : ");
        int c = clavier.nextInt();

        System.out.print("Entrer x (double) : ");
        double x = clavier.nextDouble();

        double valeur = ((a+b)/2.0)*x*x*x;
        valeur+= (a+b)*(a+b)*x*x;
        valeur+= a+b+c;

        System.out.println("La valeur du pôlynome est : "+valeur);

        clavier.close();

    }
}
