import java.util.Locale;
import java.util.Scanner;

public class PGDC {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        int a, b, r, max, min;

        do{
            System.out.print("Entrer un nombre positif : " );
            a = clavier.nextInt();
        }while(a < 0);

        do{
            System.out.print("Entrer un nombre positif : " );
            b = clavier.nextInt();
        }while(b < 0);

        if(a < b){
            max = b;
            min = a;
        }else{
            max = a;
            min = b;
        }

        while( max % min != 0){
            r = max % min ;
            max = min;
            min = r;
        }

        System.out.println("Le plus grand diviseur commun de "+a+" et "+b+" est "+min);
        clavier.close();
    }
}
