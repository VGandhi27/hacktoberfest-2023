/*

Enter the number: 7
* * * * * * * 
* * * * * * 
* * * * * 
* * * * 
* * * 
* * 
*

*/

import java.util.Scanner;

public class decPattern {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.close();

        for (int i = a; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
