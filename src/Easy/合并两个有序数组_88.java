package Easy;

import java.util.Arrays;

public class 合并两个有序数组_88 {
//    /**
//     * 双指针从前往后，需要额外的空间存储
//     */
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] temp = Arrays.copyOf(nums1, m);
//        int index = 0;
//        int i = 0, j = 0;
//        while (i < m && j < n) {
//            if (temp[i] <= nums2[j])
//                nums1[index ++] = temp[i ++];
//            else
//                nums1[index ++] = nums2[j ++];
//        }
//        while (i < m) {
//            nums1[index ++] = temp[i ++];
//        }
//        while (j < n) {
//            nums1[index ++] = nums2[j ++];
//        }
//    }


    /**
     * 双指针从后往前，不需要额外的空间
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int current = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j])   nums1[current --] = nums1[i --];
            else    nums1[current --] = nums2[j --];
        }

        while (j >= 0) {
            nums1[current --] = nums2[j --];
        }
    }
}
