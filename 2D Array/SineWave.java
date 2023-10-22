import java.util.ArrayList;
import java.util.List;

public class SineWave {
    public static List<Integer> wavePrint(int[][] arr, int nRows, int mCols) {
        List<Integer> ans = new ArrayList<>();
        for (int col = 0; col < mCols; col++) {
            if (col % 2 == 1) {
                for (int row = nRows - 1; row >= 0; row--) {
                    ans.add(arr[row][col]);
                }
            } else {
                for (int row = 0; row < nRows; row++) {
                    ans.add(arr[row][col]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int nRows = 3;
        int mCols = 3;

        List<Integer> result = wavePrint(arr, nRows, mCols);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
