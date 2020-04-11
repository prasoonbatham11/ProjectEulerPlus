import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler010.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler010.java && java Euler001 1
*/

class Euler010 {

    static long prime[];

    public static void main(String[] args) {
        if (args.length==0) {
            solveHR();
        }
        else {
            solvePE();
        }
    }

    public static void solveHR() {
        sieve((int)(2e6+1));
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int n;
        long ans;
        while(t-->0)
            {
            n=s.nextInt();
            ans = solve(n);
            System.out.println(ans);
        }
        s.close();
    }

    public static void solvePE() {
        sieve((int)(2e6+1));
        System.out.println(solve((int)(2e6)));
    }

    public static void sieve(int size) {
        boolean sieve[]=new boolean[size];
        Arrays.fill(sieve,true);
        sieve[0]=sieve[1]=false;
        int p,j,i=1;
        prime = new long[size];
        for(p=2;p*p<size;p++) {
            if(sieve[p]) {
                for(j=p*p;j<size;j+=p) {
                    sieve[j]=false;
                }
            }
        }
        for(i=2;i<size;i++) {
            if(sieve[i]) {
                prime[i] = i+prime[i-1];
            }
            else {
                prime[i] = prime[i-1];
            }
        }
    }

    public static long solve(int n) {
        return prime[n];
    }
}