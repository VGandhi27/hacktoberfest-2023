import java.util.Scanner;

public class OutputFormatting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");

        for (int i = 0; i < 3; i++) {
            String s1 = scanner.next();
            int x = scanner.nextInt();
            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");

        scanner.close();
    }
}
