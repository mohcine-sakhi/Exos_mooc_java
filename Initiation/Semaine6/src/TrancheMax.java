import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);
        clavier.close();

        // Validation de la matrice
        if (!checkFormat(matrice)) {
            return;
        }

        // Trouver la liste des lignes avec le plus grand nombre de 1 consecutif
        // Ces numéros de lignes sont stockés dans un tableau dynamique
        ArrayList<Integer> maxConsecutifList = findConsecutiveList(matrice);

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1 !");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs :");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
   public static boolean checkLineLength(String matrice){
       String[] lignes = matrice.trim().split(" {1,}");
       int longeur = lignes[0].length();
       int i = 1;
       boolean memeLongeur = true;
       while(i < lignes.length && memeLongeur){
           memeLongeur = (longeur == lignes[i].length());
           ++i;
       }

       if(! memeLongeur){
           System.out.println("Matrice invalide, lignes de longueurs differentes !");
       }

       return memeLongeur;
   }
   public static boolean checkFormat(String matrice){
       if(matrice.trim().equals("")){
           System.out.println("Matrice vide !");
           return false;
       }

       boolean bonFormat = true;
       int i = 0;
       while (i < matrice.length() && bonFormat) {
           bonFormat = (matrice.charAt(i) == '1' || matrice.charAt(i) == ' ' || matrice.charAt(i) == '0');
           ++i;
       }

       if(! bonFormat){
          System.out.println("Matrice invalide : seuls '1', '0' et ' ' sont admis !");
          return bonFormat;
       }
       return checkLineLength(matrice);
   }

    public static ArrayList<Integer> findConsecutiveList(String matrice){
        ArrayList<Integer> maxConsecutifList = new ArrayList<>();
        String[] lignes = matrice.trim().split(" {1,}");
        int[] nbDeUnParLigne = new int[lignes.length];

        for(int k = 0 ; k < lignes.length; ++k){
            int maxDeUn = 0;
            for(int i= 0; i < lignes[k].length(); ++i){
                int nbDeUn = 0 ;
                if(lignes[k].charAt(i) == '1'){
                    nbDeUn = 1;
                    int j = i+1;
                    while(j <lignes[k].length()  && lignes[k].charAt(j) == '1'  ){  //la comparaison lazy nous a sauve la peau
                        ++nbDeUn;
                        ++j;
                    }
                }
                if(nbDeUn > maxDeUn){
                    maxDeUn = nbDeUn;
                }
            }
            nbDeUnParLigne[k] = maxDeUn;
        }
        //trouver le max des 1
        int max = nbDeUnParLigne[0];

        for(int i = 1; i < nbDeUnParLigne.length; ++i){
            if(nbDeUnParLigne[i] > max){
                max = nbDeUnParLigne[i];
            }
        }

        //on cherche  les indices des maxs
        if(max > 0 ){
            for(int i = 0; i < nbDeUnParLigne.length; ++i){
                if(nbDeUnParLigne[i] == max){
                    maxConsecutifList.add(i);
                }
            }
        }

         return maxConsecutifList;
    }





    /*******************************************
     * Ne rien modifier apres cette ligne
     *******************************************/
}