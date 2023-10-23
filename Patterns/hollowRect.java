/*

Enter breadth: 4
Enter height: 3
* * * * 
*     * 
* * * * 

*/


import java.util.Scanner;

public class hollowRect {
    public static void main(String[] args) {
        System.out.print("Enter breadth: ");
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();

        System.out.print("Enter height: ");
        int h = sc.nextInt();
        sc.close();

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <=b; j++) {
                if(i==h || j==b ||i==1 || j==1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();

        }
    }
}
