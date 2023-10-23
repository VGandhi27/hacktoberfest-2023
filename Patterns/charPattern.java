/*

Enter the number: 5
A 
B C 
D E F 
G H I J 
K L M N O 

*/

import java.util.Scanner;

public class charPattern {
    public static void main(String[] args) {
        char c = 'A';
        System.out.print("Enter the number: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(c + " ");
                c++;
            }
            System.out.println();
        }
    }
}