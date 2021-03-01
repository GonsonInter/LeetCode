package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 最小栈_155 {
    private ArrayList<Integer> arr;

    public 最小栈_155() {
        arr = new ArrayList<>();
    }

    public void push(int x) {
        arr.add(x);
    }

    public void pop() {
        arr.remove(arr.size() - 1);
    }

    public int top() {
        return arr.get(arr.size() - 1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (Integer integer : arr) {
            if (integer < min) min = integer;
        }
        return min;
    }
}

