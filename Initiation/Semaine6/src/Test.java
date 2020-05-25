import java.util.Scanner;

public class Test {
    private static Scanner clavier = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("entre");
        String chaine = clavier.nextLine();
        int maxDeUn = 0;
        for(int i= 0; i < chaine.length(); ++i){
            int nbDeUn = 0 ;
            if(chaine.charAt(i) == '1'){
                nbDeUn = 1;
                int j = i+1;
                while(j <chaine.length()  && chaine.charAt(j) == '1'  ){  //la comparaison lazy nous a sauve la peau
                    ++nbDeUn;
                    ++j;
                }
            }
            if(nbDeUn > maxDeUn){
                maxDeUn = nbDeUn;
            }
        }
        System.out.println(maxDeUn);
    }
}
