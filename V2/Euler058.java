import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler058 {

    static boolean p[];

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
        solve(10);
    }

    public static void seive(int n) {
        p = new boolean[n+1];
        Arrays.fill(p, true);
        for(int i=2;i*i<=n;i++) if(p[i]) for(int j=i*i;j<=n;j+=i) p[j] = false;
    }

    public static boolean isPrime(long n) {
        if(n<p.length) return p[(int)n];
        if(n<=3) return n>1;
        if(n%2==0 || n%3==0) return false;
        for(long i = 5;i*i<=n;i+=6) {
            if(n%i==0 || n%(i+2)==0) return false;
        }
        return true;
    }

    public static void solve(int n) {
        seive(10000000);
        long total = 1;
        double primes = 0;
        long side = 1;
        double percent = 100;
        long k = 1000;
        while(percent>=n) {
            side += 2;
            total += 4;

            long lr = side*side;
            long ll = lr - side + 1;
            long ul = ll - side + 1;
            long ur = ul - side + 1;

            if(isPrime(ll)) primes++;
            if(isPrime(ul)) primes++;
            if(isPrime(ur)) primes++;

            percent = (primes/total)*100;
            //System.out.println((2*i-1)+" "+percent);
        }
        System.out.println(side);
    }

}