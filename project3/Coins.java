import java.util.Scanner;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.TreeSet;
public class Coins {
    public static void main(String[] args) throws Exception {
		FileReader txtfile = null;
		Scanner txt = null;
       if (args.length != 0) {
          txtfile = new FileReader(args[0]);
	      txt =	new Scanner(txtfile);
       }
       int i = 0;
       int M = txt.nextInt();
       TreeSet<Integer> coinage = new TreeSet<Integer>();
       TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();
       while (txt.hasNextInt())
		{
		   int j = txt.nextInt();
		   coinage.add(j);
           i++;
		}
		txt.close();
		TreeMap<Integer, Integer>[] coinage2;
		coinage2 = (TreeMap<Integer, Integer>[]) new TreeMap[1000];
		while (!(coinage.isEmpty())) {
		    coinage2[coinage.last()] = new TreeMap<Integer, Integer>();
		    count.put(min(M, coinage, coinage2[coinage.last()]), coinage.last());
		    coinage.pollLast();
		}
		System.out.println(M + ": " + count.firstKey() + " coins");
		int val = count.get(count.firstKey());
		while (coinage2[val].size() != 0) {
		    int k = coinage2[val].lastKey();
		    System.out.println(k + " * " + coinage2[val].get(k));
		    coinage2[val].pollLastEntry();
		}
    }
    public static int min(int M, TreeSet<Integer> coin, TreeMap<Integer, Integer> list) {
        int change = M;
        int count = 0;
        int G = coin.floor(change);
        int j = 1;
        while (change > 0) {
            int k = coin.floor(change);
            change = change - k;
            if (k == G) {
                list.put(k, j++);
            }
            else {
                j = 1;
                G = k;
                list.put(k, j);
            }
            if (change == 1) {
                list.put(change, j++);
            }
            count++;
        }
        return count;
    }
}