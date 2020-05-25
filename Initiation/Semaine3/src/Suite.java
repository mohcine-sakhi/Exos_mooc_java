import java.util.Scanner;

class Suite {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        int debut;
        do {
            System.out.print("de (>= 1) ? ");
            debut = clavier.nextInt();
        } while (debut < 1);

        int fin;
        do {
            System.out.print("a (>= " + debut + ") ? ");
            fin = clavier.nextInt();
        } while (fin < debut);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        int temp;
       for(int i = debut; i <= fin; ++i ){
           int nbRepetition = 0;
           temp = i;
           do{
               if( temp % 3 == 0){
                   temp += 4;
               }else if( temp % 4 == 0){
                   temp /= 2;
               }else{
                   --temp;
               }
               ++nbRepetition;
           }while(temp != 0);

           System.out.println(i+" -> "+nbRepetition);
       }

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}