import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler004.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler004.java && java Euler001 1
*/

class Euler088 {

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
        
    }

    public static void solve(int n) {
        int i;
        for(i=2;i<=n;i++) {
            double ans = Math.exp(Math.log(i)/(1-1/i));
            System.out.println(i+ " "+(int)ans);
        }    
    }
}