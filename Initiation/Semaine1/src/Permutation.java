import java.util.Locale;
import java.util.Scanner;

public class Permutation {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        System.out.print("Entrer x : " );
        int x = clavier.nextInt();

        System.out.print("Entrer y : " );
        int y = clavier.nextInt();

        System.out.println("Avant permutation");
        System.out.println("x : "+x);
        System.out.println("y : "+y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println("Après permutation");
        System.out.println("x : "+x);
        System.out.println("y : "+y);

        clavier.close();

    }
}
