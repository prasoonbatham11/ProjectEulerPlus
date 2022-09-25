import java.util.*;
public class Euler33 {
    public static void main(String args[]) {
        solve();
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int[] pr = getPrimes();
        //System.out.println(Arrays.toString(pr).substring(0, 100));
        //System.out.println(getReducedFrac(new Frac(sc.nextInt(), sc.nextInt()), pr));


        
        sc.close();
    }
    public static Frac getNonTrivialFrac(Frac g) {
        Frac f = new Frac(g.n, g.d);
        int[] x = getBinary(g.n), y = getBinary(g.d);
        int i;
        for(i=0;i<10;i++) {
            if(x[i]==y[i]) {
                x[i] = y[i] = 0;
            }
            else if(x[i]>y[i]) x[i] -= y[i];
            else y[i]-=x[i];
        }
        return f;
    }
    public static int[] getBinary(int n) {
        int a[] = new int[10];
        while(n>0) {
            a[n%10]++;
            n/=10;
        }
        return a;
    }
    public static Frac getReducedFrac(Frac g, int[] pr) {
        Frac f = new Frac(g.n, g.d);
        int i = 0;
        while(pr[i]<=f.n && pr[i]<=f.d) {
            //System.out.println(pr[i]+" "+f);
            while(f.n%pr[i]==0 && f.d%pr[i]==0 && f.n>1 && f.d>1) {
                f.n/=pr[i];
                f.d/=pr[i];
            }
            i++;
        }
        return f;
    }
    public static int[] getPrimes() {
        boolean seive[] = new boolean[200000];
        int p, j;
        Arrays.fill(seive, true);
        seive[0] = seive[1] = false;
        for(p=2;p*p<seive.length;p++) if(seive[p]) for(j=p*p;j<seive.length;j+=p) seive[j] = false;
        ArrayList<Integer> pr = new ArrayList<>();
        for(p=2;p<seive.length;p++) if(seive[p]) pr.add(p);
        return getIntArray(pr);
    }
    public static int[] getIntArray(ArrayList<Integer> a) {
        return a.stream().mapToInt(i -> i).toArray();
    }
    static class Frac {
        int n, d;
        Frac(int n, int d) {
            this.n = n;
            this.d = d;
        }
        public String toString() {
            return n+"/"+d;
        }
        public boolean isEquals(Frac f) {
            return this.n==f.n && this.d == f.d;
        }
    }
}