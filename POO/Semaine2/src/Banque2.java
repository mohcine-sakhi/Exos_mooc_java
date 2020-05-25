public class Banque2 {
    public static void main(String[] args) {
        Compte comptePrive1 = new Compte(1000, 0.01);
        Compte compteEpargne1 = new Compte(2000, 0.02);

        Compte comptePrive2 = new Compte(3000, 0.01);
        Compte compteEpargne2 = new Compte(4000, 0.02);

        Client client1 = new Client("Pedro", "Geneve", true, comptePrive1, compteEpargne1);
        Client client2 = new Client("Alexandra", "Lausanne", false, comptePrive2, compteEpargne2);

        System.out.println("Donnees avant le bouclement des comptes:");
        System.out.println(client1);
        System.out.println(client2);

        System.out.println("Donnees après le bouclement des comptes:");
        comptePrive1.setSolde(comptePrive1.bouclerCompte());
        compteEpargne1.setSolde(compteEpargne1.bouclerCompte());

        comptePrive2.setSolde(comptePrive2.bouclerCompte());
        compteEpargne2.setSolde(compteEpargne2.bouclerCompte());

        System.out.println(client1);
        System.out.println(client2);

        }
}

class Compte {
    private double solde;
    private double taux;

    public Compte(double solde, double taux) {
        this.solde = solde;
        this.taux = taux;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public double bouclerCompte() {
    // Cette méthode ajoute les intérêts au solde
        double interets = taux * solde;
        double nouveauSolde = solde + interets;
        return nouveauSolde;
    }
}

class Client {
    private String nom;
    private String ville;
    private boolean masculin;
    private Compte comptePrive;
    private Compte compteEpargne;


    public Client(String nom, String ville, boolean masculin, Compte comptePrive, Compte compteEpargne) {
        this.nom = nom;
        this.ville = ville;
        this.masculin = masculin;
        this.comptePrive = comptePrive;
        this.compteEpargne = compteEpargne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Compte getComptePrive() {
        return comptePrive;
    }

    public void setComptePrive(Compte comptePrive) {
        this.comptePrive = comptePrive;
    }

    public Compte getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(Compte compteEpargne) {
        this.compteEpargne = compteEpargne;
    }

    public String toString(){
        // Cette méthode affiche les données du client
        String client;
        if(masculin){
            client = "Client ";
        }else{
            client = "Cliente ";
        }
        client += nom + " de " + ville;
        client += "\n Compte prive: " + comptePrive.getSolde() + " francs";
        client +=  "\n Compte d'epargne: " + compteEpargne.getSolde() + " francs";

        return client;
    }
}
