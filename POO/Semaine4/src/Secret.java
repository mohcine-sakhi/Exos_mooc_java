import java.util.Random;

class Utils {
    // genere un entier entre 1 et max (compris)
    public static int randomInt(int max) {
        Random r = new Random();
        int val = r.nextInt();
        val = Math.abs(val);
        val = val % max;
        val += 1;
        return val;
    }
}
public class Secret {
    public static void main(String[] args){
        String message = "COURAGEFUYONS";
        String cryptage;
// PARTIES A DECOMMENTER AU FUR ET A MESURE SELON l'ENONCE

// TEST A CLE
Code acle1 = new ACle("a cle", "EQUINOXE");
System.out.print("Avec le code : " );
acle1.affiche();
cryptage = acle1.code(message);
System.out.print("Codage de " + message + " : ");
System.out.println(cryptage);
System.out.print("Decodage de " + cryptage + " : ");
System.out.println(acle1.decode(cryptage));
System.out.println("-----------------------------------");
System.out.println();
// FIN TEST A CLE


// TEST A CLE ALEATOIRE
Code acle2 = new ACleAleatoire(5);
System.out.print("Avec le code : " );
acle2.affiche();
cryptage = acle2.code(message);
System.out.print("Codage de " + message + " : ");
System.out.println(cryptage);
System.out.print("Decodage de " + cryptage + " : ");
System.out.println(acle2.decode(cryptage));
System.out.println("-----------------------------------");
System.out.println();
// FIN TEST A CLE ALEATOIRE


// TEST CESAR
Code cesar1 = new Cesar("Cesar", 5);
System.out.print("Avec le code : " );
cesar1.affiche();
cryptage = cesar1.code(message);
System.out.print("Codage de " + message + " : ");
System.out.println(cryptage);
System.out.print("Decodage de " + cryptage + " : ");
System.out.println(cesar1.decode(cryptage));
System.out.println("-----------------------------------");
System.out.println();
// FIN TEST CESAR


// TEST CODAGES
System.out.println("Test CODAGES: ");
System.out.println("------------- ");
System.out.println();
Code[] tab = { // Decommentez la ligne suivante
// si vous avez fait la classe Cesar
new Cesar("cesar", 5),
new ACle("a cle", "EQUINOXE") ,
new ACleAleatoire(5),
new ACleAleatoire(10)};
Codages codes = new Codages(tab);
codes.test(message);
// FIN TEST CODAGE

    }
}

abstract class Code {
    private String nom;

    public Code(String nom) {
        this.nom = nom;
    }

    public void affiche(){
        System.out.print(nom);
    }

    public String getNom() {
        return nom;
    }

    public abstract String code(String s);
    public abstract  String decode(String s);
}

class ACle extends Code{
    private String cle;

    public ACle(String nom, String cle) {
        super(nom);
        this.cle = cle;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public int longueur(){
        return cle.length();
    }

    @Override
    public String code(String s) {
        String cryptage = "";
        int[] tab1 = new int[s.length()];
        int[] tab2 = new int[longueur()];

        for(int i = 0; i < tab1.length; ++i){
            tab1[i] = s.charAt(i) - 'A' + 1;  // A correspond a 65 dans le code ascii
        }

        for(int i = 0; i < tab2.length; ++i){
            tab2[i] = cle.charAt(i) - 'A' + 1;  // A correspond a 65 dans le code ascii
        }

        for(int i = 0; i < tab1.length; ++i){
            tab1[i] = (tab1[i] + tab2[i % tab2.length]) ;
            if(tab1[i] > 26){   //  pour le cyclage des lettres
                tab1[i] -= 26 ;
            }
        }

        for(int i = 0; i < tab1.length; ++i){

            cryptage += (char)(tab1[i] + 'A' -1 );
        }

        return cryptage;
    }

    @Override
    public String decode(String s) {
        String decryptage = "";
        int[] tab1 = new int[s.length()];
        int[] tab2 = new int[longueur()];

        for(int i = 0; i < tab1.length; ++i){
            tab1[i] = s.charAt(i) - 'A' + 1;  // A correspond a 65 dans le code ascii
        }

        for(int i = 0; i < tab2.length; ++i){
            tab2[i] = cle.charAt(i) - 'A' + 1;  // A correspond a 65 dans le code ascii
        }

        for(int i = 0; i < tab1.length; ++i){
            tab1[i] = (tab1[i] - tab2[i % tab2.length]) ;
            if(tab1[i] <= 0){   //  pour le cyclage des lettres
                tab1[i] += 26 ;
            }
        }

        for(int i = 0; i < tab1.length; ++i){

            decryptage += (char)(tab1[i] + 'A' -1 );
        }

        return decryptage;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println(" avec "+getCle()+" comme cle");

    }
}

class ACleAleatoire extends ACle {
    private int longueurCle;

    public ACleAleatoire(int longueurCle) {
        super("a cle aleatoire", "");
        this.longueurCle = longueurCle;
        genereCle();
    }

    public void genereCle(){
        String cle = "";
        for(int i = 0; i < longueurCle; ++i){
            cle += (char)(Utils.randomInt(26) + 'A' -1);
        }
        setCle(cle);
    }

}

class Cesar extends ACle{
    private int decalage;

    public Cesar(String nom, int decalage) {
        super(nom, String.valueOf((char) (decalage%26 + 'A' -1)));
        this.decalage = decalage;
    }

    public int getDecalage() {
        return decalage;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println(" à "+getDecalage()+" crans");

    }
}

class Codages {
    private Code[] codes;

    public Codages(Code[] codes) {
        this.codes = codes;
    }

    public void test(String message){
        int longueur = 0;
        String cleAleatoire = "";
        for(int i = 0; i < codes.length; ++i){
            String cryptage;
            System.out.print("Avec le code : " );
            codes[i].affiche();
            cryptage =  codes[i].code(message);
            System.out.print("Codage de " + message + " : ");
            System.out.println(cryptage);
            System.out.print("Decodage de " + cryptage + " : ");
            System.out.println( codes[i].decode(cryptage));
            System.out.println("-----------------------------------");
            System.out.println();

            if(codes[i].getClass() == ACleAleatoire.class) {
                if (((ACleAleatoire) codes[i]).longueur() > longueur) {
                    longueur = ((ACleAleatoire) codes[i]).longueur();
                    cleAleatoire = ((ACleAleatoire) codes[i]).getCle();
                }

            }
        }
        System.out.println("Code aleatoire a cle maximale :");
        System.out.println("a cle aleatoire avec "+cleAleatoire+" comme cle");
    }
}

