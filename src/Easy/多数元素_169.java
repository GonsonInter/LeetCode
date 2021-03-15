package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class 多数元素_169 {

//    /**
//     * Hash表解法
//     */
//    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.replace(num, map.get(num) + 1);
//            } else
//                map.put(num, 1);
//        }
//
//        Map.Entry<Integer, Integer> maxEntry = null;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (maxEntry == null || maxEntry.getValue() < entry.getValue())
//                maxEntry = entry;
//        }
//        assert maxEntry != null;
//        return maxEntry.getKey();
//    }

//    /**
//     * 排序后，下标为 length/2 取下整的数必为众数
//     *
//     */
//    public static int majorityElement(int[] nums) {
//        // 冒泡排序,时间较长
//        for (int i = 0; i < nums.length; i ++) {
//            boolean flag = false;
//            for (int j = nums.length - 1; j > i; j --) {
//                if (nums[j] < nums[j - 1]) {
//                    int temp = nums[j];
//                    nums[j] = nums[j - 1];
//                    nums[j - 1] = temp;
//                    flag = true;
//                }
//            }
//            if (!flag)   break;
//        }
//
//        return nums[(nums.length - 1) / 2];
//    }


//    /**
//     * 因为超过 length/2 取整 的数组下标被众数占据了，这样我们随机挑选一个下标对应的元素并验证，有很大的概率能找到众数。
//     */
//    private int randRange(Random rand, int min, int max) {
//        return rand.nextInt(max - min) + min;
//    }
//    private int countOccurences(int[] nums, int num) {
//        int count = 0;
//        for (int j : nums) {
//            if (j == num) {
//                count++;
//            }
//        }
//        return count;
//    }
//    public int majorityElement(int[] nums) {
//        Random rand = new Random();
//
//        int majorityCount = nums.length / 2;
//
//        while (true) {
//            int candidate = nums[randRange(rand, 0, nums.length)];      // 取若干个随机数
//            if (countOccurences(nums, candidate) > majorityCount) {
//                return candidate;
//            }
//        }
//    }


//    /**
//     *  随机算法
//     */
//    public static int majorityElement(int[] nums) {
//
//        return 0;
//    }


    /**
     * 投票算法，先选择一个候选众数，维护一个count, 遍历数组，如果碰到了与自己相等的，count++， 否则count--。
     * 每当count = 0 时，更换候选众数。直到遍历完数组。
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
    }

}
