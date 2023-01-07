import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler015.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler015.java && java Euler001 1
*/

class Euler015 {

    static long C[][]; // C[i][j] = iCj
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
        precompute();
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int n, m;
        while(t-->0) {
            n = s.nextInt();
            m = s.nextInt();
            System.out.println(solve(n,m));
        }
        s.close();
    }

    public static void solvePE() {
        MOD = (long)(1e15);
        precompute();
        System.out.println(solve(20,20));
    }

    public static long solve(int n, int m) {
        return C[n+m][n];
    }

    public static void precompute() {
        C = new long[1001][1001];
        int i,j;
        for(i=1;i<=1000;i++) {
            C[i][0] = 1;
            C[i][i] = 1;
            C[i][1] = i;
        }
        for(i=1;i<=1000;i++) {
            for(j=2;j<i;j++) {
                C[i][j] = (C[i-1][j]%MOD + C[i-1][j-1]%MOD)%MOD;
            }
        }
    }
}