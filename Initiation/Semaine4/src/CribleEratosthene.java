public class CribleEratosthene {
    public static void main(String[] args) {
        int taille = 100;
        boolean[] premiers = new boolean[taille];
        premiers[0] = true;
        premiers[1] = true;

        for(int i = 0 ; i < (taille+1)/2; ++i){
            if(!premiers[i]){
                for(int j = i+1; j < taille; ++j){
                    if(j % i ==0){
                        premiers[j] = true;
                    }
                }
            }
        }

        System.out.println("les nombres premiers plus petits que 100 sont : ");
        for(int i =0; i < taille; ++i){
            if(!premiers[i]){
                System.out.print(i+" ");
            }
        }

    }

    /*public static void main(String[] args) {
        boolean[] supprimes = new boolean[100];
        for(int i = 0; i < supprimes.length; i++) {
            supprimes[i] = false;
        }
        supprimes[0] = true; // 0 n'est pas premier
        supprimes[1] = true; // 1 n'est pas premier
        for(int i = 2; i < supprimes.length; i++) {
            if(!supprimes[i]) {
                int multiple = 2*i;
                while(multiple < supprimes.length) {
                    supprimes[multiple] = true;
                    multiple = multiple + i;
                }
            }
        }
        for(int i = 0; i < supprimes.length; i++) {
            if(!supprimes[i])
                System.out.print(i+" ");
        }
        System.out.println();
    }*/

}
