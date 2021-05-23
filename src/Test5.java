import java.util.Arrays;
import java.util.Comparator;

public class Test5 {
    public static void main(String[] args) {
        int n = 3;
        int[][] que = new int[][] {{123, 123}, {3, 3}, {5, 5}};
        Arrays.sort(que, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] * o1[1] - o1[0] * o2[1];
            }
        });
        for (int[] ints : que) {
            System.out.print(ints[0] + " ");
        }
    }

//    public static void sort(int[][] arr) {
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0] * o1[1] - o1[0] * o2[1];
//            }
//        });
//    }
}
