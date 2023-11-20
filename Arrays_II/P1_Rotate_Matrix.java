package Arrays_II;
import java.util.Arrays;

class Solution {
    // brute force appraoch
    public void rotate_brute(int[][] matrix) {
        int n= matrix.length;
        int[][] copyMatrix = new int[n][n];

        // rotate the image and store it into copyMatrix
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                copyMatrix[j][n-1-i] = matrix[i][j];
            }
        }

        // Reassigning the values from copy to original one
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = copyMatrix[i][j];
            }
        }
    }

    // Reverse and transpose
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Reverse each row
        for (int i = 0; i < n; i++) {
            reverseArray(matrix[i]);
        }

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            // Move indices towards the center
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };       

        rotate(matrix);

        System.out.println("\nRotated Matrix:" +Arrays.toString(matrix));
    }
}
