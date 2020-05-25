import java.util.Scanner;

public class Triangle {
    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        int n ;
        do {
            System.out.println("Donner un entier positif : ");
            n = clavier.nextInt();
        }while(n < 0);

        for(int i = 0; i < n; ++i){
            for(int j =0; j < 2 * n; ++j){
                if(j >= n - i && j <= n+i ){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
