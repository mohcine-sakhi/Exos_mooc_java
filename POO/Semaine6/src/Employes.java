/******************************************
 * Completez le programme a partir d'ici.
 ******************************************/
import java.util.*;

class Employe {
    private final String nom;
    private double revenuMensuel;
    private int tauxOccupation;
    private double prime;

    public Employe(String nom, double revenuMensuel, int tauxOccupation) {
        this.nom = nom;
        this.revenuMensuel = revenuMensuel;
        if(tauxOccupation < 10){
            this.tauxOccupation = 10;
        }else if(tauxOccupation > 100){
            this.tauxOccupation = 100;
        }else{
            this.tauxOccupation = tauxOccupation;
        }
        this.prime = 0.0;
        System.out.println("Nous avons un nouvel employé : "+getNom()+", "+getProfession());

    }

    public Employe(String nom, double revenuMensuel) {
        this.nom = nom;
        this.revenuMensuel = revenuMensuel;
        this.tauxOccupation = 100;
        this.prime = 0.0;
        System.out.println("Nous avons un nouvel employé : "+getNom()+", "+getProfession());
    }

    public String getProfession(){
        return "";
    }


    public String getNom() {
        return nom;
    }


    public double getRevenuMensuel() {
        return revenuMensuel;
    }

    public int getTauxOccupation() {
        return tauxOccupation;
    }

    public double getPrime() {
        return prime;
    }

    public double revenuAnnuel(){
        return getRevenuMensuel() * 12 * getTauxOccupation() / 100 + getPrime();
    }

    @Override
    public String toString() {
        String chaine = getNom()+" :\n";
        chaine += "  Taux d'occupation : "+getTauxOccupation()+"%. Salaire annuel : "+String.format("%.2f", revenuAnnuel())+" francs";
        if(getPrime() != 0.0){
            chaine += ", Prime : "+String.format("%.2f", getPrime())+".\n";
        }else{
            chaine += ".\n";
        }

        return chaine;

    }

    public void demandePrime(){
        Scanner clavier = new Scanner(System.in);
        clavier.useLocale(Locale.ENGLISH);
        int tentative = 0;
        boolean echec;
        do{
            echec = false;
            try{
                System.out.println("Montant de la prime souhaitée par "+getNom()+" ?");
                prime = clavier.nextDouble();
                if(prime > 2 * revenuAnnuel() / 100){
                    System.out.println("Trop cher!");
                    prime = 0;
                    echec = true;
                }
            }catch(InputMismatchException e){
                System.out.println("Vous devez introduire un nombre!");
                echec = true;
                clavier.nextLine(); // pour purger l entree standard
            }
            ++tentative;

        }while(echec && tentative < 5);
    }


}

class Manager extends Employe {
    public static final double FACTEUR_GAIN_CLIENT = 500;
    public static final double FACTEUR_GAIN_VOYAGE = 100;
    private int nbJoursVoyages;
    private int nbClientsAmenes;

    public Manager(String nom, double revenuMensuel, int nbJoursVoyages, int nbClientsAmenes) {
        super(nom, revenuMensuel);
        this.nbJoursVoyages = nbJoursVoyages;
        this.nbClientsAmenes = nbClientsAmenes;

    }

    public Manager(String nom, double revenuMensuel, int tauxOccupation, int nbJoursVoyages, int nbClientsAmenes) {
        super(nom, revenuMensuel, tauxOccupation);
        this.nbJoursVoyages = nbJoursVoyages;
        this.nbClientsAmenes = nbClientsAmenes;

    }

    public int getNbJoursVoyages() {
        return nbJoursVoyages;
    }

    public int getNbClientsAmenes() {
        return nbClientsAmenes;
    }

    @Override
    public String getProfession() {
        return "c'est un manager.";
    }

    @Override
    public double revenuAnnuel() {
        return super.revenuAnnuel() + getNbClientsAmenes() * FACTEUR_GAIN_CLIENT + getNbJoursVoyages() * FACTEUR_GAIN_VOYAGE;
    }

    @Override
    public String toString() {
        String chaine =  super.toString();
        chaine += "  A voyagé "+getNbJoursVoyages()+" jours et apporté "+getNbClientsAmenes()+" nouveaux clients.\n";

        return chaine;

    }
}

class Programmeur extends Employe {
    public static final int FACTEUR_GAIN_PROJETS = 200;
    private int nbProjetsAcheves;

    public Programmeur(String nom, double revenuMensuel, int nbProjetsAcheves, int tauxOccupation) {
        super(nom, revenuMensuel, tauxOccupation);
        this.nbProjetsAcheves = nbProjetsAcheves;
    }

    public Programmeur(String nom, double revenuMensuel, int nbProjetsAcheves) {
        super(nom, revenuMensuel);
        this.nbProjetsAcheves = nbProjetsAcheves;
    }

    public int getNbProjetsAcheves() {
        return nbProjetsAcheves;
    }

    @Override
    public String getProfession() {
        return "c'est un programmeur.";
    }

    @Override
    public double revenuAnnuel() {
        return super.revenuAnnuel() + getNbProjetsAcheves() * FACTEUR_GAIN_PROJETS;
    }

    @Override
    public String toString() {
        String chaine =  super.toString();
        chaine += "  A mené à  bien "+getNbProjetsAcheves()+" projets\n";

        return chaine;

    }
}

class Testeur extends Employe {
    public static final int FACTEUR_GAIN_ERREURS = 10;
    private int nbErreursCorriges;

    public Testeur(String nom, double revenuMensuel, int nbErreursCorriges) {
        super(nom, revenuMensuel);
        this.nbErreursCorriges = nbErreursCorriges;
    }

    public Testeur(String nom, double revenuMensuel, int nbErreursCorriges, int tauxOccupation) {
        super(nom, revenuMensuel, tauxOccupation);
        this.nbErreursCorriges = nbErreursCorriges;
    }

    public int getNbErreursCorriges() {
        return nbErreursCorriges;
    }

    @Override
    public String getProfession() {
        return "c'est un testeur.";
    }

    @Override
    public double revenuAnnuel() {
        return super.revenuAnnuel() + getNbErreursCorriges() * FACTEUR_GAIN_ERREURS;
    }

    @Override
    public String toString() {
        String chaine =  super.toString();
        chaine += "  A corrigé "+getNbErreursCorriges()+" erreurs.\n";

        return chaine;

    }
}
/******************************************
 * Ne rien modifier apres cette ligne.
 ******************************************/

class Employes {
    public static void main(String[] args) {

        List<Employe> staff = new ArrayList<Employe>();

        // TEST PARTIE 1:

        System.out.println("Test partie 1 : ");
        staff.add(new Manager("Serge Legrand", 7456, 30, 4 ));
        staff.add(new Programmeur("Paul Lepetit" , 6456, 3, 75 ));
        staff.add(new Testeur("Pierre Lelong", 5456, 124, 50 ));

        System.out.println("Affichage des employés : ");
        for (Employe modele : staff) {
            System.out.println(modele);
        }
        // FIN TEST PARTIE 1
        // TEST PARTIE 2
        System.out.println("Test partie 2 : ");

        staff.get(0).demandePrime();

        System.out.println("Affichage après demande de prime : ");
        System.out.println(staff.get(0));

        // FIN TEST PARTIE 2
    }
}
