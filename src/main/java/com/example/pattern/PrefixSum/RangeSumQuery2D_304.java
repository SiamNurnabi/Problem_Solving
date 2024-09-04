package com.example.pattern.PrefixSum;

import com.example.pattern.SlidingWindow.LongestSubstringWithoutRepeatingCharacters_3;

public class RangeSumQuery2D_304 {
    int[][] matrix;
    int rows;
    int cols;

    public RangeSumQuery2D_304(int[][] matrix) {
        this.matrix = matrix;
        rows = this.matrix.length;
        cols = this.matrix[0].length;
        reCalculateMatrix();

    }

    public void reCalculateMatrix() {

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 > 0) {
                sum += matrix[i][col2] - matrix[i][col1 - 1];
            } else {
                sum += matrix[i][col2];
            }
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        RangeSumQuery2D_304 rangeSumQuery2D_304 = new RangeSumQuery2D_304(
                new int[][]{
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}});
        int param = rangeSumQuery2D_304.sumRegion(0, 0, 4, 4);
        int param2 = rangeSumQuery2D_304.sumRegion(1, 1, 2, 2);
        System.out.println(param);
        System.out.println(param2);
    }
}

/*
// Declare a 2D array
int[][] matrix;

// Initialize the 2D array with specific values
matrix = new int[][] {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
        };

// Access and print elements of the 2D array
        for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
            System.out.println();
}

To get the length of a 2D array in Java, you can use the length property. Here is how you can do it:
Number of rows: Use array.length.
Number of columns in a specific row: Use array[rowIndex].length.

// Declare a jagged 2D array
int[][] jaggedArray = new int[3][];

// Initialize each row with a different number of columns
jaggedArray[0] = new int[]{1, 2, 3};
jaggedArray[1] = new int[]{4, 5};
jaggedArray[2] = new int[]{6, 7, 8, 9};

// Access and print elements of the jagged 2D array
for (int i = 0; i < jaggedArray.length; i++) {
    for (int j = 0; j < jaggedArray[i].length; j++) {
        System.out.print(jaggedArray[i][j] + " ");
    }
    System.out.println();
}
 */