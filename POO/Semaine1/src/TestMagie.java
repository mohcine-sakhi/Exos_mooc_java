import java.util.Scanner;

public class TestMagie {
    public static void main(String[] args) {
        Papier papier = new Papier();
        Spectateur spectateur = new Spectateur();
        Assistant assistant = new Assistant();
        Magicien magicien = new Magicien();

        spectateur.demanderInformatons();
        spectateur.ecrireSurPapier(papier);
        assistant.calculer(papier);
        magicien.tourDeMagie(assistant);
    }
}

class Papier {
    private int age;
    private int sommeArgent;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSommeArgent() {
        return sommeArgent;
    }

    public void setSommeArgent(int sommeArgent) {
        this.sommeArgent = sommeArgent;
    }
}

class Spectateur {
    private final static Scanner clavier = new Scanner(System.in);
    private int age;
    private int sommeArgent;

    public void demanderInformatons () {
        System.out.println("Spectateur] (j'entre en scène)");
        System.out.print("âge ai-je ? ");
        age = clavier.nextInt();
        clavier.nextLine();
        do{
            System.out.print("Combien d'argent ai-je en poche (<100) ? ");
            sommeArgent = clavier.nextInt();
        }while(sommeArgent <= 0 || sommeArgent > 100);

        System.out.println(" [Spectateur] (j'ai un montant qui convient)");
    }

    public void ecrireSurPapier(Papier papier){
        System.out.println("[Spectateur] (j'écris le papier)");
        papier.setAge(this.age);
        papier.setSommeArgent(this.sommeArgent);
    }
}

class Assistant {
    private int nbCalcule;

    public int getNbCalcule() {
        return nbCalcule;
    }

    public int calculer(Papier papier){
        System.out.println("[Assistant] (je lis le papier)");
        System.out.println("[Assistant] (je calcule mentalement)");

        nbCalcule = ((papier.getAge() * 2 + 5) * 50 + papier.getSommeArgent()) - 365;
        System.out.println("[Assistant] J'annonce : "+nbCalcule+" !");

        return nbCalcule;
    }
}

class Magicien {

    public void tourDeMagie(Assistant assistant){
        int nbCalcule = assistant.getNbCalcule();
        nbCalcule += 115;

        int age = nbCalcule / 100;
        int sommeArgent = nbCalcule % 100;

        System.out.println("[Magicien] - hum... je vois que vous êtes agé de "+age+" ans\n" +
                "et que vous avez "+sommeArgent+" francs suisses en poche !");
    }
}