import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler076 {

    static long p[][];
    static long P[];
    static long MOD = (long)(1e9+7);
    
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
        int t = s.nextInt();
        precompute();
        while(t-->0) {
            int n = s.nextInt();
            solve(n);
        }
        s.close();
    }

    public static void solvePE() {
        precompute();
        solve(100);
    }
   
    public static void precompute() {
        p = new long[1001][1001];
        P = new long[1001];
        p[1][1] = 1;
        int i,j;
        for(i=2;i<=1000;i++) {
            for(j=1;j<=i;j++) {
                p[i][j] = (p[i-j][j] + p[i-1][j-1])%MOD;
            }
        }
        for(i=1;i<=1000;i++) {
            for(j=1;j<=i;j++) {
                P[i] = (P[i]+p[i][j])%MOD;
            }
            P[i] = (P[i]-1)%MOD;
        }
    }
    
    public static void solve(int n) {
        System.out.println(P[n]);
    }

}
