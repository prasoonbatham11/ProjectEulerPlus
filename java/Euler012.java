import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler012.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler012.java && java Euler001 1
*/

class Euler012 {

    static long first[]; // first[i] = First TN to have over i divisors
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
        precompute();
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
        precompute();
        System.out.println(solve(500));
    }

    public static int countDivisors(long n) {
        int c = 0, p = 1, i;
        for(i=1;i<304;i++) {
            c = 0;
            while(n%prime[i]==0) {
                n/=prime[i];
                c++;
            }
            p = p*(c+1);
        }
        if(n>1) p = p*2;
        return p;
    }

    public static int[] sieve(int size) {
        boolean sieve[]=new boolean[size];
        Arrays.fill(sieve,true);
        sieve[0]=sieve[1]=false;
        int p,j,i=1;
        int[] prime = new int[304];
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
        return prime;
    }

    public static void precompute() {
        int size = 2000;
        prime = sieve(size);
        long tn; 
        int div;
        first = new long[2001];
        long i;
        for(i=1;i<1000004;i++) {
            tn = (i*(i+1))/2;
            div = countDivisors(tn);
            if(div<=2000 && first[div-1]==0) {
                int x = div-1;
                while(x>=1 && first[x]==0) first[x--] = tn;
            }
        }
    }

    public static long solve(int n) {
        return first[n];
    }
}