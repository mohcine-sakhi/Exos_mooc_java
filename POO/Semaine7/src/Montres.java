import java.util.ArrayList;

public class Montres {
    public static void main(String[] args) {
        // test de l'affichage des mécanismes
        MecanismeAnalogique v1 = new MecanismeAnalogique(312.00, 20141212);
        MecanismeDigital   v2 = new MecanismeDigital(32.00, "11:45", "7:00");
        MecanismeDouble v3 = new MecanismeDouble(543.00, "8:20", 20140328, "6:30");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        // Test des montres


        Montre montre = new Montre(new MecanismeDouble(468.00, "9:15", 20140401, "7:00"));


        montre.ajouter(new Bracelet("cuir", 54.0));
        montre.ajouter(new Fermoir("acier", 12.5));
        montre.ajouter(new Boitier("acier", 36.6));
        montre.ajouter(new Vitre("quartz", 44.8));

        System.out.println("Montre m : ");
        montre.aficher();
    }
}

//======================================================================================================================
abstract class Produit {
    private final double valeur;

    public Produit() {
        valeur = 0.0;
    }

    public Produit(double valeur) {
        this.valeur = valeur;
    }

    public Produit(Produit produit){
        valeur = produit.valeur;
    }

    public double prix(){
        return valeur;
    }

    public String toString(){
        return Double.toString(prix());
    }


}
//======================================================================================================================
class Montre extends Produit {
    private Mecanisme coeur;
    private ArrayList<Accessoire> accessoires;

    public Montre(Mecanisme depart) {
        this.coeur = depart.copie();
        accessoires = new ArrayList<>();
    }

    public Montre(Montre montre){
        super(montre);
        coeur = montre.coeur.copie();
        accessoires = new ArrayList<>();
        for(Accessoire accessoire : montre.accessoires){
            accessoires.add(accessoire.copie());
        }
    }

    public void ajouter(Accessoire accessoire){
        if(accessoire != null){
            accessoires.add(accessoire.copie());
        }
    }

    @Override
    public double prix() {
        double prixTotal = super.prix();

        prixTotal += coeur.prix();

        for(Accessoire accessoire : accessoires){
            prixTotal += accessoire.prix();
        }

        return prixTotal;
    }

    public void aficher() {
        System.out.println("Une montre composée de : ");
        System.out.println("    * " +coeur);
        for (Accessoire accessoire : accessoires){
            System.out.println("    * " + accessoire);
        }

        System.out.println("==> Prix total : "+prix());
    }
}
//======================================================================================================================
abstract class Mecanisme extends Produit {
    private String heure;

    public Mecanisme(double valeur) {
        super(valeur);
        heure = "12:00";
    }

    public Mecanisme(double valeur, String heure) {
        super(valeur);
        this.heure = heure;
    }

    public Mecanisme(Mecanisme mecanisme){
        super(mecanisme);
        heure = mecanisme.heure;
    }

    public abstract Mecanisme copie();

    protected String toStringCadran(){
        return heure;
    }

    protected abstract String toStringType();

    @Override
    public final String toString() {
        String result = "mécanisme ";
        result += toStringType();
        result += " (affichage : ";
        result += toStringCadran();
        result += " ); prix : ";
        result += super.toString();

        return result;
    }
}
//======================================================================================================================
class MecanismeAnalogique extends Mecanisme {
    private int date;

    public MecanismeAnalogique(double valeur, int date) {
        super(valeur);
        this.date = date;
    }

    public MecanismeAnalogique(double valeur, String heure, int date) {
        super(valeur, heure);
        this.date = date;
    }

    public MecanismeAnalogique(MecanismeAnalogique mecanismeAnalogique){
        super(mecanismeAnalogique);
        date = mecanismeAnalogique.date;
    }

    @Override
    public MecanismeAnalogique copie() {
        return new MecanismeAnalogique(this);
    }

    @Override
    protected String toStringType() {
        return "analogique";
    }

    protected String toStringDate(){
        return "date : " + date;
    }

    @Override
    protected String toStringCadran() {
        return super.toStringCadran()+", "+toStringDate();
    }
}
//======================================================================================================================
interface ReveilDigital {
    String toStringReveil();
}
//======================================================================================================================
class MecanismeDigital extends Mecanisme implements ReveilDigital {
    private String reveil;

    public MecanismeDigital(double valeur, String reveil) {
        super(valeur);
        this.reveil = reveil;
    }

    public MecanismeDigital(double valeur, String heure, String reveil) {
        super(valeur, heure);
        this.reveil = reveil;
    }

    public MecanismeDigital(MecanismeDigital mecanismeDigital){
        super(mecanismeDigital);
        reveil = mecanismeDigital.reveil;
    }

    @Override
    public MecanismeDigital copie() {
        return new MecanismeDigital(this);
    }

    @Override
    protected String toStringType() {
        return "digital";
    }

    public String toStringReveil(){
        return "reveil " + reveil;
    }

    @Override
    protected String toStringCadran() {
        return super.toStringCadran()+", "+toStringReveil();
    }
}
//======================================================================================================================
class MecanismeDouble extends MecanismeAnalogique implements ReveilDigital {
    private String reveil;

    public MecanismeDouble(double valeur, int date, String reveil) {
        super(valeur, date);
        this.reveil = reveil;
    }

    public MecanismeDouble(double valeur, String heure, int date, String reveil) {
        super(valeur, heure, date);
        this.reveil = reveil;
    }

    public MecanismeDouble(MecanismeDouble mecanismeDouble){
        super(mecanismeDouble);
        reveil = mecanismeDouble.reveil;
    }

    @Override
    public MecanismeDouble copie() {
        return new MecanismeDouble(this);
    }

    @Override
    protected String toStringType() {
        return "double";
    }

    public String toStringReveil(){
        return "reveil " + reveil;
    }

    @Override
    protected String toStringCadran() {
       String result = "sur l'écran : ";
       result += super.toStringCadran();
       result += ", sous les aiguilles : ";
       result += toStringReveil();

       return  result;
    }
}
//======================================================================================================================
abstract class Accessoire extends Produit {
    private final String nom;

    public Accessoire(String nom, double valeur) {
        super(valeur);
        this.nom = nom;
    }

    public Accessoire(Accessoire accessoire){
        super(accessoire);
        nom = accessoire.nom;
    }

    public abstract Accessoire copie();

    @Override
    public String toString() {
        String result = nom + " coûtant ";
        result += super.toString();

        return result;
    }
}
//======================================================================================================================
class Boitier extends Accessoire {

    public Boitier(String nom, double valeur) {
        super("boitier " + nom, valeur);
    }
    public Boitier(Boitier boitier){
        super(boitier);
    }

    @Override
    public Boitier copie() {
        return new Boitier(this);
    }
}
//======================================================================================================================
class Bracelet extends Accessoire {

    public Bracelet(String nom, double valeur) {
        super("bracelet " + nom, valeur);
    }

    public Bracelet(Bracelet bracelet){
        super(bracelet);
    }

    @Override
    public Bracelet copie() {
        return new Bracelet(this);
    }
}
//======================================================================================================================
class Fermoir extends Accessoire {

    public Fermoir(String nom, double valeur) {
        super("fermoir " + nom, valeur);
    }

    public Fermoir(Fermoir fermoir){
        super(fermoir);
    }

    @Override
    public Fermoir copie() {
        return new Fermoir(this);
    }

}
//======================================================================================================================
class Vitre extends Accessoire {

    public Vitre(String nom, double valeur) {
        super("vitre " + nom, valeur);
    }

    public Vitre(Vitre vitre){
        super(vitre);
    }

    @Override
    public Vitre copie() {
        return new Vitre(this);
    }


}