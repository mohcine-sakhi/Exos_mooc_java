import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

      int[] a = {0,0,0,0,0};
      int[] b = {1,1,1,1,1};
        System.out.println("avant");
      for(int val : a){
          System.out.print(val+" ");
      }
        System.out.println();
      for(int val : b){
            System.out.print(val+" ");
      }
      echangerTableau(a, b);
      System.out.println("\napres");
        for(int val : a){
            System.out.print(val+" ");
        }
        System.out.println();
        for(int val : b){
            System.out.print(val+" ");
        }
        System.out.println();
            int x = 3, y = 5;
            System.out.print(x + " " + y + " ");

            m1(x,y);
            System.out.println(x + " " + y + " ");

            String s1 = "foo", s2 = "bar";
            System.out.print(s1 + s2);

            m2(s1,s2);
            System.out.print(s1 + s2);

    }

    static void m1(int i, int j) {
        int tmp = i; i = j; j = tmp;
    }


    static void m2(String i, String j) {
        String tmp = i; i = j; j = tmp;
    }
    public static void echangerTableau(int[] a, int[] b){
        ArrayList<Boolean> tab;
        int[] temp = a;
        a = b;
        b = temp;

    }

    public static void echanger(String a, String b){
        ArrayList<Boolean> tab;
        String temp = a;
        a = b;
        b = temp;
        System.out.println("En cours : a = "+a+" b = "+b);
    }
}

class Triangle {
    private int a;
    public Triangle(){
        afficher();
    }
    public void afficher(){
        System.out.println(a);
    }
}
