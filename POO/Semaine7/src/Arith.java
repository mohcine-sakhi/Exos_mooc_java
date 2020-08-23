/** Structure de donnee pour les expressions*/
abstract class Expression {
   abstract public int evaluate();
   abstract public String toString();
}

class Number extends Expression {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

abstract class BinOp extends Expression {
    private Expression leftOp;
    private Expression rightOp;

    public BinOp(Expression leftOp, Expression rightOp) {
        this.leftOp = leftOp;
        this.rightOp = rightOp;
    }

    public Expression getLeftOp() {
        return leftOp;
    }

    public Expression getRightOp() {
        return rightOp;
    }
}

class Sum extends BinOp {

    public Sum(Expression leftOp, Expression rightOp) {
        super(leftOp, rightOp);
    }

    @Override
    public int evaluate() {
        return getLeftOp().evaluate() + getRightOp().evaluate();
    }

    @Override
    public String toString() {
        return getLeftOp().toString()+" + "+getRightOp().toString();
    }
}

class Product extends BinOp {

    public Product(Expression leftOp, Expression rightOp) {
        super(leftOp, rightOp);
    }

    @Override
    public int evaluate() {
        return getLeftOp().evaluate() * getRightOp().evaluate();
    }

    @Override
    public String toString() {
        return getLeftOp().toString()+" * "+getRightOp().toString();
    }
}

class Modulo extends BinOp {

    public Modulo(Expression leftOp, Expression rightOp) {
        super(leftOp, rightOp);
    }

    @Override
    public int evaluate() {
        return getLeftOp().evaluate() % getRightOp().evaluate();
    }

    @Override
    public String toString() {
        return getLeftOp().toString()+" % "+getRightOp().toString();
    }
}

/** Classe principale */
class Arith {


    public static void main(String [] args) {
        // construit l'expression 3 + 2 * 5
        Expression term1 = new Product(new Number(2), new Number(5));
        Expression term = new Sum(new Number(3), term1);

        System.out.println(term+" s'évalue "+term.evaluate());



    }
}
