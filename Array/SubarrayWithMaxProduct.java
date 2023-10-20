import java.util.Scanner;

public class SubarrayWithMaxProduct {
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    static int subarrayWithMaxProduct(int arr[]) {
        int prod1 = arr[0], prod2 = arr[0], result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(prod1 * arr[i], prod2 * arr[i]));
            prod2 = Math.min(arr[i], Math.min(prod1 * arr[i], prod2 * arr[i]));
            prod1 = temp;

            result = Math.max(result, prod1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int maxProduct = subarrayWithMaxProduct(arr);

        System.out.println("Maximum product of a subarray: " + maxProduct);

        scanner.close();
    }
}
