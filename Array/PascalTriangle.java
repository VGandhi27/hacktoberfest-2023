import java.util.*;

public class PascalTriangle {

    // Variation 1: Given row number r and column number c. Print the element at
    // position (r, c) in Pascal’s triangle.

    // Time Complexity: Time Complexity: O(c), where c = given column number.
    // Space Complexity: O(1)
    
    // public static int pascalTriangle(int r, int c) {
    //     int element = (int) nCr(r - 1, c - 1);
    //     return element;
    // }

    // public static int nCr(int n, int r) {
    //     int res = 1;
    //     for (int i = 0; i < r; i++) {
    //         res = res * (n - i);
    //         res = res / (i + 1);
    //     }
    //     return res;
    // }



    // Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

    // public static void pascalTriangle(int n) {
    //     for(int c=1; c <= n; c++){
    //         System.out.print(nCr(n-1, c-1) + " ");
    //     }
    //     System.out.println();
    // }

    // public static int nCr(int n, int r) {
    //     int res = 1;
    //     for (int i = 0; i < r; i++) {
    //         res = res * (n - i);
    //         res = res / (i + 1);
    //     }
    //     return res;
    // }



    // Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.

    // Time Complexity: O(N2)
    // Space Complexity: O(1)

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int row=1; row <= n; row++){
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

        // Variation 1, uncomment
        

        // System.out.print("Enter the column number: ");
        // int column = scanner.nextInt();

        // int element = pascalTriangle(row, column);
        // System.out.println("Element at row " + row + " and column " + column + " is: " + element);



        // Variation 2 
        // pascalTriangle(row);
        
        

        // Variation 3

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
