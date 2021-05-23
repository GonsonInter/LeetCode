import java.util.Arrays;
import java.util.Scanner;

public class test8 {

    public static boolean judge(int[] arr, int start, int end, int target) {
        if (end < start) return false;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        if (sum < target) return false;
        if (sum == target) return true;

        int avg = sum / (end - start + 1);
        int index = start;
        while (index <= end && arr[index] <= avg) { index++; }
        return judge(arr, start, index - 1, target)
                || judge(arr, index, end, target);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int times = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        Arrays.sort(weights);
        for (int i = 0; i < times; i++) {
            System.out.println(
                    judge(weights, 0, n - 1, sc.nextInt())
                            ? "YES" : "NO");
        }
    }
}
