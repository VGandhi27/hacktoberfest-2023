/*

Enter the number: 6
1 2 3 4 5 6 
1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1 

*/

import java.util.Scanner;

public class invHalfPyra {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        Scanner sc= new Scanner(System.in);

        int a= sc.nextInt();
        sc.close();

        for (int i = a; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }System.out.println();
        }
    }
}
