import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler072 {

    static ArrayList<Integer> primes;
    static long ans[];
    
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
        int t = s.nextInt();
        seive(1000000);
        solve();
        while(t-->0) {
            int n = s.nextInt();
            System.out.println(ans[n]);
        }
        s.close();
    }

    public static void solvePE() {
        seive(1000000);
        solve();
        System.out.println(ans[1000000]);
    }

    public static void seive(int n) {
        boolean p[] = new boolean[n+1];
        primes = new ArrayList<>();
        Arrays.fill(p, true);
        for(int i=2;i*i<=n;i++) if(p[i]) for(int j=i*i;j<=n;j+=i) p[j] = false;
        for(int i=2;i<=n;i++) if(p[i]) primes.add(i);
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

    public static void solve() {
        ans = new long[1000001];
        for(int i=2;i<ans.length;i++) {
            ans[i] = ans[i-1]+phi(i);
        }
    }
}