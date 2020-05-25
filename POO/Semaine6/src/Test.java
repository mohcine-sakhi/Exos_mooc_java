public class Test {
    public static void main(String[] args) {
        String chaine = "aaaaaaaaaaaa";
        String chaine2 = chaine;

        System.out.println(chaine);
        System.out.println(chaine2);

        chaine2 = "bbbbbbbbbbbbb";
        System.out.println(chaine);
        System.out.println(chaine2);

    }
}
