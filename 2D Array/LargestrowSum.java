import java.util.Scanner;

public class LargestrowSum {
    public static void LargestRowSum(int[][] arr, int row, int column) {
        int max = Integer.MIN_VALUE;
        int rowIndex = -1;

        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < column; j++) {
                sum += arr[i][j];
            }
            if (sum > max) {
                max = sum;
                rowIndex = i;
            }
        }

        System.out.println(max);
        System.out.println(rowIndex);
    }

    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        Scanner scanner = new Scanner(System.in);

        // Taking input for elements of the matrix
        System.out.println("Enter the elements of the matrix of row 4 and col 4:");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // Printing the elements of the matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        LargestRowSum(arr, 4, 4);
    }
}
