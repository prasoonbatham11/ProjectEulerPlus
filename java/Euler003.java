import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler003.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler003.java && java Euler001 1
*/

class Euler003 {

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
        long n,ans;
        while(t-->0)
            {
            n=s.nextLong();
            ans = solve(n);
            System.out.println(ans);
        }
        s.close();
    }

    public static void solvePE() {
        System.out.println(solve(600851475143L));
    }

    public static long solve(long n) {
        long lpf = 1; // largest prime factor

        // Check if 2 is a prime factor
        while(n%2==0) {
            n/=2;
            lpf=2;
        }
        // Check for all other primes
        for(long i=3; i*i<=n; i+=2) {
            while(n%i==0) {
                n/=i;
                lpf=i;
            }
        }
        // If the number left is greater than 1 then it is also prime
        if (n>1) {
            lpf=n;
        }
        return lpf;
    }
}