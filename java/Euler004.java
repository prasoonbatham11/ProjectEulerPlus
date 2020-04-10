import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler004.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler004.java && java Euler001 1
*/

class Euler004 {

    static int[] palin;

    public static void main(String[] args) {
        if (args.length==0) {
            solveHR();
        }
        else {
            solvePE();
        }
    }

    public static void solveHR() {
        precompute();
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        long n,ans;
        while(t-->0)
            {
            n=s.nextLong();
            ans = solve(n);
            System.out.println(ans);
        }
        s.close();
    }

    public static void solvePE() {
        precompute();
        System.out.println(solve(1000000));
    }

    public static void precompute() {
        palin = new int[489];
        int k = 0;
        for (int i = 101;i<=999;i++) {
            for (int j = i;j<=999;j++) {
                int p = i*j;
                if(isPalin(p) && isSixDig(p)) {
                    palin[k++] = p;
                }
            }
        }
        Arrays.sort(palin);
    }

    public static long solve(long n) {
        for(int i = palin.length-1;i>=0;i--) {
            if(palin[i]<n) return palin[i];
        }
        return -1;
    }

    public static boolean isSixDig(int n) {
        int c = 0;
        while(n>0) {
            n/=10;
            c++;
        }
        return c==6;
    }

    public static boolean isPalin(int n) {
        int r = 0, d = 0, m = n;
        while(n>0) {
            d = n%10;
            r = r*10 + d;
            n/=10;
        }
        return m==r;
    }
}