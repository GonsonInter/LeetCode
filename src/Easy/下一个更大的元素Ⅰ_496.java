package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class 下一个更大的元素Ⅰ_496 {

//    /**
//     * 用数组，两次循环来做
//     */
//    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] result = new int[nums1.length];
//        Arrays.fill(result, -1);
//
//        boolean flag = false;
//        for (int i = 0; i < nums1.length; i++) {
//            for (int k : nums2) {
//                if (k == nums1[i]) {
//                    flag = true;
//                }
//                if (flag && k > nums1[i]) {
//                    result[i] = k;
//                    break;
//                }
//            }
//            flag = false;
//        }
//        return result;
//    }


    /**
     * 用栈来做，单调栈
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        stack.push(nums2[0]);
        for (int num : nums2) {
            while (!stack.empty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]) != null ? map.get(nums1[i]) : -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] res = nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2});
        for (int re : res) {
            System.out.println(re);
        }
        System.out.println("------------------");
        int[] res1 = nextGreaterElement(new int[] {1,3,5,2,4}, new int[] {6,5,4,3,2,1,7});
        for (int re : res1) {
            System.out.println(re);
        }
    }
}
