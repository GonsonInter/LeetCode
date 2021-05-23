import java.util.Scanner;
public class test {

    static int  max = 0;
    public static int getDiff(String seq) {
        int length = seq.length();
        if (length <= 3 || length <= max)
            return Math.abs(count(seq,'0') - count(seq, '1'));
        max = Math.max(max, Math.abs(count(seq,'0') - count(seq, '1')));
        for (int i = 0; i < seq.length() - 3; i ++) {
            String newSeq;
            if (i != 0)
                newSeq = seq.substring(0, i) + seq.substring(i + 3);
            else
                newSeq = seq.substring(i + 3);

            // System.out.println(newSeq);
            max = Math.max(max, getDiff(newSeq));
        }
        return max;
    }
    public static int count(String seq, char c) {
        int count = 0;
        for (char c1 : seq.toCharArray()) {
            if (c1 == c)  count ++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            int num = Integer.parseInt(scan.nextLine());
            String seq = scan.nextLine().trim().substring(0, num);

            System.out.println(getDiff(seq));
        }

    }
}
