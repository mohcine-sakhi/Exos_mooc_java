import java.util.Locale;
import java.util.Scanner;

public class Pret {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        int somme, s;
        int mois = 0, montant;
        double taux, interets = 0;

        do{
            System.out.print("Entrer la somme de pret : ");
            somme = clavier.nextInt();
        }while(somme <= 0);

        do{
            System.out.print("Entrer le montant fixe : ");
            montant = clavier.nextInt();
        }while(montant <= 0);

        do{
            System.out.print("Entrer le taux : ");
            taux = clavier.nextDouble();
        }while(taux <= 0 || taux > 1);

        s = somme;
        while(s > 0){
            interets += taux * s;
            s -= montant;
            ++mois;
        }

        System.out.println("Lasomme des intérêts encaissés (sur "+mois+" mois) est alors de "+interets+" euros.");

        clavier.close();
    }
}
