import java.util.Scanner;

public class Fibonacci {
    private static Scanner clavier = new Scanner(System.in);
    public static void main(String[] args) {

        int n;
        do {
            System.out.print("Entrer un entier positif : ");
            n = clavier.nextInt();
        }while(n <0 );

        System.out.println("Fibonacci("+n+") = "+Fibonacci(n));
    }

    static int Fibonacci (int n){
        if(n == 0){
            return 0;
        }else if(n == 1 ){
            return 1;

        }else{
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }
}
