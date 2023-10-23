/*

Enter any number :5
        1 
      2 1 2 
    3 2 1 2 3 
  4 3 2 1 2 3 4 
5 4 3 2 1 2 3 4 5 

*/

import java.util.Scanner;

public class pyramidPattern {
    public static void main(String[] args) {
        System.out.print("Enter any number :");
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.close();

        for (int i = 1; i <= a; i++) {
            for (int j = a; j > i; j--) {
                System.out.print("  ");
            }
            for (int k = i; k >= 1; k--) {
                System.out.print(k+ " ");
            }
            for (int l = 2; l <= i; l++){
                System.out.print(l+" ");
            }
            System.out.println();
        }
    }
}
