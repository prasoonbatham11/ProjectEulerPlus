import java.math.BigInteger;
import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler073 {

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
        int a = s.nextInt();
        int n = s.nextInt();
        System.out.println(solve(a, n));
        s.close();
    }

    public static void solvePE() {
        System.out.println(solve(2, 12000));
    }

    public static long rank(int n, int d, int m) {
        long p[] = new long[m+1];
        for(int i=0;i<=m;i++) p[i] = i*n/d;
        for(int i=2;i<=m;i++) {
            for(int j=2*i;j<=m;j+=i) {
                p[j]-= p[i];
            }
        }
        long ans = 0;
        for(int i=0;i<=m;i++) ans+=p[i];
        return ans; 
    }

    public static long solve(int a, int n) {
        return rank(1, a, n) - rank(1, a+1, n) - 1;
    }
}