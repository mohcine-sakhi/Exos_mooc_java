public class Min {
    public static void main(String[] args) {
        int a = 7;
        int b = 5;
        int c = 3;

        System.out.println("min a et b : "+min2(a, b));
        System.out.println("min a, b et c : "+min3(a, b, c));

    }

    static int min2 (int a, int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }

    static int min3 (int a, int b, int c){
        return min2(min2(a,b), c);
    }
}
