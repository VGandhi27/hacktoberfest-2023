/*

Enter the number: 5
* * * * * 
* * * * * 
* * * * * 
* * * * * 
* * * * * 

*/

import java.util.Scanner;

public class squarepat {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.close();

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
