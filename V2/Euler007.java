import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler007.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler007.java && java Euler001 1
*/

class Euler007 {

    static int prime[];

    public static void main(String[] args) {
        if (args.length==0) {
            solveHR();
        }
        else {
            solvePE();
        }
    }

    public static void solveHR() {
        sieve(110000);
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int n, ans;
        while(t-->0)
            {
            n=s.nextInt();
            ans = solve(n);
            System.out.println(ans);
        }
        s.close();
    }

    public static void solvePE() {
        sieve(110000);
        System.out.println(solve(10001));
    }

    public static void sieve(int size) {
        boolean sieve[]=new boolean[size];
        Arrays.fill(sieve,true);
        sieve[0]=sieve[1]=false;
        int p,j,i=1;
        prime = new int[size];
        for(p=2;p*p<size;p++) {
            if(sieve[p]) {
                for(j=p*p;j<size;j+=p) {
                    sieve[j]=false;
                }
            }
        }
        for(j=2;j<sieve.length;j++) {
            if(sieve[j]) {
                prime[i++] = j;
            }
        }
    }

    public static int solve(int n) {
        return prime[n];
    }
}