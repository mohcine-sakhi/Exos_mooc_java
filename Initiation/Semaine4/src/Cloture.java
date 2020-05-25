import java.util.ArrayList;

class Cloture {
    public static void main(String[] args) {
        int[][] carte = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,0},
                {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };

        /*******************************************
         * Completez le programme Ã  partir d'ici.
         *******************************************/
        // verifier le bon format de la matrice cad; elle ne contient que des 0 et des 1
        boolean bonFormat = true;
        int i = 0;
        int j = 0;
        while(i < carte.length && bonFormat){
             j = 0;
            while (j < carte[i].length && bonFormat){
                if(carte[i][j] != 0 && carte[i][j] != 1){
                    bonFormat = false;
                }
                ++j;
            }
            ++i;
        }
        if(! bonFormat){
            System.out.print("Votre carte du terrain n'a pas le bon format :\nvaleur '");
            System.out.print(carte[i-1][j-1]); // les i et j ont ete incremente de 1 apres verification
            System.out.print("' trouvée en position [");
            System.out.print(i-1);
            System.out.print("][");
            System.out.print(j-1);
            System.out.println("]");
        }else{
            //effacer les etangs cad  remplacer les 0 entre deux uns par des uns
            int l = 0;
            int k = 0;
            while(l < carte.length ){
                // chercher la position du premier 1
                int positionPremier1 = 0;
                boolean premierUnTrouve = false;
                k = 0;
                while (k < carte[l].length && ! premierUnTrouve){
                    if(carte[l][k] == 1){
                        premierUnTrouve = true;
                        positionPremier1 = k;
                    }
                    ++k;
                }
                // chercher la position du dernier 1
                int positionDernier1 = 0;
                boolean dernierrUnTrouve = false;
                k = carte[l].length -1 ;
                while (k > positionPremier1  && ! dernierrUnTrouve){
                    if(carte[l][k] == 1){
                        dernierrUnTrouve = true;
                        positionDernier1 = k;
                    }
                    --k;
                }
                // remplacer les 0 entre les 2 positions par des 1
                if(premierUnTrouve && dernierrUnTrouve && positionPremier1 < positionDernier1){
                    for(int m = positionPremier1; m <= positionDernier1; ++m){
                        carte[l][m] = 1;
                    }
                }
                ++l;
            }

            //calculer la cloture
            double cloture = 0;
            for(int ligne = 0; ligne < carte.length; ++ligne){
                for(int colonne = 0; colonne < carte[ligne].length; ++colonne) {
                    if(carte[ligne][colonne] == 1){
                        if(ligne - 1 < 0 || carte[ligne - 1][colonne] == 0){ // le cas ou le 1 sur le bord
                            ++cloture;
                        }
                        if(ligne + 1 >= carte.length || carte[ligne + 1][colonne] == 0){ // le cas ou le 1 sur le bord
                            ++cloture;
                        }
                        if(colonne - 1 < 0 || carte[ligne][colonne - 1] == 0){ // le cas ou le 1 sur le bord
                            ++cloture;
                        }
                        if(colonne + 1 >= carte[ligne].length || carte[ligne][colonne + 1] == 0){ // le cas ou le 1 sur le bord
                            ++cloture;
                        }
                    }
                }
            }
            System.out.print("Il vous faut ");
            System.out.print(2.5 * cloture);
            System.out.println(" mètres de clôture pour votre terrain.");


        }

       /* System.out.println("Votre carte du terrain n'a pas le bon format :");
        System.out.print("bord extérieur entrant trouvé en position [");
        System.out.print("][");
        System.out.println("]");*/



        /*******************************************
         * Ne rien modifier après cette ligne.
         *******************************************/
    }

}