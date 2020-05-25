import java.util.Objects;

class ToStringEq
{
    public static void main(String[] args)
    {
        System.out.println("Test 1 :");
        Rectangle rect = new Rectangle(12.5, 4.0);
        System.out.println(rect);
        System.out.println();
        System.out.println("Test 2: ");
// le type de rect1 est RectangleColore
// l'objet contenu dans rect1 est de type RectangleColore
        RectangleColore rect1 = new RectangleColore(12.5, 4.0, "rouge");
        System.out.println(rect1);
        System.out.println();
        System.out.println("Test 3 :");
// le type de rect2 est Rectangle
// l'objet contenu dans rect2 est de type RectangleColore
        Rectangle rect2 = new RectangleColore(25.0/2, 8.0/2, new String("rouge"));
        System.out.println(rect2);
        System.out.println (rect1.equals(rect2)); // 1.
        System.out.println (rect2.equals(rect1)); // 2.
        System.out.println(rect1.equals(null)); // 3.
        System.out.println (rect.equals(rect1)); // 4.
        System.out.println (rect1.equals(rect)); // 5.
    }
}

class Rectangle {
    private double longueur;
    private double largeur;

    public Rectangle(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "longueur=" + longueur +
                ", largeur=" + largeur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        else if (o.getClass() != this.getClass()) return false;
            else{
            Rectangle rectangle = (Rectangle) o;
            return Double.compare(rectangle.longueur, longueur) == 0 &&
                    Double.compare(rectangle.largeur, largeur) == 0;
        }
    }
}

class RectangleColore  extends Rectangle {
    private String couleur;

    public RectangleColore(double longueur, double largeur, String couleur) {
        super(longueur, largeur);
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return super.toString() +
                "couleur='" + couleur + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        if (!super.equals(o)) return false;
        RectangleColore that = (RectangleColore) o;
        return (that.couleur.equals(couleur));
    }


}