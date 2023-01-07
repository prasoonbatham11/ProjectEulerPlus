import java.util.*;

public class Euler47 {
    public static void main(String args[]) {
        solve();
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        int dstn[] = getPrimes();
        //System.out.println(dstn[230]+" "+dstn[231]+" "+dstn[232]);
        int i = 2;
        int run = 0;
        while(i<=n+k-1) {
            if(dstn[i]==k) {
                run++;
                if(run>=k) System.out.println(i-k+1);
            }
            else run = 0;
            i++;
        }
        sc.close();
    }

    public static int[] getPrimes() {
        int seive[] = new int[3000100];
        int p, j;
        Arrays.fill(seive, 0);
        for(p=2;p<seive.length;p++) if(seive[p]==0) for(j=p;j<seive.length;j+=p) {seive[j]++;
        }
        return seive;
    }
}