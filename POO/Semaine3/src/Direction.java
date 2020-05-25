import java.time.LocalDate;
import java.util.ArrayList;

public class Direction {
    public static void main(String[] args) {
        ArrayList<Personne> personnes = new ArrayList<>();

        EtudiantRegulier etudiantRegulier = new EtudiantRegulier("Gaston Peutimide", 2013,
                "systèmes de communication", 6.0);

        EtudiantRegulier etudiantRegulier2 = new EtudiantRegulier("Yvan Rattrapeu", 2011,
                "systèmes de communication", 2.5);

        EtudiantEtranger etudiantEtranger = new EtudiantEtranger("Yvan Rattrapeu", 2012,
                "informatique", "KTH");

        Enseignant enseignant = new Enseignant("Mathieu Matheu", 1998,
                "Mathématiques Extrêmement Pures", "physique", 10000);

        Secretiare secretiare = new Secretiare("Sophie Scribona", 2005, "Machines à Taper",
                5000);

        personnes.add(etudiantRegulier);
        personnes.add(etudiantRegulier2);
        personnes.add(etudiantEtranger);
        personnes.add(enseignant);
        personnes.add(secretiare);

        int nbEtudiants = 0;
        int anneeCourante = LocalDate.now().getYear();
        double moyenneAnnee = 0;

        for(Personne personne : personnes){
            moyenneAnnee += (anneeCourante - personne.getAnneeArrivee());
            if(personne.estEtudiant()){
                ++nbEtudiants;
            }
        }

        System.out.println("Parmi les "+personnes.size()+" EPFLiens, "+nbEtudiants+" sont des etudiants.");

        System.out.println("Ils sont à l'EPFL depuis en moyenne "+(moyenneAnnee / personnes.size())+" ans");


        System.out.println("Liste des EPFLiens:");
        for(Personne personne : personnes){
            personne.afficher();
        }



    }
}

class Personne {
    private String nom;
    private int anneeArrivee;

    public Personne(String nom, int anneeArrivee) {
        this.nom = nom;
        this.anneeArrivee = anneeArrivee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnneeArrivee() {
        return anneeArrivee;
    }

    public void setAnneeArrivee(int anneeArrivee) {
        this.anneeArrivee = anneeArrivee;
    }

    public boolean estEtudiant(){
        return false;
    }

    public void afficher() {
        System.out.println("    Nom : "+getNom());
        System.out.println("    Annee : "+getAnneeArrivee());
    }
}

class Personnel extends Personne{
    private String nomLaboratoire;
    private double salaire;

    public Personnel(String nom, int anneeArrivee, String nomLaboratoire, double salaire) {
        super(nom, anneeArrivee);
        this.nomLaboratoire = nomLaboratoire;
        this.salaire = salaire;
    }

    public String getNomLaboratoire() {
        return nomLaboratoire;
    }

    public void setNomLaboratoire(String nomLaboratoire) {
        this.nomLaboratoire = nomLaboratoire;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("    Laboratoire : "+getNomLaboratoire());
        System.out.println("    Salaire : "+getSalaire());
    }
}

class Etudiant extends Personne{
    private String nomSection;

    public Etudiant(String nom, int anneeArrivee, String nomSection) {
        super(nom, anneeArrivee);
        this.nomSection = nomSection;
    }

    public String getNomSection() {
        return nomSection;
    }

    public void setNomSection(String nomSection) {
        this.nomSection = nomSection;
    }

    @Override
    public boolean estEtudiant() {
        return true;
    }
    @Override
    public void afficher() {
        super.afficher();
        System.out.println("    Section : "+getNomSection());
    }
}

class Secretiare extends Personnel {

    public Secretiare(String nom, int anneeArrivee, String nomLaboratoire, double salaire) {
        super(nom, anneeArrivee, nomLaboratoire, salaire);
    }

    @Override
    public void afficher() {
        System.out.println("Secretaire:");
        super.afficher();
    }
}

class Enseignant extends Personnel {
    private String nomSection;

    public Enseignant(String nom, int anneeArrivee, String nomLaboratoire, String nomSection, double salaire) {
        super(nom, anneeArrivee, nomLaboratoire, salaire);
        this.nomSection = nomSection;
    }

    public String getNomSection() {
        return nomSection;
    }

    public void setNomSection(String nomSection) {
        this.nomSection = nomSection;
    }

    @Override
    public void afficher() {
        System.out.println("Enseignant:");
        super.afficher();
        System.out.println("    Section d'enseignement : "+getNomSection());
    }

}

class EtudiantEtranger extends Etudiant {
    private String nomUniversiteOrigine;

    public EtudiantEtranger(String nom, int anneeArrivee, String nomSection, String nomUniversiteOrigine) {
        super(nom, anneeArrivee, nomSection);
        this.nomUniversiteOrigine = nomUniversiteOrigine;
    }

    public String getNomUniversiteOrigine() {
        return nomUniversiteOrigine;
    }

    public void setNomUniversiteOrigine(String nomUniversiteOrigine) {
        this.nomUniversiteOrigine = nomUniversiteOrigine;
    }

    @Override
    public void afficher() {
        System.out.println("Etudiant d'echange:");
        super.afficher();
        System.out.println("    Uni d'origine : "+getNomUniversiteOrigine());
    }
}

class EtudiantRegulier extends Etudiant {
    private double note;

    public EtudiantRegulier(String nom, int anneeArrivee, String nomSection, double note) {
        super(nom, anneeArrivee, nomSection);
        this.note = note;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public void afficher() {
        System.out.println("Etudiant régulier:");
        super.afficher();
        System.out.println("    Moyenne : "+getNote());
    }
}
