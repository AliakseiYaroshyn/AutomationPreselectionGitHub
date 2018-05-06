package by.epam.automationpreselection.task1.rotatematrix;

import java.util.Random;

import static java.lang.System.*;

public class RotateMatrix {
    public static void main(String[] args) {
        Random randomize = new Random();
        int m = 1 + randomize.nextInt(9);
        int n = 1 + randomize.nextInt(9);
        int [][] initialArray = generateArray (m,n); //new m x n matrix is generated

        int [][] rotatedArray = updateRotateMatrix(initialArray); // initial m x n matrix is transferred to to rotated n x m matrix
        out.println("New matrix dimension: " + rotatedArray.length + "x" + rotatedArray[0].length);
        for (int i = 0; i < rotatedArray.length; i++) {
            for (int j = 0; j < rotatedArray[0].length; j++) {
                out.print(rotatedArray[i][j]+ " ");
            }
            out.println();
        }
    }

    private static int[][] generateArray(int m, int n) {
        int [][] generatedArray = new int[m][n];
        out.println("Generated matrix dimension: "+ m + "x" + n);
        Random randomize = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                generatedArray [i][j] = 10 + randomize.nextInt(89); //10-99 range is used just for pretty view
                out.print(generatedArray[i][j] + " ");
            }
            out.println();
        }
        return generatedArray;
    }
    private static int [][] updateRotateMatrix(int [][] initialArray) {
        int rotatedMatrixM = initialArray[0].length;
        int rotatedMatrixN = initialArray.length;
        int[][] rotatedArray = new int[rotatedMatrixM][rotatedMatrixN];
        for (int i = 0; i <rotatedMatrixN ; i++) {
            for (int j = 0; j < rotatedMatrixM; j++) {
                rotatedArray[j][rotatedMatrixN - 1 - i] = initialArray[i][j];
            }
        }
        return rotatedArray;
    }
}
