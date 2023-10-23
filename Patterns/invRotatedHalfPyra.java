/*

Enter the number: 5
        * 
      * * 
    * * * 
  * * * * 
* * * * * 

 */

import java.util.Scanner;

public class invRotatedHalfPyra {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        sc.close();

        for (int i = 1; i <= a; i++) {
            for (int j = a; j > i; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
