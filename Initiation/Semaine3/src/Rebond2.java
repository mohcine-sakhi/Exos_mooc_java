import java.util.Locale;
import java.util.Scanner;

public class Rebond2 {
    private static Scanner clavier = new Scanner(System.in) ;

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);

        final double G = 9.81;
        double h0, h, h_fin;
        double eps;
        double v0, v;

        do{
            System.out.print("Entrer la hauteur initiale : ");
            h0 = clavier.nextDouble();
        }while(h0 <=0);

        do{
            System.out.print("Entrer la hauteur finale : ");
            h_fin = clavier.nextDouble();
        }while(h_fin <=0);

        do{
            System.out.print("Entrer la constante epsilon : ");
            eps = clavier.nextDouble();
        }while(eps <=0 || eps > 1 );

        h = h0;

        int nbRebond = 0;
       do{
            // Au contact du sol
            v0 = Math.sqrt(2 * h * G );
            v = eps * v0;
            h = v * v / (2 * G);

            ++nbRebond;
        }while(h > h_fin);

        System.out.println("Le nombre de rebond est de "+nbRebond);

        clavier.close();
    }
}
