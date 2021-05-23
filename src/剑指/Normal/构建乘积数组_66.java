package 剑指.Normal;

public class 构建乘积数组_66 {


//    /**
//     * 计算所有非零元素乘积并且记录零的个数
//     *
//     * 但是题目要求不能使用除法，这种方法不行。
//     */
//    public int[] constructArr(int[] a) {
//        int multi = 1;
//        int count0 = 0;
//        int zeroIndex = -1;
//        for (int j = 0; j < a.length; j ++) {
//            if (a[j] != 0)
//                multi *= a[j];
//            else {
//                count0 ++;
//                zeroIndex = j;
//            }
//        }
//
//        int[] b = new int[a.length];
//
//        if (count0 == 0)
//            for (int i = 0; i < a.length; i ++) {
//                b[i] = multi / a[i];
//            }
//        else if (count0 == 1)
//            b[zeroIndex] = multi;
//
//        return b;
//    }


//    /**
//     * 暴力法
//     */
//    public int[] constructArr(int[] a) {
//
//    }


    /**
     * 动态规划
     * 用两个数组分别记录每一位左边所有数的乘积和右边所有数的乘积
     * 最后每一位的左边乘积乘以右边乘积
     */
    public int[] constructArr(int[] a) {
        if (a.length < 1)   return new int[0];
        if (a.length == 1)  return new int[] {0};

        int[] b = new int[a.length];
        b[0] = 1;

        for (int i = 1; i < a.length; i ++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        int[] c = new int[a.length];
        c[b.length - 1] = 1;
        for (int j = c.length - 2; j >= 0; j --) {
            c[j] = c[j + 1] * a[j + 1];
        }

        for (int k = 0; k < a.length; k ++)
            b[k] *= c[k];

        return b;
    }

}
