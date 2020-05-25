public class Figures {
    public static void main(String[] args) {
        for(int i = 1; i < 10; ++i){
            System.out.print(i);
        }

        System.out.println("\n===========================");

        for(int i = 1; i < 10; ++i){
            for (int j = 1; j < 10 ; ++j){
                System.out.print(j);
            }
            System.out.println();

        }

        System.out.println("\n===========================");

        for(int i = 1; i < 10; ++i){
            for (int j = 1; j <= i ; ++j){
                System.out.print(j);
            }
            System.out.println();

        }

        System.out.println("\n===========================");

        for(int i = 1; i < 10; ++i){
            for (int j = 1; j < 10 ; ++j){
                if( i + j >= 10){
                    System.out.print(j);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }
}
