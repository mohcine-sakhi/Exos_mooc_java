import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class OptionVoyage {
    private String nom;
    private Double prix;

    public OptionVoyage(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public Double prix() {
        return prix;
    }

    @Override
    public String toString() {
        return getNom()+" -> "+prix()+" CHF";
    }
}

class Sejour extends OptionVoyage {
    private int nbDeNuits;
    private double prixParNuit;


    public Sejour(String nom, Double prix, int nbDeNuits, double prixParNuit) {
        super(nom, prix);
        this.nbDeNuits =  nbDeNuits;
        this.prixParNuit =  prixParNuit;
    }

    @Override
    public Double prix() {
        return super.prix() + nbDeNuits * prixParNuit;
    }
}

class Transport extends OptionVoyage {
    public final static double TARIF_LONG = 1500.0;
    public final static double TARIF_BASE = 200.0;
    private boolean trajetLong;

    public Transport(String nom, Double prix, boolean trajetLong) {
        super(nom, prix);
        this.trajetLong = trajetLong;
    }

    public Transport(String nom, Double prix) {
        super(nom, prix);
        this.trajetLong = false;
    }

    @Override
    public Double prix() {
        if(trajetLong){
            return super.prix() + TARIF_LONG;
        }else{
            return super.prix() + TARIF_BASE;
        }

    }
}

class KitVoyage {
    private ArrayList<OptionVoyage> options;
    private String depart;
    private String destination;

    public KitVoyage(String depart, String destination) {
        this.options = new ArrayList<>();
        this.depart = depart;
        this.destination = destination;
    }

    public double prix(){
        double prixTotal = 0;
        for(OptionVoyage option : options){
            prixTotal += option.prix();
        }
        return prixTotal;
    }

    @Override
    public String toString() {
        String chaine = "Voyage de "+depart+" à "+destination+", avec pour options :\n";
        for(OptionVoyage option : options){
           chaine += "  - "+option.toString()+"\n";
        }
        chaine += "Prix total : "+prix()+" CHF\n";

        return chaine;
    }

    public void ajouterOption(OptionVoyage optionVoyage){
        if(optionVoyage != null){
            options.add(optionVoyage);
        }
    }

    public void annuler(){
        options.clear();
    }

    public int getNbOptions(){
        return options.size();
    }
}
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1


        // TEST 2
        System.out.println("Test partie 2 : ");
        System.out.println("----------------");

        Transport transp1 = new Transport("Trajet en car ", 50.0);
        System.out.println(transp1.toString());

        Transport transp2 = new Transport("Croisière", 1300.0);
        System.out.println(transp2.toString());

        Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
        System.out.println(sejour1.toString());
        System.out.println();

        // FIN TEST


        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }
}
