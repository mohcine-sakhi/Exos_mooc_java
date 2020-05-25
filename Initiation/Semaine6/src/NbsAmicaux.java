public class NbsAmicaux {
    public static void main(String[] args) {

       int[] nombres = {1210, 45, 27, 220, 54, 284, 9890, 120, 1184};
        System.out.println("Les paires de nombres amicaux sont : ");
        afficherAmicaux(nombres);
    }

    static int sommeDiviseurs (int nb){
        int somme = 0 ;
        for(int i = 1; i <= nb; ++i){
            if(nb % i ==0){
                somme += i;
            }
        }

        return somme;
    }

    static boolean nbsAmicaux (int a, int b){
        return (sommeDiviseurs(a) == sommeDiviseurs(b) && a+b == sommeDiviseurs(a));


    }

    static void afficherAmicaux (int[] tab){
        for(int i =0; i < tab.length - 1; ++i){
            for(int j = i+1; j < tab.length; ++j){
               if(nbsAmicaux(tab[i], tab[j])){
                   System.out.println(tab[i]+" "+tab[j]);
               }
            }
        }
    }
}
