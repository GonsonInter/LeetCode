package 剑指.Easy;

public class 旋转数组的最小数字_11 {

//    /**
//     * 遍历直到找到一个值小于前一个值,暴力
//     */
//    public int minArray(int[] numbers) {
//
//        if (numbers.length == 0)    return Integer.MIN_VALUE;
//        for (int i = 0; i < numbers.length - 1; i ++) {
//            if (numbers[i] < numbers[i + 1])    return numbers[i + 1];
//        }
//        return numbers[0];
//    }

    /**
     * 二分法
     */
    public static int minArray(int[] numbers) {

        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[] {5,7,11,13,20,1,2,3,4}));
    }
}
