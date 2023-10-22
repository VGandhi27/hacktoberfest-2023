import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeOverlappingIntervals {

    // Time Complexity: O(N*logN) + O(2*N) = N*log*N
    // Space Complexity: O(N)

    public static List<int[]> mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> mergedIntervals = new ArrayList<>();

        int currentInterval[] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        mergedIntervals.add(currentInterval);
        return mergedIntervals;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter start and end points for interval " + (i + 1) + ": ");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals[i][0] = start;
            intervals[i][1] = end;
        }

        List<int[]> mergedIntervals = MergeOverlappingIntervals.mergeIntervals(intervals);

        System.out.println("The merged intervals are:");
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

        scanner.close();
    }

}
