import java.util.ArrayList;
import java.util.Random;

/*******************************************
 * Completez le programme Ã  partir d'ici.
 *******************************************/
class Postulant {
    private String nom;
    private int votes;

    public Postulant(String nom) {
        this.nom = nom;
        this.votes = 0;
    }

    public Postulant(String nom, int votes) {
        this.nom = nom;
        this.votes = votes;
    }

    public Postulant(Postulant postulant) {
        this.nom = postulant.nom;
        this.votes = postulant.votes;
    }

    public String getNom() {
        return nom;
    }

    public int getVotes() {
        return votes;
    }

    public void elect(){
        ++votes;
    }

    public void init(){
        votes = 0;
    }
}

class Scrutin {
    private ArrayList<Vote> votes;
    private ArrayList<Postulant> postulants;
    private int votesMax;
    private int date;

    public Scrutin(ArrayList<Postulant> postulants, int votesMax, int date) {
        this.votes = new ArrayList<>();
        this.postulants = new ArrayList<>();
        if(postulants != null){
            for(int i = 0; i < postulants.size(); ++i){
                this.postulants.add(new Postulant(postulants.get(i)));
                this.postulants.get(i).init();
            }
        }

        this.votesMax = votesMax;
        this.date = date;
    }

    public Scrutin(ArrayList<Postulant> postulants, int votesMax, int date, boolean initialisation) {
        this.votes = new ArrayList<>();
        this.postulants = new ArrayList<>();
        if(postulants != null){
            for(int i = 0; i < postulants.size(); ++i){
                this.postulants.add(new Postulant(postulants.get(i)));
                if(initialisation){
                    this.postulants.get(i).init();
                }
            }
        }

        this.votesMax = votesMax;
        this.date = date;
    }

    public int getVotesMax() {
        return votesMax;
    }

    public int getDate() {
        return date;
    }

    public int calculerVotants(){
        int nbTotalVotes = 0;
        for(Postulant postulant : postulants){
            nbTotalVotes += postulant.getVotes();
        }

        return nbTotalVotes;
    }

    public String gagnant(){
        int nbVotes = postulants.get(0).getVotes();
        int index = 0;

        for(int i = 1; i < postulants.size(); ++i){
            if(postulants.get(i).getVotes() >= nbVotes){
                nbVotes = postulants.get(i).getVotes();
                index = i;
            }
        }

        return postulants.get(index).getNom();
    }

    public void resultats(){
        if(calculerVotants() == 0){
            System.out.println("Scrutin annulé, pas de votants");
        }else{
            System.out.println("Taux de participation -> "+String.format("%.1f", (calculerVotants() / (votesMax * 1.0) * 100))+" pour cent");
            System.out.println("Nombre effectif de votants -> "+calculerVotants());
            System.out.println("Le chef choisi est -> "+gagnant()+"\n");
            System.out.println("Répartition des electeurs");

            for(Postulant postulant : postulants){
                System.out.println(postulant.getNom()+" -> "+String.format("%.1f", (postulant.getVotes() / (calculerVotants() * 1.0) * 100))+" pour cent des électeurs");
            }
        }
        System.out.println();
    }

    public void compterVotes(){
        for(Vote vote : votes){
            if(! vote.estInvalide()){
                boolean nonAffecte = true;     // pour sortir de la boucle une fois affecte le vote
                for(int i = 0; i < postulants.size() && nonAffecte; ++i){
                    if(vote.getPostulant().equals(postulants.get(i).getNom())){
                        postulants.get(i).elect();
                        nonAffecte = false;
                    }
                }
            }
        }
    }

    public void simuler(double tauxParticipation, int jourDeVote){

        int nbVotants = (int) (votesMax * tauxParticipation);

        for(int i = 0; i < nbVotants; ++i){
            int candNum = Utils.randomInt(postulants.size() );
            if(i % 3 == 0){
                Vote vote = new BulletinElectronique(postulants.get(candNum).getNom(), jourDeVote, date );
                votes.add(vote);
                System.out.println(vote);
            }else if(i % 3 == 1){
                // les bulletins des votants impairs sont signes
                Vote vote = new BulletinPapier(postulants.get(candNum).getNom(), jourDeVote, date, i % 2 == 1 );
                votes.add(vote);
                System.out.println(vote);
            }else{
                Vote vote = new BulletinCourrier(postulants.get(candNum).getNom(), jourDeVote, date, i % 2 == 1);
                votes.add(vote);
                System.out.println(vote);
            }
        }
    }
}

abstract class Vote {
    private String postulant;
    private int date;
    private int dateLimite;

    public Vote(String postulant, int date, int dateLimite) {
        this.postulant = postulant;
        this.date = date;
        this.dateLimite = dateLimite;
    }

    public String getPostulant() {
        return postulant;
    }

    public int getDate() {
        return date;
    }

    public int getDateLimite() {
        return dateLimite;
    }

    abstract boolean estInvalide();

    @Override
    public String toString() {
        return estInvalide() ? " pour "+getPostulant()+" -> invalide" : " pour "+getPostulant()+" -> valide";
    }
}

class BulletinElectronique extends Vote implements CheckBulletin{
    public BulletinElectronique(String nomPostulant, int date, int dateLimite) {
        super(nomPostulant, date, dateLimite);
    }

    @Override
    boolean estInvalide() {
        return ! checkDate();
    }

    @Override
    public boolean checkDate() {
        return getDate() <= getDateLimite()-2;
    }

    @Override
    public String toString() {
        return "vote electronique"+super.toString();
    }
}

class BulletinPapier extends Vote {
    private boolean signe;

    public BulletinPapier(String nomPostulant, int date, int dateLimite, boolean signe) {
        super(nomPostulant, date, dateLimite);
        this.signe = signe;
    }

    public boolean isSigne() {
        return signe;
    }

    @Override
    boolean estInvalide() {
        return ! isSigne();
    }

    @Override
    public String toString() {
        return "vote par bulletin papier"+super.toString();
    }
}

class BulletinCourrier extends BulletinPapier implements CheckBulletin{

    public BulletinCourrier(String nomPostulant, int date, int dateLimite, boolean signe) {
        super(nomPostulant, date, dateLimite, signe);

    }

    @Override
    boolean estInvalide() {
        return super.estInvalide() || ! checkDate();
    }

    @Override
    public boolean checkDate() {
        return getDate() <= getDateLimite();
    }

    @Override
    public String toString() {
        return "envoi par courrier d'un "+super.toString();
    }
}

interface CheckBulletin {
    boolean checkDate();
}

/*******************************************
 * Ne pas modifier les parties fournies
 * pour pr'eserver les fonctionnalités et
 * le jeu de test fourni.
 * Votre programme sera testé avec d'autres
 * données.
 *******************************************/

class Utils {

    private static final Random RANDOM = new Random();

    // NE PAS UTILISER CETTE METHODE DANS LES PARTIES A COMPLETER
    public static void setSeed(long seed) {
        RANDOM.setSeed(seed);
    }

    // génère un entier entre 0 et max (max non compris)
    public static int randomInt(int max) {
        return RANDOM.nextInt(max);
    }
}



/**
 * Classe pour tester la simulation
 */

class Votation {

    public static void main(String args[]) {
        Utils.setSeed(20000);
        // TEST 1
        System.out.println("Test partie I:");
        System.out.println("--------------");

        ArrayList<Postulant> postulants = new ArrayList<Postulant>();
        postulants.add(new Postulant("Tarek Oxlama", 2));
        postulants.add(new Postulant("Nicolai Tarcozi", 3));
        postulants.add(new Postulant("Vlad Imirboutine", 2));
        postulants.add(new Postulant("Angel Anerckjel", 4));

        // 30 -> nombre maximal de votants
        // 15 jour du scrutin
        Scrutin scrutin = new Scrutin(postulants, 30, 15, false);

        scrutin.resultats();

        // FIN TEST 1

        // TEST 2
        System.out.println("Test partie II:");
        System.out.println("---------------");

        scrutin = new Scrutin(postulants, 20, 15);
        // tous les bulletins passent le check de la date
        // les parametres de simuler sont dans l'ordre:
        // le pourcentage de votants et le jour du vote
        scrutin.simuler(0.75, 12);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 20, 15);
        // seuls les bulletins papier non courrier passent
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 20, 15);
        // les bulletins electroniques ne passent pas
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();
        //FIN TEST 2

    }
}