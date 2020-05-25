import java.util.Locale;
import java.util.Scanner;

public class Champi {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        int champ = 0;
        System.out.println("Pensez a un champignon : amanite tue mouches, pied bleu, girolle,");
        System.out.println("cèpe de Bordeaux, coprin chevelu ou agaric jaunissant.");
        System.out.print("Est-ce que votre champignon a un chapeau convexe (true : oui, false : non) ? ");
        if(clavier.nextBoolean()){
            System.out.print("Est-ce que votre champignon vit en forêt (true : oui, false : non) ? ");
            if(clavier.nextBoolean()){
                System.out.print("Est-ce que votre champignon a un anneau (true : oui, false : non) ? ");
                if(clavier.nextBoolean()){
                    champ = 2;
                }else{
                    champ = 6;
                }
            }else{
                champ = 1;
            }
        }else{
            System.out.print("Est-ce que votre champignon vit en forêt (true : oui, false : non) ? ");
            if(clavier.nextBoolean()){
                System.out.print("Est-ce que votre champignon a des lamelles (true : oui, false : non) ? ");
                if(clavier.nextBoolean()){
                    champ = 5;
                }else{
                    champ = 3;
                }
            }else{
                champ = 4;
            }
        }

        System.out.print("==> Le champignon auquel vous pensez est ");
        switch(champ){
            case 1 : System.out.print("l'agaric jaunissant"); break;
            case 2 : System.out.print("l'amanite tue-mouches"); break;
            case 3 : System.out.print("le cèpe de Bordeaux"); break;
            case 4 : System.out.print("le coprin chevelu"); break;
            case 5 : System.out.print("la girolle"); break;
            case 6 : System.out.print("le pied bleu"); break;
            default : System.out.print("tes réponses ne sont pas cohérentes");

        }
        clavier.close();
    }


}
