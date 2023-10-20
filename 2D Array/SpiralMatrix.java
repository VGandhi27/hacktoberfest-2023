import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int down = row - 1;
        int left = 0;
        int right = col - 1;
        int dir = 0;

        // Traverse the matrix in a spiral order
        while (down >= top && left <= right) {
            if (dir == 0) {
                // Traverse from left to right in the top row
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) {
                // Traverse from top to bottom in the rightmost column
                for (int i = top; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                // Traverse from right to left in the bottom row
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                down--;
            } else if (dir == 3) {
                // Traverse from bottom to top in the leftmost column
                for (int i = down; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4; // Change direction (0, 1, 2, 3, 0, 1, 2, 3, ...)
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");

        // Input matrix elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        List<Integer> result = spiralOrder(matrix);

        System.out.println("Spiral Order of the Matrix:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
