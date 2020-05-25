public class TestCercle {
    public static void main(String[] args) {
        Cercle c1 = new Cercle();
        Cercle c2 = new Cercle();
        Cercle c3 = new Cercle();

        c1.setCentre(0, 0);
        c1.setRayon(1);

        c2.setCentre(0, 0);
        c2.setRayon(2);

        c3.setCentre(1, 1);
        c3.setRayon(3);

        System.out.println("C1 a une surface de "+c1.surface());
        System.out.println("C2 a une surface de "+c2.surface());
        System.out.println("C3 a une surface de "+c3.surface());

        System.out.println("le point (2,2) est a l interieur du C3 : "+c3.estInterieur(2,2));

    }
}

class Cercle {

    private double rayon;
    private double x;
    private double y;

    public void setCentre(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setRayon(double rayon){
        if(rayon <= 0){
            rayon = 0;
        }
        this.rayon = rayon;
    }

    public double surface(){
        return Math.PI * rayon * rayon;
    }

    public boolean estInterieur(double x, double y){
       return Math.sqrt( Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)) <= this.rayon;
    }

}