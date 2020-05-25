import java.util.Locale;
import java.util.Scanner;

public class Geometrie {
    private final static Scanner clavier = new Scanner(System.in);
    public static void main(String[] args) {
        clavier.useLocale(Locale.ENGLISH);
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        initPoint(p1);
        initPoint(p2);
        initPoint(p3);
        Triangle triangle = new Triangle();
        triangle.setSommets(p1, p2, p3);
        System.out.printf("Le périmètre est : %.2f \n",triangle.perimetre());
        if(triangle.isIsocele()){
            System.out.println("Le triangle est isocèle !");
        }else{
            System.out.println("Le traingle n'est pas isocèle !");
        }

        clavier.close();
    }

    static void initPoint(Point p) {
        double x = 0;
        double y = 0;
        System.out.println("Construction d'un nouveau point");
        System.out.print(" Veuillez entrer x : ");
        x = clavier.nextDouble();
        System.out.print(" Veuillez entrer y : ");
        y = clavier.nextDouble();
// eventuellement des tests d'intégrité des données lues
// et donner plusieurs chances de saisie à l'utilisateur
        p.setPoint(x,y);
    }

}

class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calculerDistance(Point p){
        return Math.sqrt( Math.pow(this.getX() - p.getX(), 2) + Math.pow(this.getY() - p.getY(), 2));
    }
}

class Triangle {
    private Point[] sommets = new Point[3];

    public void setSommets(Point p1, Point p2, Point p3){
            sommets[0] = p1;
            sommets[1] = p2;
            sommets[2] = p3;
    }

    public double perimetre(){
        double perimetre = sommets[0].calculerDistance(sommets[1]);
        perimetre += sommets[0].calculerDistance(sommets[2]);
        perimetre += sommets[1].calculerDistance(sommets[2]);

        return perimetre;
    }

    public boolean isIsocele (){
        return ( sommets[0].calculerDistance(sommets[1]) == sommets[0].calculerDistance(sommets[2]) ||
                 sommets[0].calculerDistance(sommets[1]) == sommets[1].calculerDistance(sommets[2]) ||
                 sommets[0].calculerDistance(sommets[2]) == sommets[1].calculerDistance(sommets[2])    );
    }
}