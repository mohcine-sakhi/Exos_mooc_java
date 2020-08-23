import java.util.ArrayList;

class Demenagement {
    private Box[] boxes ;
    private int index;

    public Demenagement(int taille){
        index = 0;
        boxes = new Box[taille];
    }
    public void addBox(Box box){
        if(index < boxes.length){
            if(box != null){
                boxes[index] = box;
                ++index;
            }
        }else{
            System.out.println("Le déménagement est déjà prêt !");
        }
    }

    public void print(){
        System.out.println("Les objets de mon demenagement sont : ");
        for(Box box : boxes){
            box.afficher();
        }
    }

    public int find(String nom){
        for(Box box : boxes){
            if(box.find(nom)){
                return box.getNumero();
            }
        }

        return -1;  // dans le cas ou l ibjet n existe pas
    }

    public static void main(String[] args) {
        //On cree un demenagement qui pourra contenir 2 cartons principaux
        Demenagement demenagement = new Demenagement(2);

        // On cree et remplis ensuite 3 cartons
        // Arguments du constructeur de Box (Carton) :
        // argument 1 : nombre d'items (objets simple ou carton) que le carton peut contenir
        // argument 2 : numero du carton

        // le carton 1 contient des ciseaux
        Box box1 = new Box(1, 1);
        box1.addItem(new SimpleItem("ciseaux"));

        // le carton 2 contient un livre
        Box box2 = new Box(1, 2);
        box2.addItem(new SimpleItem("livre"));

        // le carton 3 contient une boussole
        // et un carton contenant une echarpe
        Box box3 = new Box(2, 3);
        box3.addItem(new SimpleItem("boussole"));
        Box box4 = new Box(1, 4);
        box4.addItem(new SimpleItem("echarpe"));
        box3.addItem(box4);

        //On ajoute les trois cartons au premier carton du demenagement
        Box box5 = new Box(3, 5);
        box5.addItem(box1);
        box5.addItem(box2);
        box5.addItem(box3);

        //On ajoute un carton contenant 3 objets au demenagement
        Box box6 = new Box(3, 6);
        box6.addItem(new SimpleItem("crayons"));
        box6.addItem(new SimpleItem("stylos"));
        box6.addItem(new SimpleItem("gomme"));


        //On ajoute les deux cartons les plus externes au demenagement
        demenagement.addBox(box5);
        demenagement.addBox(box6);

        //On imprime tout le contenu du demenagement
        demenagement.print();

        //On imprime le numero du carton le plus externe contenant l'objet "echarpe"
        System.out.println("L'echarpe est dans le carton numero " + demenagement.find("echarpe"));
    }


}

//***************************************************************************************************************************************************
abstract class Component {
    abstract void afficher() ;
    abstract boolean find(String nom);
}

//***************************************************************************************************************************************************
class SimpleItem extends Component {
    private String nom;

    public SimpleItem(String nom){
        this.nom = nom;
    }
    @Override
    void afficher() {
        System.out.println(nom);
    }

    @Override
    boolean find(String nom) {
        return this.nom.equals(nom);
    }
}

//***************************************************************************************************************************************************
class Box extends Component {
    private int numero;
    private int index;
    private Component[] components;

    public Box(int taille, int numero){
        this.numero = numero;
        index = 0;
        components = new Component[taille];
    }

    public int getNumero() {
        return numero;
    }

    public void addItem(Component component){
        if(index < components.length){
            if(component != null){
                components[index] = component;
                ++index;
            }
        }else{
            System.out.println("Le carton est déjà plein ! ");
        }
    }

    @Override
    void afficher() {
        for(Component component : components){
            component.afficher();
        }
    }

    @Override
    boolean find(String nom) {
        for(Component component : components){
            if(component.find(nom)){
                return true;
            }
        }
        return false;
    }
}

