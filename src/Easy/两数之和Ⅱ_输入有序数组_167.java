package Easy;

public class 两数之和Ⅱ_输入有序数组_167 {

//    /**
//     * 双指针
//     */
//    public int[] twoSum(int[] numbers, int target) {
//        int i = 0, j = numbers.length - 1;
//        while (i < j) {
//            if (numbers[j] > target - numbers[i])   j --;
//            if (numbers[i] < target - numbers[j])   i ++;
//            if (numbers[i] + numbers[j] == target)  break;
//        }
//        return new int[] {i + 1, j + 1};
//    }

    /**
     * 二分查找
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i ++) {
            int index = find(numbers, target, 0, numbers.length - 1);
            if (index != -1) return new int[] {i + 1, index + 1};
        }
        return new int[] {-1, -1};
    }

    public int find (int [] numbers, int num, int start, int end) {
        if (start < end) { return -1; }
        else if (num == numbers[(start + end) / 2])     return (start + end) / 2;
        else if (num < numbers[(start + end) / 2])      return find(numbers, num, start, (start + end) / 2 - 1);
        else    return find(numbers, num, (start + end) / 2 + 1, end);
    }

}
