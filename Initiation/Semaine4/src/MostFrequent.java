class MostFrequent {

    public static void main(String[] args) {
        int[] tab1 = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6};
        int taille = tab1.length;

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        int element = tab1[0];
        int count = 1;
        int frequence = 1;

        for(int i =0; i < tab1.length-1; ++i){
            for(int j = i+1; j < tab1.length; ++j){
                if(tab1[i] == tab1[j]){
                   ++count;
                }
            }
            if(count > frequence ){
                frequence = count;
                element = tab1[i];
            }
            // apres chaque tour il faut reinitialiser le compteur
            count = 1;
        }

       /* int[] tab2 = new int[tab1.length];
        for(int i = 0; i < tab1.length; ++i){
            tab2[i] = tab1[i];
        }

        for(int i =0; i < tab2.length-1; ++i){
            for(int j = i; j < tab2.length; ++j){
                if(tab2[i] > tab2[j]){
                    int temp = tab2[i];
                    tab2[i] = tab2[j];
                    tab2[j] = temp;
                }
            }
        }

        for(int i =0; i < tab2.length-1; ++i){
            if(tab2[i] == tab2[i+1]){
                ++count;

                //dans le cas ou l element frequent se trouve a la fin du tableau on va sortir de la boucle
                //donc il faut faire le traitement dans ce bloc
                if(i == tab2.length-2){
                    if(count >= frequence && count != 1){
                        frequence = count;
                        element = tab2[i];
                    }
                }
            }else{
                if(count >= frequence && count != 1){
                    frequence = count;
                    element = tab2[i];
                }
                count = 1;
            }
        }*/

        System.out.println("Le nombre le plus frequent dans le tableau est le : ");
        System.out.println(element+" ("+frequence+" x)");

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}