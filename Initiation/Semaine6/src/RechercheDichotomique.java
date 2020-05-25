import java.util.Scanner;

public class RechercheDichotomique {
    private static Scanner  clavier = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Pensez à un nombre entre 1 et 100");
        int nb;
        int nbDevine = cherche(1, 100);

        if(nbDevine == -1){
            System.out.println("Il y a qlq chose qui cloche");
        }else {
            System.out.println("Votre nombre était "+nbDevine+".");
        }

    }
    static int cherche(int borneInf, int borneSup){
        int nbDevine;
        if(borneInf > borneSup){
            return -1;
        }else {
            nbDevine = (borneInf + borneSup) / 2;
            System.out.print("Le nombre est il <, > ou = à "+nbDevine+" ? : ");
            String symbole = clavier.nextLine();

            switch (symbole){
                case "=" : return nbDevine;
                case "<" :  return cherche(borneInf, nbDevine-1);
                case ">" : return cherche(nbDevine+1, borneSup);
                default :  return -1;
            }

        }
    }
}
