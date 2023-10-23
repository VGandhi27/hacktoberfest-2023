/*

Enter the number: 4
1 
2 3 
4 5 6 
7 8 9 10 

*/

import java.util.Scanner;

public class floydTriangle {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        int a=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + " ");
                a++;
            }
            System.out.println();
        }
    }
}