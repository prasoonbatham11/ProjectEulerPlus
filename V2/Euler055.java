import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler055 {

    public static void main(String[] args) {
        if (args.length==0) {
            solveHR();
        }
        else {
            solvePE();
        }
    }

    public static void solveHR() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        solve(n);
        s.close();
    }

    public static void solvePE() {
        long i, j, k, LIMIT = 50, n = 10000;
        boolean isP;
        long c = 0;

        for(i=1;i<n;i++) {
            j = i;
            isP = false;
            if(isPalindrome(j)) {
                j = j+reverse(j);
            }
            for(k=0;k<LIMIT;k++) {
                if(isPalindrome(j)) {
                    isP = true;
                    break;
                }
                j = j+reverse(j);
            }
            if(!isP) c++;
        }

        System.out.println(c);
    }

    public static boolean isPalindrome(long n) {
        return n==reverse(n);
    }

    public static long reverse(long n) {
        long m = 0;
        while(n>0) {
            m = m*10+n%10;
            n/=10;
        }
        return m;
    }

    public static void solve(int n) {
        
        long i,k, LIMIT = 60;
        long j;
        boolean isP;
        Map<Long, Long> count = new TreeMap<>();
        
        for(i=1;i<=n;i++) {
            j = i;
            isP = false;
            for(k=0;k<LIMIT;k++) {
                if(isPalindrome(j)) {
                    isP = true;
                    break;
                }
                j = j + reverse(j);
            }
            if(isP) {
                Long c = count.get(j);
                if(c==null) count.put(j, 1L);
                else count.put(j, c+1);
            };
        }

        i = 1;
        for(long key : count.keySet()) {
            if(count.get(key)>=count.get(i)) {
                i = key;
            }
        }

        System.out.println(i+" "+count.get(i));
    }
}