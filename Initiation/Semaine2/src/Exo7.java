import java.util.Locale;
import java.util.Scanner;

public class Exo7 {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        System.out.print("Entrer un nombre décimal : ");
        double x = clavier.nextDouble();
        if(((x<1 || x==1) && !(x<0 ||  x== 0)) ||(x<3 && !(x<2 && !(x== 2))) || ((x<-2 || x==-2) && !(x<-10 && !(x == -10)))){
            System.out.println("x appartient à I");
        }else{
            System.out.println("x n'appartient pas à I");
        }

        clavier.close();
    }
}
