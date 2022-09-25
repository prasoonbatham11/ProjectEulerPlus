import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler004.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler004.java && java Euler001 1
*/

class Euler070 {

    static int n;
    static boolean p[];

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
        n = s.nextInt();
        seive(n);
        System.out.println(solve());
        s.close();
    }

    public static void solvePE() {
        n = 10000000;
        seive(n);
        System.out.println(solve());
    }

    public static void seive(int n) {
        p = new boolean[n+1];
        Arrays.fill(p, true);
        for(int i=2;i*i<=n;i++) if(p[i]) for(int j=i*i;j<=n;j+=i) p[j] = false;
    }

    public static int solve() {
        int i, r = 2;
        double min = Double.MAX_VALUE, val = 0;
        for(i=2;i<n;i++) {
            if(p[i]) {
                val = (i*1.0)/(i-1);
                if(val<min) {
                    r = i;
                }
            }
        }
        return r;
    }
}