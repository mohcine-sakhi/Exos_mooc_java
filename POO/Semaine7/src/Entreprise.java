import java.util.ArrayList;

public class Entreprise {
    public static void main (String[] args){
        Personnel personnel = new Personnel();
// On crée un employé Temporaire "T1", et on l'embauche
        Temporaire t1 = new Temporaire("T1", 21, 20);
        personnel.embaucher(t1);
        personnel.afficherEmploye("T1");
// On le mute dans la categorie Permanent
        personnel.muter(new Permanent(t1, 4200, 0, false, 110));
        personnel.afficherEmploye("T1");
        System.out.println();
// On crée un employé temporaire "P3", et on l'embauche
        Permanent p3 = new Permanent("P3", 20, 2000, 1, true, 100);
        personnel.embaucher(p3);
        personnel.afficherEmploye("P3");
// On le mute dans la categoire de Temporaire
        personnel.muter(new Temporaire(p3, 20));
        personnel.afficherEmploye("P3");


    }
}
//*******************************************************************************************************************
abstract class Employe {
    private String statut;
    private String nom;

    public Employe(String statut, String nom) {
        this.statut = statut;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        String chaine =  "L'employé "+ nom +"\n";
        chaine += "      statut : "+ statut +"\n";

        return chaine;
    }

    public abstract double salaireCumule();
}
//*******************************************************************************************************************

class Permanent extends Employe {
    public static final int JOURS_OEUVRES = 20;
    private int nbJoursTravailles;
    private double salaireMensuel;
    private int nbEnfants;
    private boolean marie;
    private double primeMensuelle;

    public Permanent(String nom, int nbJoursTravailles, double salaireMensuel, int nbEnfants, Boolean marie, double primeMensuelle) {
        super("permanent", nom);
        this.nbJoursTravailles = nbJoursTravailles;
        this.salaireMensuel = salaireMensuel;
        this.nbEnfants = nbEnfants;
        this.marie = marie;
        this.primeMensuelle = primeMensuelle;
    }

    public Permanent(Employe employe, double salaireMensuel, int nbEnfants, Boolean marie, double primeMensuelle){
        this(employe.getNom(), 0, salaireMensuel, nbEnfants, marie, primeMensuelle);
        this.nbJoursTravailles = (int) ((employe.salaireCumule() * JOURS_OEUVRES) / salaireMensuel);

    }

    public static int getJoursOeuvres() {
        return JOURS_OEUVRES;
    }

    public int getNbJoursTravailles() {
        return nbJoursTravailles;
    }

    public void setNbJoursTravailles(int nbJoursTravailles) {
        this.nbJoursTravailles = nbJoursTravailles;
    }

    public double getSalaireMensuel() {
        return salaireMensuel;
    }

    public void setSalaireMensuel(double salaireMensuel) {
        this.salaireMensuel = salaireMensuel;
    }

    public int getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(int nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public Boolean getMarie() {
        return marie;
    }

    public void setMarie(Boolean marie) {
        this.marie = marie;
    }

    public double getPrimeMensuelle() {
        return primeMensuelle;
    }

    public void setPrimeMensuelle(double primeMensuelle) {
        this.primeMensuelle = primeMensuelle;
    }

    @Override
    public double salaireCumule() {
        double salaire = salaireMensuel;
        if(marie){
            salaire += primeMensuelle * nbEnfants;
        }
        salaire *= nbJoursTravailles  /(double)JOURS_OEUVRES; // pour avoir la division normale

        return  salaire;
    }

    @Override
    public String toString() {
        String chaine = super.toString();
        chaine+= "      salaire Mensuel : " + salaireMensuel + "\n";
        chaine+= "      marié : " + (marie ? "oui" : "non") + "\n";
        chaine+= "      nb d'enfants : " + nbEnfants + "\n";
        chaine+= "      prime mensuelle : " + primeMensuelle + "\n";
        chaine+= "      nb de jours Travailles : " + nbJoursTravailles + "\n";
        chaine+= "      salaire cumule : " + salaireCumule() + "\n";

        return chaine;

    }
}
//*******************************************************************************************************************

class Temporaire extends Employe {
    private double salaireHoraire;
    private int nbHeures;


    public Temporaire(String nom, double salaireHoraire, int nbHeures) {
        super("temporaire", nom);
        this.salaireHoraire = salaireHoraire;
        this.nbHeures = nbHeures;
    }
    public Temporaire(String statut, String nom, double salaireHoraire, int nbHeures) {
        super(statut, nom);
        this.salaireHoraire = salaireHoraire;
        this.nbHeures = nbHeures;
    }

    public Temporaire(Employe employe, double salaireHoraire) {
        this(employe.getNom(), salaireHoraire, 0);

        this.nbHeures = (int) (employe.salaireCumule() / salaireHoraire);
    }

    public double getSalaireHoraire() {
        return salaireHoraire;
    }

    public void setSalaireHoraire(double salaireHoraire) {
        this.salaireHoraire = salaireHoraire;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    @Override
    public double salaireCumule() {
        return salaireHoraire * nbHeures;
    }

    @Override
    public String toString() {
        String chaine = super.toString();
        chaine += afficher();
        chaine+="      salaire cumule : " + salaireCumule() + "\n";

        return chaine;

    }

    public String afficher(){
        String chaine = "      salaire horaire : " + salaireHoraire + "\n";
        chaine+= "      nb heures : " + nbHeures + "\n";

        return chaine;
    }
}
//*******************************************************************************************************************

class Vendeur extends Temporaire {
    private double volumeVente;
    private double commision;

    public Vendeur(String nom, double salaireHoraire, int nbHeures, double volumeVente, double commision) {
        super("vendeur", nom, salaireHoraire, nbHeures);
        this.volumeVente = volumeVente;
        this.commision = commision;
    }

    public Vendeur(Employe employe, double salaireHoraire, double commision) {
        this(employe.getNom(), salaireHoraire, 0, 0, commision);
        this.volumeVente = employe.salaireCumule() / commision;

    }

    @Override
    public double salaireCumule() {
        return super.salaireCumule() + volumeVente * commision;
    }
    public String afficher(){
        String chaine = "      volume de ventes : " + volumeVente + "\n";
        chaine+= "      commission : " + commision + "\n";

        return chaine;
    }
}

class Personnel {
    private ArrayList<Employe> employes;

    public Personnel() {
        employes = new ArrayList<>();
    }

    public void embaucher(Employe employe){
        if(employe != null){
            employes.add(employe);
        }
    }

    public void licencier(String nom){
        Employe employe = null;
        for(int i = 0; i < employes.size(); ++i){
            if(employes.get(i).getNom().equals(nom)){
                employe = employes.get(i);
                break;
            }
        }

        if(employe != null){
            employes.remove(employe);
        }
    }

    public void muter(Employe nouvelleCategorieEmploye){
        int index = -1;
        for(int i = 0; i < employes.size(); ++i){
            if(employes.get(i).getNom().equals(nouvelleCategorieEmploye.getNom())){
                index = i;
                break;
            }
        }

        if(index != -1){
            employes.set(index, nouvelleCategorieEmploye);
        }
    }

    public void afficherEmploye(String nom){

        for(int i = 0; i < employes.size(); ++i){
            if(employes.get(i).getNom().equals(nom)){
                System.out.println(employes.get(i));
                break;
            }
        }
    }

    public void afficher(){
        for(Employe employe : employes){
            System.out.println(employe);
        }
    }

}