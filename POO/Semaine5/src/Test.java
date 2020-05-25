public class Test {
    public static void main(String[] args) {
        System.out.println(g(30));
        System.out.println(g(-10));
        System.out.println(g(0));
    }

    static void f(int a) throws Exception {
        if (a < 0) {
            throw new BadNumberException("Number is negative !");
        } else if (a == 0) {
            throw new BadNumberException("Number is zero !");
        } else {
            System.out.println("The provided number is OK!");
        }
    }

    static boolean g(int a) {
        try {
            f(a);
        } catch(Exception e) {
            System.out.println("Error occured: " + e.getMessage());
            return false;
        } finally {
            System.out.println("Finally here !");
        }
        return true;
    }
}

class BadNumberException extends Exception {
    public BadNumberException(String msg) {
        super(msg);
    }
}

