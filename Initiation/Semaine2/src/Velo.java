import java.util.Scanner;

public class Velo {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.print("Donnez l'heure de début de la location (un entier) : ");
        int debut = clavier.nextInt();
        System.out.print("Donnez l'heure de fin de la location (un entier) : ");
        int fin = clavier.nextInt();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        int tarif1=0;
        int tarif2=0;
        if(debut<0 || debut>24 || fin<0 || fin>24){
            System.out.println("Les heures doivent être comprises entre 0 et 24 !");
        }else if(debut == fin){
            System.out.println("Bizarre, vous n'avez pas loué votre vélo bien longtemps !");
        }else if(debut>fin){
            System.out.println("Bizarre, le début de la location est après la fin ...");
        }else{
            if(fin<=7 || debut>=17){
                tarif1 = fin - debut;
            }else if(debut>=7 && fin<=17){
                tarif2 = fin -debut;
            }else if(debut<7 && fin<=17){
                tarif1 = 7 - debut;
                tarif2 = fin - 7;
            }else if(debut<7 && fin>17){
                tarif1 = 7 - debut + fin - 17;
                tarif2 = 17 - 7;
            }else{  //(7<debut<17 && fin>17)
                tarif1 = fin - 17;
                tarif2 = 17 - debut;
            }

            System.out.println("Vous avez loué votre vélo pendant");
            if(tarif1 != 0){
                System.out.println(tarif1+" heure(s) au tarif horaire de 1.0 franc(s)");
            }
            if(tarif2 != 0){
                System.out.println(tarif2+" heure(s) au tarif horaire de 2.0 franc(s)");
            }


            System.out.print("Le montant total à  payer est de "+(tarif1+2.0*tarif2));
            System.out.println(" franc(s).");
        }

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        clavier.close();
    }
}