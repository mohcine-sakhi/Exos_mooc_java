import java.util.Locale;
import java.util.Scanner;

public class Exo8 {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        System.out.print("Entrer un nombre réel : ");
        double x = clavier.nextDouble();
        double resultat = 0.0;

        if(x!=0){
            resultat = x/(1-Math.exp(x));
            System.out.println("Expression 1 : "+resultat);
        }else{
            System.out.println("Expression 1 : indéfinie");
        }

        if(x>0 && x!=1){
            resultat = x * Math.log(x) * Math.exp (2/(x-1));
            System.out.println("Expression 2 : "+resultat);
        }else{
            System.out.println("Expression 2 : indéfinie");
        }

        if(x!=2 &&  (x<=0 || x>=8)){
            resultat = (-x-Math.sqrt(x*x-8*x))/(2-x);
            System.out.println("Expression 3 : "+resultat);
        }else{
            System.out.println("Expression 3 : indéfinie");
        }

        if((x*x-1/x)>0 && ((Math.sin(x)-x/20)*Math.log(x*x-1/x)>=0)){
            resultat = (Math.sin(x)-x/20)*Math.log(Math.sqrt(x*x-1/x));
            resultat = Math.sqrt(resultat);
            System.out.println("Expression 4 : "+resultat);
        }else{
            System.out.println("Expression 4 : indéfinie");
        }

        clavier.close();
    }
}
