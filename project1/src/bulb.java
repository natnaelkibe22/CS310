import java.util.*;
import java.lang.*;
class bulb {
    public static void main(String args[]) {
        int[] b = {1, 3, 4, 2, 5};
        System.out.println(solution(b));
    }
    public static int solution(int[] A) {
       int max = 0;
       for (int i = 0; i < A.length; i++) {
           if (A[i] > max) {
               max = A[i];
           }
       }
       max = max + 1;
       boolean[] on = new boolean[max];
       int shin = 0;
       int bright = 0;
       //on[0] = false;
       for (int i = 0; i < A.length; i++) {
            on[A[i]] = true;
            for (int j = A[i]; j < A.length; j++) {
               if (on[j]) {
                   bright++;
               }
               else {
                   break;
               }
           }
           if ((A[i]) == bright) {
               shin++;
           }
           bright = 0;
       }
       return shin;
    }
}