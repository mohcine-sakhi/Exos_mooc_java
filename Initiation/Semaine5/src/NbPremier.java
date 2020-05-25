import java.util.ArrayList;

public class NbPremier {

    public static void main(String[] args) {
        ArrayList<Integer> premiers = new ArrayList<>();
        premiers.add(2);

        for(int i = 3; i <= 100; ++i){
            int nb = i;
            boolean premier = true;
            int j = 2;

            while(j < Math.sqrt(nb) && premier){
                if(nb % j == 0){
                    premier = false;
                }
                ++j;
            }

            if(premier){
                premiers.add(nb);
            }
        }

        System.out.println("Les nombres premiers entre 1 et 100 sont au nombre de "+premiers.size()+" et sont : ");
        for(Integer val : premiers){
            System.out.print(val+" ");
        }
    }
}
