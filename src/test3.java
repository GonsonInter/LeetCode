import java.lang.reflect.Array;
import java.util.*;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        for (int line = 0; line < num; line ++) {
            int game = Integer.parseInt(sc.nextLine());
            String[] timeStr = sc.nextLine().split(" ");
            int[] time = new int[timeStr.length];
            for(int i = 0;i < time.length; i++){
                time[i] = Integer.parseInt(timeStr[i]);
            }
            String[] costsStr = sc.nextLine().split(" ");
            int[] costs = new int[costsStr.length];
            for(int i = 0;i < time.length; i++){
                costs[i] = Integer.parseInt(costsStr[i]);
            }
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < time.length; i ++) {
                if (map.containsKey(time[i])) {
                    map.get(time[i]).add(costs[i]);
                }   else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(costs[i]);
                    map.put(time[i], l);
                }
            }
            int res = 0;
            for (HashMap.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
                ArrayList<Integer> al = entry.getValue();
                if (al.size() == 1)  continue;
                int max = 0, count = 0;
                for (Integer integer : al) {
                    count += integer;
                    max = Math.max(max, integer);
                }
                res += (count - max);
            }
            System.out.println(res);
        }
    }
}
