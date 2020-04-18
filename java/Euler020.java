import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler020.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler020.java && java Euler001 1
*/

public class Euler020 {

    static int a[]; // a[n] = sum of digits of n!

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
        while(t-->0) {
            n = s.nextInt();
            System.out.println(solve(n));
        }
        s.close();
    }

    public static void solvePE() {
        precompute();
        System.out.println(solve(100));
    }

    public static int solve(int n) {
        return a[n];
    }

    public static void precompute() {
        int t[] = new int[5000]; // t stores the n!
        a = new int[1001];
        int i;
        a[0] = 1; // 0! = 1 thus sum of digits = 1
        t[t.length-1] = 1; // Store the first power. currently t represents 0! = {....0,0,0,1} = 1
        for(i=1;i<a.length;i++) {
            multiply(t,i);
            a[i] = sum(t);
        }
    }

    public static int sum(int t[]) {
        int sum = 0;
        for(int i=0;i<t.length;i++) {
            sum+=t[i];
        }
        return sum;
    }

    public static void multiply(int t[], int k) {
        int i = t.length-1;
        int c = 0;
        while(i>=0) {
            int d = t[i]*k+c;
            t[i] = d%10;
            c = d/10;
            i--;
        }
        while(c>0) {
            t[i] = c%10;
            c/=10;
            i--;
        }
    }
}