import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cesure {
    private static Scanner clavier = new Scanner(System.in);
    public static void main(String[] args) {
        String[] phrase = lirePhrase();

        System.out.println("Le résultat est : ");
        for (int i = 0; i < phrase.length; i++) {
            cesure(phrase[i]);
        }
        clavier.close();
    }
    static String[] lirePhrase() {
        // A compléter:
        // retourne un tableau de chaines de caractères
        // introduits par l'utilisateur
        int nbMots = 0;
        do{
            System.out.print("Donnez le nombre de mots dans votre phrase : ");
            try {
                nbMots= clavier.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Il faut entrer un entier");
            }
            clavier.nextLine();
            if(nbMots <= 0){
                System.out.println("Entrez une entier plus grande que 0");
            }
        }while(nbMots <= 0);

        String[] chaines = new String[nbMots];
        for(int i = 0; i < chaines.length; ++i){
            System.out.print(" Donnez le mot "+ (i+1) +" : ");
            chaines[i] = clavier.nextLine();
        }

        return chaines;
    }

    static boolean voyelle(char c) {
        // A compléter:
        // teste si un caractère est une voyelle
        String voyelles = "aeyuio";

        return voyelles.contains(String.valueOf(c));
    }
    static boolean queVoyelles(String s) {
        // A compléter:
        // teste si une chaîne ne contient que des voyelles
        // utilise la méthode voyelle
        boolean queVoyelles = true;
        int i = 0 ;
        while(i < s.length() && queVoyelles){
            if(!voyelle(s.charAt(i))){
                queVoyelles = false;
            }
            ++i;
        }

        return queVoyelles;
    }
    static void cesure(String mot) {
        // A compléter:
        // détermine la césure d'un mot donné et effectue les affichages
        // correspondants (voir exemple de déroulement)
        ArrayList<String> mots = new ArrayList<>();
            do{
                   if(mot.length() > 3){
                       int i = 1;
                       boolean memeType = true;
                       while(memeType && i < mot.length()-2){  //une consonne qui suit une voyelle et et le reste du mot > 3 lettres
                           //le mot avant la consonne n est pas que des voyelles
                           if(!queVoyelles(mot.substring(0,i) )&& voyelle(mot.charAt(i)) && !voyelle(mot.charAt(i+1)) ){
                               memeType = false;
                           }
                           ++i;
                       }
                       if(! memeType){
                          /* if(queVoyelles(mot.substring(i, mot.length()))){ //si le reste du mot ne contient que des voyelles
                               mots.add(mot);
                               mot = ""; // une fois on ajoute le mot il faut le vider pour ne pas boucler inefiniment
                           }else{*/
                               mots.add(mot.substring(0,i).concat("-"));
                               mot = mot.substring(i, mot.length());
                           //}
                       }else{
                           mots.add(mot); // dans le cas on arrive au 2 dernieres lettres et les lettres d avant sont de mm type
                           mot = "";
                       }
                   }

                   if(mot.length() <= 3){
                       mots.add(mot);
                   }

            }while(mot.length() > 3);

       mots.stream().forEach(System.out::println);
    }
}
