package Easy;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角_118 {

//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> triangle = new ArrayList<>();
//        if (numRows == 0) return triangle;
//
//        List<Integer> first = new ArrayList<>();
//        first.add(1);
//        triangle.add(first);
//        if (numRows > 1) {
//            for (int level = 1; level < numRows; level ++) {
//                List<Integer> row = new ArrayList<>();
//                row.add(1);
//                for (int i = 1; i <= level - 1; i ++) {    //循环至当前行倒数第二个
//                    row.add(triangle.get(level - 1).get(i - 1) + triangle.get(level - 1).get(i));
//                }
//                row.add(1);
//                triangle.add(row);
//            }
//        }
//        return triangle;
//    }

    /**
     * 官方
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
