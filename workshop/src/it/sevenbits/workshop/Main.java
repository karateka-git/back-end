package it.sevenbits.workshop;

import it.sevenbits.workshop.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println(matrix.toString());
        matrix.inverseMatrix();
        System.out.println(matrix.toString());
    }
}
