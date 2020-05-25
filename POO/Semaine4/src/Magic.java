public class Magic {
    public static void main(String[] args) {
        Jeu maMain = new Jeu(10);
        maMain.piocher(new Terrain('b'));
        maMain.piocher(new Creature(6, "Golem", 4, 6));
        maMain.piocher(new Sortilege(1, "Croissance Gigantesque",
                "La créature ciblée gagne +3/+3 jusqu'à la fin du tour"));
        System.out.println("Là, j'ai en stock :");
        maMain.afficher();
        maMain.joue();
        maMain.joue();
        maMain.joue();
        maMain.joue();
        maMain.joue();
    }
}

abstract class Carte {
    private int cout;

    public Carte(int cout) {
        this.cout = cout;
    }

    public int getCout() {
        return cout;
    }

    abstract public String afficher();
}

class Terrain extends Carte {
    private char couleur;

    public Terrain(char couleur) {
        super(0);
        System.out.println("Un nouveau terrain.");
        this.couleur = couleur;
    }

    @Override
    public String afficher() {
        String chaine = "";
        switch(couleur){
            case 'B' : chaine = "blanc"; break;
            case 'b' : chaine = "bleu"; break;
            case 'n' : chaine = "noir"; break;
            case 'r' : chaine = "rouge"; break;
            case 'v' : chaine = "vert"; break;
        }
        return "Un terrain "+chaine;
    }
}

class Creature extends Carte {
    private String nom;
    private int degat;
    private int pointsDeVie;

    public Creature(int cout, String nom, int degat, int pointsDeVie) {
        super(cout);
        System.out.println("Une nouvelle créature.");
        this.nom = nom;
        this.degat = degat;
        this.pointsDeVie = pointsDeVie;
    }

    @Override
    public String afficher() {
        return "Une créature "+nom+" "+degat+"/"+pointsDeVie;
    }
}

class Sortilege extends Carte {
    private String nom;
    private String explication;

    public Sortilege(int cout, String nom, String explication) {
        super(cout);
        System.out.println("Un sortilège de plus.");
        this.nom = nom;
        this.explication = explication;
    }

    @Override
    public String afficher() {
        return "Un sortilège "+nom;
    }
}

class Jeu {
    private Carte[] cartes;
    int index;
    int carteJouee;

    public Jeu(int nbMax) {
        System.out.println("On change de main");
        cartes = new Carte[nbMax];
        index = 0;
        carteJouee = 0;
    }

    public void piocher(Carte carte){
        if(index < cartes.length && carte != null){
            cartes[index] = carte;
            ++index;
        }
    }

    public void afficher(){
        for(int i = 0; i < index; ++i){
            if(cartes[i] != null){
                System.out.println(cartes[i].afficher());
            }

        }
    }

    public void joue(){
        System.out.println("Je joue une carte...");
        if(carteJouee < index){
            System.out.println("La carte jouée est :");
            System.out.println(cartes[carteJouee].afficher());
            cartes[carteJouee] = null;
            ++carteJouee;
        }else{
            System.out.println("Pas de carte à jouer !!");
        }


    }
}