import java.math.BigInteger;
import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler056 {

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
        solve(100);
    }

    public static void solve(int n) {
        int max = 1;
        for(int a = 1;a<n;a++) {
            for(int b = 1;b<n;b++) {
                BigInteger A = new BigInteger(a+"");
                BigInteger B = new BigInteger(b+"");
                BigInteger P = new BigInteger("1");
                for(int c = 0;c<b;c++) {
                    P = P.multiply(A);
                }
                String N = P.toString();
                int c = 0;
                for(int i=0;i<N.length();i++) {
                    c += N.charAt(i) - '0';
                }
                if(c>max) max = c;
            }
        }
        System.out.println(max);
    }

}