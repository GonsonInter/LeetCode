import java.util.*;

public class test11 {

    public static Map<String, int[]> map;
    public static List<int[]> li;


    public static int[] getIndex(List<int[]> l, int num) {
        int low = 0, high = l.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int[] range = l.get(mid);
            if (num >= range[0] && num <= range[1]) return l.get(mid);
            if (num < range[0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[0] ;
    }

    public static void insert(List<int[]> l, int[] r) {
        int low = 0, high = l.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int[] range = l.get(mid);
            if (r[0] >= range[0] && r[0] <= range[1]) {
                low = mid;
                break;
            }
            if (r[0] < range[0]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        l.add(low, r);
    }

    public static void main(String[] args) {
        map = new HashMap<>();
        li = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (line != null) {
            String[] t = line.split(" ");
            if (t[0].equals("0")) {
                int[] rule = new int[] { Integer.parseInt(t[1]), Integer.parseInt(t[2]) };
                int[] range = new int[] { Integer.parseInt(t[3]), Integer.parseInt(t[4]) };
                insert(li, range);
                map.put(Arrays.toString(range), rule);
            }   else if (t[0].equals("1")) {

            } else {
                int[] res = getIndex(li, Integer.parseInt(t[1]));
                for (String s : map.keySet())
                    System.out.println(s + ": " + Arrays.toString(map.get(s)));

                for (int i = 0; i < li.size(); i ++) {
                    System.out.println("---" + Arrays.toString(li.get(i)));
                }
                if (res.length > 0) {
                    int[] ss = map.get(Arrays.toString(res));
                    System.out.println(t[1] + " " + ss[0] + " " + ss[1]);
                }   else {
                    System.out.println(t[1]);
                }
            }

            line = sc.nextLine();
        }
    }
}
