import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler006.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler006.java && java Euler001 1
*/

class Euler006 {

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
        int t=s.nextInt();
        long n;
        long ans;
        while(t-->0)
            {
            n=s.nextLong();
            ans = solve(n);
            System.out.println(ans);
        }
        s.close();
    }

    public static void solvePE() {
        System.out.println(solve(100));
    }

    public static long solve(long n) {
        long ans = (((n*(n+1))/2)*((3*n*n-n-2)))/6;
        return ans;
    }
}