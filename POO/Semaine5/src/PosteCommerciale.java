import javax.crypto.spec.PSource;
import java.util.ArrayList;

public class PosteCommerciale {
    public static void main(String[] args) {
        //Cr'eation d'une boite-aux-lettres
        Boite boite = new Boite();
//Creation de divers courriers/colis..
       /* Lettre lettre1 = new Lettre(200, true, "Chemin des Acacias 28, 1009 Pully", "A3");
        Lettre lettre2 = new Lettre(800, false, "", "A4"); // invalide
        Publicite pub1 = new Publicite(1500, true, "Les Moilles 13A, 1913 Saillon");
        Publicite pub2 = new Publicite(3000, false, ""); // invalide
        Colis colis1 = new Colis(5000, true, "Grand rue 18, 1950 Sion", 30);
        Colis colis2 = new Colis(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); //Colis invalide !
        boite.ajouterCourrier(lettre1);
        boite.ajouterCourrier(lettre2);
        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(pub2);
        boite.ajouterCourrier(colis1);
        boite.ajouterCourrier(colis2);*/

        //Creation de divers courriers/colis..
        Publicite pub1 = new Publicite(1500, true, "Les Moilles 13A, 1913 Saillon");
        Publicite pub2 = new Publicite(3000, false, "Ch. de l'Impasse 1, 9999 Nowhere");
        ColisCommercial colisCom1 = new ColisCommercial(7000, false, "Route de la rape 11, 1509 Vucherens", 25);
        ColisCommercial colisCom2 = new ColisCommercial(2500, true, "Route du Rameau 14b, 404 Notfound", 21);
        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(pub2);
        boite.ajouterCourrier(colisCom1);
        boite.ajouterCourrier(colisCom2);


        System.out.println("Le montant total d'affranchissement est de " +
                boite.affranchir());
        boite.afficher();
        System.out.println("La boite contient " + boite.courriersInvalides()
                + " courriers invalides");

    }
}

class Boite {
    private ArrayList<Courrier> courriers;

    public Boite(){
        courriers = new ArrayList<>();
    }

    public void ajouterCourrier(Courrier courrier){
        if(courrier != null){
            courriers.add(courrier);
        }
    }

    public void afficher(){
        courriers.stream().forEach((courrier) -> courrier.afficher());
    }

    public double affranchir(){
        double montantTotal = 0;
        for(Courrier courrier : courriers){
            montantTotal += courrier.affranchir();
        }
        return montantTotal;
    }

    public int courriersInvalides(){
        int nbInvalides = 0;
        for(Courrier courrier : courriers){
            if(! courrier.valide()){
                ++nbInvalides;
            }
        }
        return nbInvalides;
    }


}
abstract class Courrier {
    private double poids;
    private boolean modeExpedition;
    private String adresseDestination;

    public Courrier(double poids, boolean modeExpedition, String adresseDestination) {
        this.poids = poids;
        this.modeExpedition = modeExpedition;
        this.adresseDestination = adresseDestination;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public boolean isModeExpedition() {
        return modeExpedition;
    }

    public void setModeExpedition(boolean modeExpedition) {
        this.modeExpedition = modeExpedition;
    }

    public String getAdresseDestination() {
        return adresseDestination;
    }

    public void setAdresseDestination(String adresseDestination) {
        this.adresseDestination = adresseDestination;
    }

    public boolean valide(){
        return getAdresseDestination().length() > 0;
    }

    abstract public double prix();

    public double affranchir(){
        double montant = prix();
        if(! valide()){
            return 0.0;
        }else{
            if(isModeExpedition()){
                montant *= 2;
            }
        }
        return montant;
    }
    public void afficher(){
        if(! valide()){
            System.out.println("(Courrier invalide)");
        }
        System.out.println("    Poids : "+getPoids()+" grammes");
        System.out.println("    Express : "+(isModeExpedition() ? "OUI" : "Non"));
        System.out.println("    Destination : "+getAdresseDestination());
        System.out.println("    Prix : "+affranchir()+" CHF");

    }
}



class Lettre extends Courrier {
    private String format;

    public Lettre(double poids, boolean modeExpedition, String adresseDestination, String format) {
        super(poids, modeExpedition, adresseDestination);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public double prix() {
        double tarifDeBase = 0;
        if(getFormat().equals("A4")){
            tarifDeBase = 2.5;
        }
        if(getFormat().equals("A3")){
            tarifDeBase = 3.5;
        }
        return tarifDeBase + 1.0 * getPoids() / 1000; // poids en kg
    }

    @Override
    public boolean valide() {
        return super.valide();
    }

    @Override
    public void afficher() {
        System.out.println("Lettre : ");
        super.afficher();
        System.out.println("    Format : "+getFormat());
        System.out.println();
    }
}

class Colis extends Courrier {
    private double volume;

    public Colis(double poids, boolean modeExpedition, String adresseDestination, double volume) {
        super(poids, modeExpedition, adresseDestination);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    @Override
    public double prix() {
        return  0.25 * getVolume() + getPoids() / 1000 * 1.0;
    }

    @Override
    public boolean valide() {
        return (super.valide() && getVolume() <= 50);
    }

    @Override
    public void afficher() {
        System.out.println("Colis : ");
        super.afficher();
        System.out.println("    volume : "+getVolume()+" litres");
        if(getClass() != ColisCommercial.class){
            System.out.println();
        }

    }


}

class ColisCommercial extends Colis implements Commercial {

    public ColisCommercial(double poids, boolean modeExpedition, String adresseDestination, double volume) {
        super(poids, modeExpedition, adresseDestination, volume);
    }

    @Override
    public double deduction() {
        return 0.15;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("    Colis commercial");
        System.out.println();
    }

    @Override
    public double affranchir() {
        return super.affranchir() * (1 - deduction());
    }
}

class Publicite extends Courrier implements Commercial{

    public Publicite(double poids, boolean modeExpedition, String adresseDestination) {
        super(poids, modeExpedition, adresseDestination);
    }

    @Override
    public double prix() {
        return  5.0 * getPoids() / 1000;
    }

    @Override
    public boolean valide() {
        return super.valide();
    }

    @Override
    public void afficher() {
        System.out.println("Publicité : ");
        super.afficher();
        System.out.println();
    }

    @Override
    public double deduction() {
        return 0.2;
    }

    @Override
    public double affranchir() {
        return super.affranchir() * (1 - deduction());
    }
}

interface Commercial  {
    double deduction();
}