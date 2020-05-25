import java.util.Locale;
import java.util.Scanner;

public class Rebond1 {
    private static Scanner clavier = new Scanner(System.in) ;

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);

        final double G = 9.81;
        double h0, h;
        int nbRebond;
        double eps;
        double v0, v;

        do{
            System.out.print("Entrer la hauteur initiale : ");
            h0 = clavier.nextDouble();
        }while(h0 <=0);

        do{
            System.out.print("Entrer le nombre de rebond : ");
            nbRebond = clavier.nextInt();
        }while(nbRebond <=0);

        do{
            System.out.print("Entrer la constante epsilon : ");
            eps = clavier.nextDouble();
        }while(eps <=0 || eps > 1 );

        h = h0;

        for( int i = 0; i < nbRebond; ++i){
            // Au contact du sol
            v0 = Math.sqrt(2 * h * G );
            v = eps * v0;
            h = v * v / (2 * G);
        }

        System.out.println("La hauteur obtenue apres "+nbRebond+" rebonds doit être environ "+h);

        clavier.close();
    }
}
