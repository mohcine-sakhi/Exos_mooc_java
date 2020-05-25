import java.util.ArrayList;

class Salaires {
    public static void main(String[] args) {
        Personnel p = new Personnel();
        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
        p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 1000));
        p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));

        p.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + " francs.");
    }
}

abstract class Employe {
    private String nom;
    private String prenom;
    private int age;
    private String dateEntreeEnService;

    public Employe(String nom, String prenom, int age, String dateEntreeEnService) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateEntreeEnService = dateEntreeEnService;
    }

    public String getTitre(){
        return "L'employé ";
    }

    public String getNom(){
        return getTitre()+ nom +" "+ prenom;
    }

    abstract public double calculerSalaire();
}

interface Prime {
    double PRIME = 200;
    double prime();
}

class Vendeur extends Employe {
    private final static double POURCENT_VENDEUR = 0.2;
    private final static double MONTANT_FIXE = 400;
    private double chiffreAffaire;

    public Vendeur(String nom, String prenom, int age, String dateEntreeEnService, double chiffreAffaire) {
        super(nom, prenom, age, dateEntreeEnService);
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    public double calculerSalaire() {
        return POURCENT_VENDEUR * chiffreAffaire + MONTANT_FIXE;
    }

    @Override
    public String getTitre() {
        return "Le Vendeur ";
    }
}

class Representant extends Employe {
    private final static double POURCENT_VENDEUR = 0.2;
    private final static double MONTANT_FIXE = 800;
    private double chiffreAffaire;

    public Representant(String nom, String prenom, int age, String dateEntreeEnService, double chiffreAffaire) {
        super(nom, prenom, age, dateEntreeEnService);
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    public double calculerSalaire() {
        return POURCENT_VENDEUR * chiffreAffaire + MONTANT_FIXE;
    }

    @Override
    public String getTitre() {
        return "Le Representant ";
    }

}

class Technicien extends Employe {
    private final static double FACTEUR_UNITE = 5.0;
    private int nbUnitesProduites;

    public Technicien(String nom, String prenom, int age, String dateEntreeEnService, int nbUnitesProduites) {
        super(nom, prenom, age, dateEntreeEnService);
        this.nbUnitesProduites = nbUnitesProduites;
    }

    @Override
    public double calculerSalaire() {
        return nbUnitesProduites * FACTEUR_UNITE;
    }

    @Override
    public String getTitre() {
        return "Le Technicien ";
    }
}

class Manutentionnaire extends Employe {
    private final static double SALAIRE_HORAIRE = 65.0;
    private int nbHeurestravaillees;

    public Manutentionnaire(String nom, String prenom, int age, String dateEntreeEnService, int nbHeurestravaillees) {
        super(nom, prenom, age, dateEntreeEnService);
        this.nbHeurestravaillees = nbHeurestravaillees;
    }

    @Override
    public double calculerSalaire() {
        return nbHeurestravaillees * SALAIRE_HORAIRE;
    }


    @Override
    public String getTitre() {
        return "Le Manutentionnaire ";
    }

}

class TechnARisque extends Technicien implements Prime {

    public TechnARisque(String nom, String prenom, int age, String dateEntreeEnService, int nbUnitesProduites) {
        super(nom, prenom, age, dateEntreeEnService, nbUnitesProduites);
    }

    @Override
    public double prime() {
        return PRIME;
    }

    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + prime();
    }
}

class ManutARisque extends Manutentionnaire implements Prime {


    public ManutARisque(String nom, String prenom, int age, String dateEntreeEnService, int nbHeurestravaillees) {
        super(nom, prenom, age, dateEntreeEnService, nbHeurestravaillees);
    }

    @Override
    public double prime() {
        return PRIME;
    }

    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + prime();
    }
}

class Personnel {
    private ArrayList<Employe> employes;

    public Personnel() {
        employes = new ArrayList<>();
    }

    public void ajouterEmploye(Employe employe) {
        if(employe != null){
            employes.add(employe);
        }
    }

    public void afficherSalaires(){
        employes.stream().forEach((employe) -> System.out.println(employe.getNom()+" gagne "+employe.calculerSalaire()+" francs.") );
    }

    public double salaireMoyen(){
        double salaireMoyn = 0;
        for(int i = 0; i < employes.size(); ++i){
            salaireMoyn  += employes.get(i).calculerSalaire();
        }

        return salaireMoyn /= employes.size();
    }
}