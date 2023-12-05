public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix add(Matrix other) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix subtract(Matrix other) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] - other.matrix[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        int rowsA = matrix.length;
        int colsA = matrix[0].length;
        int colsB = other.matrix[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrix[i][k] * other.matrix[k][j];
                }
            }
        }

        return new Matrix(result);
    }

    public void print() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printColumn(int column) {
        int rows = matrix.length;

        for (int i = 0; i < rows; i++) {
            System.out.println(matrix[i][column]);
        }
    }

    public void printRow(int row) {
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            System.out.print(matrix[row][j] + " ");
        }
        System.out.println();
    }

    public void printMainDiagonal() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    public void printSecondaryDiagonal() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            System.out.print(matrix[i][cols - i - 1] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrixData = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix matrix = new Matrix(matrixData);

        System.out.println("Matrix addition:");
        Matrix sum = matrix.add(matrix);
        sum.print();

        System.out.println("Matrix subtraction:");
        Matrix difference = matrix.subtract(matrix);
        difference.print();

        int[][] anotherMatrixData = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}};
        Matrix anotherMatrix = new Matrix(anotherMatrixData);

        System.out.println("Matrix multiplication:");
        Matrix product = matrix.multiply(anotherMatrix);
        product.print();

        System.out.println("Print a column:");
        matrix.printColumn(1);

        System.out.println("Print a row:");
        matrix.printRow(0);

        System.out.println("Print main diagonal:");
        matrix.printMainDiagonal();

        System.out.println("Print secondary diagonal:");
        matrix.printSecondaryDiagonal();
    }
}