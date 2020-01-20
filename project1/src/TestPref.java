import java.util.*;
import java.lang.*;
class a {
    public static void main(String args[]) {
        int[] b = {-1, -3, -6, 4, 1, -2};
        System.out.println(solution(b));
    }
    public static int solution(int[] A) {
        HashSet<Integer> h = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            h.add(A[i]);
        }
        min = 1;
        while(h.contains(min)) {
            min++;
        }
        return min;
    }
}