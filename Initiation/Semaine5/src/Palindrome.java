import java.util.Scanner;

public class Palindrome {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez un mot ou une phrase : ");
        String chaine = clavier.nextLine();
        chaine = chaine.toLowerCase();
        String chaineEpuree = "";
        char c;

        for(int i = 0; i < chaine.length(); ++i){
            c = chaine.charAt(i);
            if(Character.isLetter(c)){
                chaineEpuree += c;
            }
        }

        boolean palindrome = true;
        int i = 0;

        while(i <= chaineEpuree.length()/2 && palindrome){

            palindrome  = chaineEpuree.charAt(i) == chaineEpuree.charAt(chaineEpuree.length()- 1 - i) ;

            ++i;
        }

        if(palindrome){
            System.out.println("C'est un palindrome !");
        }else{
            System.out.println("Ce n'est pas un palindrome !");
        }

    }
}
