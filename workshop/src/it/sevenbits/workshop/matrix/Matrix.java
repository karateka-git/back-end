package it.sevenbits.workshop.matrix;

import java.util.Random;

public class Matrix {
    private final int CELL_MAX_VALUE = 100;
    private Cell[][] matrix;

    private Matrix() {};

    public Matrix(int rowCount, int columnCount) {
        matrix = new Cell[rowCount][columnCount];
        FillMatrixByRandomValues();
    }

    private void FillMatrixByRandomValues() {
        Random rand = new Random();

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int cellValue = rand.nextInt(CELL_MAX_VALUE);
                matrix[i][j] = new Cell(i, j, cellValue);
            }
        }
    }

    public void inverseMatrix() {
        for(int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                matrix[x][y].inverse();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                sb.append(matrix[x][y].getValue()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
