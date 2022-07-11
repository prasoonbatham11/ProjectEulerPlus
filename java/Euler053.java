import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler004.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler004.java && java Euler001 1
*/

class Euler053 {

    static double c[];

    public static void main(String[] args) {
        if (args.length==0) {
            solveHR();
        }
        else {
            solvePE();
        }
    }

    public static void solveHR() {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        long k=s.nextLong();
        precompute(n);
        int count = 0;
        for(int i=1;i<=n;i++) {
            count+=solve(i,k);
        }
        System.out.println(count);
        s.close();
    }

    public static void solvePE() {
        precompute(100);
        int count = 0;
        for(int i=1;i<=100;i++) {
            count+=solve(i,1000000);
        }
        System.out.println(count);
    }

    public static void precompute(int n) {
        c = new double[n+1];
        int i;
        for(i=1;i<=n;i++) {
            c[i] = c[i-1] + Math.log(i);
        }
    }

    public static int solve(int n, long k) {
        int i;
        int count = 0;
        double klog = Math.log(k);
        for(i=0;i<=n;i++) {
            if(c[n]-c[i]-c[n-i]>klog) count++;
        }
        return count;
    }
}