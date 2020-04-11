import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler009.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler009.java && java Euler001 1
*/

class Euler009 {

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
        int n;
        long ans;
        while(t-->0)
            {
            n = s.nextInt();
            ans = solve(n);
            System.out.println(ans);
        }
        s.close();
    }

    public static void solvePE() {
        System.out.println(solve(1000));
    }

    public static int solve(int n) {
        int a, b, c, pro, max = -1;
        for(int i = 2;i<=n-2;i++) {
            a = i;
            b = (n*(n-2*a))/(2*(n-a));
            c = n-a-b;
            if(b>0 && c>0 && a*a+b*b==c*c && a+b+c==n) {
                pro = a*b*c;
                if(pro>max) {
                    max = pro;
                }
            } 
        }
        return max;
    }
}