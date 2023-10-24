import java.util.Scanner;

public class KaratsubaMultiplication {
    public static long karatsubaMultiply(long x, long y) {
        // Base case: If x or y is less than 10, perform simple multiplication and return the result
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Calculate the length of the numbers (number of digits)
        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());

        // Calculate the middle point (half) to split the numbers into two halves
        int half = (n + 1) / 2;

        // Split the input numbers into four parts: a, b, c, and d
        long a = x / (long) Math.pow(10, half);
        long b = x % (long) Math.pow(10, half);
        long c = y / (long) Math.pow(10, half);
        long d = y % (long) Math.pow(10, half);

        // Recursively calculate the products of the halves and the cross product
        long ac = karatsubaMultiply(a, c);
        long bd = karatsubaMultiply(b, d);
        long adbc = karatsubaMultiply(a + b, c + d) - ac - bd;

        // Combine the results to calculate the final product using Karatsuba algorithm
        return (long) (ac * Math.pow(10, 2 * half) + adbc * Math.pow(10, half) + bd);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        long x = scanner.nextLong();

        System.out.print("Enter the second number: ");
        long y = scanner.nextLong();

        long product = karatsubaMultiply(x, y);

        System.out.println("Product: " + product);

        scanner.close();
    }
}

        
    