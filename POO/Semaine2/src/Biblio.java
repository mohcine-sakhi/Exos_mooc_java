import java.util.ArrayList;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    // Completer la classe Auteur ici
    private String nom;
    private boolean prix;

    public Auteur(String nom, boolean prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public boolean getPrix() {
        return prix;
    }
}

class Oeuvre {
    // Completer la classe Oeuvre ici
    private String titre;
    private Auteur auteur;
    private String langue;

    public Oeuvre(String titre, Auteur auteur, String langue) {
        this.titre = titre;
        this.auteur = auteur;
        this.langue = langue;
    }

    public Oeuvre(String titre, Auteur auteur) {
        this.titre = titre;
        this.auteur = auteur;
        this.langue = "francais";
    }

    public String getTitre() {
        return titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public String getLangue() {
        return langue;
    }

    public void afficher(){
        System.out.println(titre+", "+auteur.getNom()+", en "+langue);
    }
}

class Exemplaire {
    private Oeuvre oeuvre;

    public Exemplaire(Oeuvre oeuvre) {
        System.out.println("Nouvel exemplaire -> "+oeuvre.getTitre()+", "+oeuvre.getAuteur().getNom()+
                ", en "+oeuvre.getLangue());
        this.oeuvre = oeuvre;
    }

    public Exemplaire(Exemplaire exemplaire){
        System.out.println("Copie d'un exemplaire de -> "+exemplaire.oeuvre.getTitre()+", "+
                exemplaire.oeuvre.getAuteur().getNom()+", en "+exemplaire.oeuvre.getLangue());

        this.oeuvre = exemplaire.oeuvre;
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void afficher(){
        System.out.println("Un exemplaire de "+oeuvre.getTitre()+", "+
                oeuvre.getAuteur().getNom()+", en "+oeuvre.getLangue());
    }
}

// completer les autres classes ici
class Bibliotheque {
    private String nom;
    private ArrayList<Exemplaire> exemplaires;

    public Bibliotheque(String nom) {
        System.out.println("La bibliothèque "+nom+" est ouverte !");
        this.nom = nom;
        exemplaires = new ArrayList<>();
    }

    public String getNom(){
        return nom;
    }

    public int getNbExemplaires(){
        return exemplaires.size();
    }

    public void stocker(Oeuvre oeuvre, int  nbExemplaire){
        if(oeuvre != null){
            for(int i = 0; i < nbExemplaire; ++i){
                exemplaires.add(new Exemplaire(oeuvre));
            }
        }
    }

    public void stocker(Oeuvre oeuvre){
        if(oeuvre != null){
            exemplaires.add(new Exemplaire(oeuvre));
        }
    }

    public ArrayList<Exemplaire> listerExemplaires(String langue){
        ArrayList<Exemplaire> copies = new ArrayList<>();
        for(Exemplaire exemplaire : exemplaires){
            if(exemplaire.getOeuvre().getLangue().equals(langue)){
                copies.add(exemplaire);
            }
        }
        return copies;
    }

    public ArrayList<Exemplaire> listerExemplaires(){

        return exemplaires;
    }

    public int compterExemplaires(Oeuvre oeuvre){
        int nbExempl = 0;
        for(Exemplaire exemplaire : exemplaires){
            if(exemplaire.getOeuvre().getTitre().equals(oeuvre.getTitre())){
               ++nbExempl;
            }
        }
        return nbExempl;
    }

    public void afficherAuteur(boolean prix){
        for(Exemplaire exemplaire : exemplaires){
            if(exemplaire.getOeuvre().getAuteur().getPrix() == prix){
                System.out.println(exemplaire.getOeuvre().getAuteur().getNom());
            }
        }
    }

    public void afficherAuteur(){
        for(Exemplaire exemplaire : exemplaires){
            if(exemplaire.getOeuvre().getAuteur().getPrix() == true){
                System.out.println(exemplaire.getOeuvre().getAuteur().getNom());
            }
        }
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
        for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}