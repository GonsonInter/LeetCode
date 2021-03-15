package Easy;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角Ⅱ_119 {
//    public List<Integer> getRow(int rowIndex) {
//        ArrayList<Integer> res = new ArrayList<>();
//        res.add(1);
//
//        for (int level = 1; level <= rowIndex; level ++) {
//            res.add(1);
//            int lastVal = 1;
//            for (int i = 1; i <= level - 1; i ++) {
//                if (i == level) res.add(1);
//                else {
//                    int temp = lastVal;
//                    lastVal = res.get(i);
//                    res.set(i, temp + lastVal);
//                }
//            }
//        }
//        return  res;
//    }

    /**
     * 官方
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

}
