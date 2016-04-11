package ua.goit.timonov.coreProject;

import java.util.Arrays;

/**
 * Provides 2-dimension matrix and operations with another matrix
 */
public class Matrix {
    /* number of lines in matrix */
    private int lines;
    /* number of columns in matrix */
    private int columns;
    /* 2-dimension array with matrix elements */
    private double[][] array;

    /* Default constructor */
    public Matrix() {
    }

    /* Constructor by numbers of lines & columns */
    public Matrix(int lines, int columns) {
        this();
        this.lines = lines;
        this.columns = columns;
        checkIfMatrixValid(this);
        array = new double[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = 0;
            }
        }
    }

    /* Full constructor */
    public Matrix(int lines, int columns, double[][] array) {
        this.lines = lines;
        this.columns = columns;
        this.array = array;
    }

    /* ================ Getters & Setters =================== */

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public double[][] getArray() {
        return array;
    }

    public void setArray(double[][] array) {
        this.array = array;
    }

    /**
     * multiplies two matrix: this and given
     * @param multiplier        given multiplier matrix
     * @return                  result of multiply
     */
    public Matrix multiply(Matrix multiplier) {
        checkIfMatrixValid(multiplier);
        checkIfMatrixValidToMultiply(multiplier);
        Matrix result = new Matrix(lines, multiplier.getColumns());
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < multiplier.getColumns(); j++) {
                result.array[i][j] = 0;
                for (int k = 0; k < columns; k++) {
                    result.array[i][j] += array[i][k] * multiplier.array[k][j];
                }
            }
        }
        return result;
    }

    // checks if matrix has number of lines or columns less than one
    private void checkIfMatrixValid(Matrix multiplier) {
        if (multiplier.getLines() <= 0 || multiplier.getColumns() <= 0) {
            throw new IllegalArgumentException("Matrix has less than 1 line or column!");
        }
    }

    // checks if it's possible to multiply two matrix: this and given
    private void checkIfMatrixValidToMultiply(Matrix multiplier) {
        if (columns != multiplier.getLines()) {
            throw new IllegalArgumentException("Multiplier matrix has improper number of lines to multiply!");
        }
    }

    /**
     * Overrode method to compare two objects in tests (using assertEquals methods)
     * @param obj       given object to compare
     * @return          true if matrix are equal or false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Matrix matrix = (Matrix) obj;

        if (lines != matrix.lines) return false;
        if (columns != matrix.columns) return false;
        return Arrays.deepEquals(array, matrix.array);

    }

    @Override
    public int hashCode() {
        int result = lines;
        result = 31 * result + columns;
        result = 31 * result + Arrays.deepHashCode(array);
        return result;
    }
}

