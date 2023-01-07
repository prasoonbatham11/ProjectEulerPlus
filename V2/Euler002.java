import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler002.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler002.java && java Euler001 1
*/

class Euler002 {

    // Array to store fibonacci numbers
    static long f[];

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
        long n,sum;
        while(t-->0)
            {
            n=s.nextLong();
            sum = solve(n);
            System.out.println(sum);
        }
        s.close();
    }

    public static void solvePE() {
        precompute();
        System.out.println(solve((long)4e6));
    }

    public static void precompute() {
        // Calculate and store fibonacci numbers
        f = new long[85];
        f[1] = 1;
        f[2] = 2;
        int i;
        for(i=3;i<f.length;i++) {
            f[i]=f[i-1]+f[i-2];
        }
    }

    public static long solve(long n) {
        int i;
        long sum = 0;
        for(i=2;;i+=3) {
            if(f[i]<=n) sum+=f[i];
            else break;
        }
        return sum;   
    }
}