public class FonctionLogique {
    public static void main(String[] args) {

    }

    boolean nonEt(boolean a, boolean b) {
        return !(a && b);
    }

    boolean non(boolean a){
        return nonEt(a, true);
    }

    boolean et(boolean a, boolean b){
        return non(nonEt(a, b));
    }

    boolean ou(boolean a, boolean b){
        return nonEt(non(a), non(b));
    }

}
