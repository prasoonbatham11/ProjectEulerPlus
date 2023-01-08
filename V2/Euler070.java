import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler070.java && java Euler070
*
*   To run projecteuler.net solution run:
*   javac Euler070.java && java Euler070 1
*/

class Euler070 {

    static int n;
    static boolean p[];
    static ArrayList<Integer> primes;

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
        n = s.nextInt();
        seive(n);
        System.out.println(solve());
        s.close();
    }

    public static void solvePE() {
        n = 10000000;
        seive(n);
        System.out.println(solve());
    }

    public static void seive(int n) {
        int m = n;
        p = new boolean[m+1];
        primes = new ArrayList<>();
        Arrays.fill(p, true);
        for(int i=2;i*i<=m;i++) if(p[i]) for(int j=i*i;j<=m;j+=i) p[j] = false;
        for(int i=2;i<=m;i++) if(p[i]) primes.add(i);
    }

    public static long phi(int n) {
        long result = n;
        long reduced = n;
        for(Integer p: primes) {
            if(p*p>reduced) break;
            if(reduced%p==0) {
                do {
                    reduced /= p;
                } while(reduced%p==0);
                result -= result/p;
            }
        }
        if(reduced>1) return result - result/reduced;
        else return result;
    }

    public static boolean check_perm(long a, long b) {
        int a_i[] = new int[10];
        int b_i[] = new int[10];
        while(a>0) {
            a_i[(int)(a%10)]++;
            a/=10;
        }
        while(b>0) {
            b_i[(int)(b%10)]++;
            b/=10;
        }
        for(int i=0;i<10;i++) {
            if(a_i[i]!=b_i[i]) return false;
        }
        return true;
    }

    public static long solve() {
        long phi_;
        double r;
        Phi ans = new Phi(Long.MAX_VALUE, Long.MAX_VALUE, Double.MAX_VALUE);
        for(int i=21;i<n;i++) {
            if(!p[i]) {
                phi_ = phi(i);
                if(check_perm(phi_, i)) {
                    r = (i*1.0)/phi_;
                    if(r<ans.rat) {
                        ans.reassign(i, phi_, r);
                    }
                }
            }
        }
        return ans.n;
    }

    public static class Phi {
        long n, phi;
        double rat;
        public Phi(long n, long phi, double rat) {
            this.n = n;
            this.phi = phi;
            this.rat = rat;
        }  
        public String toString() {
            return n+" "+phi+" "+rat;
        }
        public void reassign(long n, long phi, double rat) {
            this.n = n;
            this.phi = phi;
            this.rat = rat;
        }
    }
}