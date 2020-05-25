public class SuiteEtSerie {
    public static void main(String[] args) {
        double u = 1;

        double v = 0;
        for( int i = 0; i <= 10 ; ++i){
            v += u;
            System.out.println("u"+i+" = "+u);
            u /= i+1;
        }

        System.out.println("Vn = "+v);
    }
}
