import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler137 {

    public static long MODULO = (long)(1e9+7);
    
    public static long fib(long n) {
        long F[][] = new long[][]{{1,1},{1,0}};
        if(n==0) return 0;
        power(F, n-1);
        return F[0][0];
    }

    public static void multiply(long F[][], long M[][]) {
        long w = ((F[0][0]*M[0][0])%MODULO + (F[0][1]*M[1][0])%MODULO)%MODULO;
        long x = ((F[0][0]*M[0][1])%MODULO + (F[0][1]*M[1][1])%MODULO)%MODULO;
        long y = ((F[1][0]*M[0][0])%MODULO + (F[1][1]*M[1][0])%MODULO)%MODULO;
        long z = ((F[1][0]*M[0][1])%MODULO + (F[1][1]*M[1][1])%MODULO)%MODULO;
        F[0][0] = w;
        F[0][1] = x;
        F[1][0] = y;
        F[1][1] = z;
    }

    public static void power(long F[][], long n) {
        if(n==0 || n==1) return;
        long M[][] = new long[][]{{1,1}, {1,0}};

        power(F, n/2);
        multiply(F, F);

        if(n%2!=0) {
            multiply(F,M);
        }
    }

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
        long n;
        while(t-->0) {
            n = s.nextLong();
            solve(n);
        }
        s.close();
    }

    public static void solvePE() {
        MODULO = (long)(1e18);
        solve(15);
    }

    public static void solve(long n) {
        long f1 = fib(2*n);
        long f2 = fib(2*n+1);
        long ans = (f1*f2)%MODULO;
        System.out.println(ans);
    }

}