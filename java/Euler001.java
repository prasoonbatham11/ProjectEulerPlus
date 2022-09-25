import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler001.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler001.java && java Euler001 1
*/

class Euler001 {

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
        long n,sum;
        while(t-->0)
            {
            n=s.nextLong();
            n--;
            sum = solve(n);
            
            System.out.println(sum);
        }
        s.close();
    }

    public static void solvePE() {
        System.out.println(solve(999));
    }

    public static long solve(long n) {
        // Calculate number of multiples of 3, 5 and 15 less than and equal to n
        long n3 = n/3;
        long n5 = n/5;
        long n15 = n/15;
        
        // Sum of multiples of 3, 5 and 15 less than and equal to n
        long s3 = 3*((n3*(n3+1))/2);
        long s5 = 5*((n5*(n5+1))/2);
        long s15 = 15*((n15*(n15+1))/2);

        long sum = s3 + s5 - s15;
        return sum;
    }
}