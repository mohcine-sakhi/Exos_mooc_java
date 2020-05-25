import java.util.InputMismatchException;
import java.util.Scanner;

// Note : le  message de mise en garde de Eclipse:
// the serializable class CustomException does not declare a static
// final serialVersionUID field of type long
// peut etre negligé.

class CustomException extends Exception {

    public CustomException(String string) {
        super(string);
    }

}

class UtilsMatrix {
    public static int[][] multiply(int[][] mat1, int[][] mat2) throws CustomException {
        if(mat1 == null || mat2 == null){
            throw new CustomException("Les matrices ne doivent etre nulles !");
        }

        if(mat1.length == 0  || mat2.length == 0 ){
            throw new CustomException("Les matrices ne doivent pas être vides !");
        }

        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int rows2 = mat2.length;
        int cols2 = mat2[0].length;



        for(int i = 1; i < rows1; ++i){
            if(mat1[i].length != cols1){
                throw new CustomException("La matrice a un format inadéquat !");
            }
        }

        for(int i = 1; i < rows2; ++i){
            if(mat2[i].length != cols2){
                throw new CustomException("La matrice a un format inadéquat !");
            }
        }

        if(cols1 != rows2){
            throw new CustomException("La multiplication est impossible !");
        }

        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < rows2; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    private static int readNextInt(Scanner scanner) throws CustomException {
        int val = -1;
        try{
            val = scanner.nextInt();
        }catch(InputMismatchException e){
            try {
                throw new CustomException("Il faut entrer un entier positif !");
            } catch (CustomException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if(val <= 0){
            throw new CustomException("Les dimensions de la matrices doivent etre positives !");
        }

        System.out.println("lu = " + val);
        return val;

    }

    public static int[][] readMatrix() throws CustomException {
        Scanner scanner = new Scanner(System.in);

        int row = -1;
        int col = -1;

        System.out.println("Nouvelle matrice");

        System.out.print("\t Entrez nombre de lignes : ");
        row = readNextInt(scanner);

        System.out.print("\t Entrez nombre de colonnes : ");
        col = readNextInt(scanner);

        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("\t Contenu cellule [" + i + "][" + j + "] : ");
                try{
                    result[i][j] = scanner.nextInt();
                }catch(InputMismatchException e){
                    throw new CustomException("Il faut entrer un entier !");
                }
            }
        }
        return result;
    }

    public static void display(int[][] mat) {
        for (int[] lines : mat) {
            for (int item : lines) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat1 = null;
        int[][] mat2 = null;

        try {
            mat1 = readMatrix();
            mat2 = readMatrix();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }


        int[][] prod = null;
        try {
            prod = multiply(mat1, mat2);
            display(prod);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }


    }
}


