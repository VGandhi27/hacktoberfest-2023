/*

Enter the number: 4
1 
0 1 
0 1 0 
1 0 1 0  

*/

import java.util.Scanner;

public class triangle01 {
    public static void main(String[] args) {
        System.out.print("Enter the number: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        int a=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if(a==1){
                    System.out.print(a + " ");
                    a=0;
                }
                else{
                System.out.print(a + " ");
                    a=1;
                }   
            }
            System.out.println();
        }
    }
}