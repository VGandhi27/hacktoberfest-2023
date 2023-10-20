import java.util.*;

public class PascalTriangle {
    // Time Complexity: O(N2)
    // Space Complexity: O(1)

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

    public static List<Integer> generateRow(int row) {
        double ans = 1.0;

        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col) / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the row number: ");
        int row = scanner.nextInt();

        List<List<Integer>> triangle = pascalTriangle(row);

        for (List<Integer> ans : triangle) {
            for (Integer element : ans) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
