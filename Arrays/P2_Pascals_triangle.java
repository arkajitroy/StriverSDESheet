package Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            int num = 1;
            for (int j = 0; j <= i; j++) {
                row.add(num);
                // Calculate the next value using the previous value and avoid division.
                num = num * (i - j) / (j + 1);
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        int numRows = 5; // You can change this value to the number of rows you want to generate.
        List<List<Integer>> pascalTriangle = generatePascalTriangle(numRows);

        for (List<Integer> row : pascalTriangle) {
            System.out.println(row);
        }
    }
}
