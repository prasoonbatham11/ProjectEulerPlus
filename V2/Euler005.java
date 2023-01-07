import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler005.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler005.java && java Euler001 1
*/

class Euler005 {

    static long a[];

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
        int n;
        long ans;
        while(t-->0)
            {
            n=s.nextInt();
            ans = solve(n);
            System.out.println(ans);
        }
        s.close();
    }

    public static void solvePE() {
        precompute();
        System.out.println(solve(20));
    }

    public static void precompute() {
        a = new long[41];
        int i = 1;
        a[1] = 1;
        for(i=2;i<a.length;i++) {
            a[i] = lcm(i, a[i-1]);
        }
    }

    public static long solve(int n) {
        return a[n];
    }

    public static long lcm(long a, long b) {
        return (a*b)/gcd(a, b);
    }

    public static long gcd(long a, long b) {
        if (b==0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }
}