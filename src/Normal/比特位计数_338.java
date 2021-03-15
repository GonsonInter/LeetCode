package Normal;

public class 比特位计数_338 {

//    /**
//     * 每个数都除二取余
//     */
//    public int[] countBits(int num) {
//        int[] result = new int[num + 1];
//        for (int i = 0; i <= num; i ++){
//            int count = 0;
//            int temp = i;
//            while (temp > 0) {
//                if (temp % 2 == 1) count ++;
//                temp /= 2;
//            }
//            result[i] = count;
//        }
//        return result;
//    }


    /**
     * 动态规划，按最高位
     */
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int currentMax2Power = 0;
        for (int i = 0; i <= num; i ++){
            if (is2Power(i)) {
                result[i] = 1;
                currentMax2Power = i;
                continue;
            }
            int offset = i - currentMax2Power;
            result[i] = result[offset] + 1;
        }
        return result;
    }
    public boolean is2Power(int num) {
        return (num & num - 1) == 0;
    }


}
