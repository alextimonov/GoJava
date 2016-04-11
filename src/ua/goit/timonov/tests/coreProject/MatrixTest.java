package ua.goit.timonov.tests.coreProject;

import org.junit.Test;
import ua.goit.timonov.coreProject.Matrix;

import static org.junit.Assert.*;

/**
 * Created by Alex on 11.04.2016.
 */
public class MatrixTest {
    @Test
    public void testMultiplyNormal_1() throws Exception {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{2, 3}, {4, 2}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{1, 0}, {0, 1}};
        matrix2.setArray(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrix1.multiply(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_2() throws Exception {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{4, 2}, {1, 2}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(2, 2);
        double[][] arr = {{6, 6}, {16, 14}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_3() throws Exception {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 4);
        double[][] arr2 = {{4, 3, 2, 1}, {1, 2, 3, 4}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(3, 4);
        double[][] arr = {{6, 7, 8, 9}, {16, 17, 18, 19}, {26, 27, 28, 29}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_4() throws Exception {
        Matrix matrix1 = new Matrix(3, 1);
        double[][] arr1 = {{1}, {1}, {1}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 3);
        double[][] arr2 = {{1, 1, 1}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(3, 3);
        double[][] arr = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_1() throws Exception {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{0, 0}, {0, 0}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(3, 2);
        double[][] arr = {{0, 0}, {0, 0}, {0, 0}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_2() throws Exception {
        Matrix matrix1 = new Matrix(1, 1);
        double[][] arr1 = {{7}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 1);
        double[][] arr2 = {{5}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(1, 1);
        double[][] arr = {{35}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyAbnormal_1() throws Exception {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 3);
        double[][] arr2 = {{5, 6, 7}};
        matrix2.setArray(arr2);

        Matrix actual = matrix1.multiply(matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyAbnormal_2() throws Exception {
        Matrix matrix1 = new Matrix(-2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        Matrix actual = matrix1.multiply(matrix2);
    }
}