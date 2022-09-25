import java.util.*;

public class Euler50 {
    public static void main(String args[]) {
        solve();
    }

    public static void solve() {
        int[] pr = getPrimes();
        long[] psum = new long[pr.length+1];
        

        for(int i=1;i<psum.length;i++) {
            psum[i] = psum[i-1]+pr[i-1];
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            long n = sc.nextLong();

            int i = 0;
            //System.out.println(Arrays.toString(psum).substring(0,100));
            while(psum[i]<=n) i++;i--;
            //System.out.println(i+" "+psum[i]+" "+psum[i-1]);

            //for(int p=1;p<psum.length;p++) if(psum[p]<psum[p-1]) System.out.println(p+" "+psum[p-1]+" "+psum[p]);

            int j;
            long maxSum = 0, maxLen = 0, sum = 0;
            for(j=0;j<=Math.min(31, i);j++) {
                for(int k=j+1;k<=i;k++) {
                    sum = psum[k] - psum[j];
                    if(isPrime(sum, 20) && k-j>=maxLen) {
                        maxLen = k-j;
                        maxSum = sum;
                    }
                }
            }
            System.out.println(maxSum+" "+maxLen);
        }
        sc.close();

    }
    public static long modular(long a, long b, long c) {
        long x = 1;
        a = a%c;
        while(b>0) {
            if(b%2==1) x = (x*a)%c;
            b/=2;
            a = (a*a)%c;
        }
        return x%c;
    }
    public static boolean miller(long d, long n) {
        long a = 2 + (long)(Math.random() % (n - 4));
        long x = modular(a, d, n);
        if(x==1 || x==n-1) return true;
        while(d!=n-1) {
            x = (x*x)%n;
            d*=2;
            if(x==1) return false;
            if(x==n-1) return true;
        }
        return false;
    }
    public static boolean isPrime(long n, int k) {
        if(n<=1 || n==4) return false;
        if(n<=3) return true;
        if(n%2==0) return false;
        long d = n-1;
        while(d%2==0) d/=2;
        for (int i = 0; i < k; i++) 
            if (!miller(d, n)) 
                return false; 
        return true;
    }
    public static int[] getPrimes() {
        int nPrimes = 6000000;
        boolean seive[] = new boolean[nPrimes];
        int p, j;
        Arrays.fill(seive, true);
        int c = 0;
        for(p=2;p*p<nPrimes;p++) if(seive[p]) {
            for(j=p*p;j<nPrimes;j+=p) seive[j] = false;
        }
        for(j=2;j<nPrimes;j++) if(seive[j]) c++;
        int primes[] = new int[c];
        p = 0;
        for(j=2;j<nPrimes;j++) {
            if(seive[j])
                primes[p++] = j;
        }
        return primes;
    }
}