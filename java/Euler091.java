import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler004.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler004.java && java Euler001 1
*/

class Euler091 {

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
        long ans = solve(n);
        System.out.println(ans);
        s.close();
    }

    public static void solvePE() {
        
    }

    public static long solve(int n) {
        int i,j;
        long ans = 0;
        for(i=1;i<=n;i++) {
            for(j=1;j<=i;j++) {
                if(i==1 && j==1) {
                    ans+=3;
                }
                else if(i==j) {
                    ans+=3;
                    if(i%2==0) ans+=2;
                }
                else {
                    ans += 6;
                }
            }
        }    
        return ans;
    }
}