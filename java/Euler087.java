import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler004.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler004.java && java Euler001 1
*/

class Euler087 {

    static int n;
    static boolean p[];
    static int ans[];
    static int aa[];
    static int MAX_LIMIT;

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
        MAX_LIMIT = 10000000;
        solve();
        int t = s.nextInt();
        for(int i=0;i<t;i++) {
            n = s.nextInt();
            System.out.println(aa[n]);
        }
        s.close();
    }

    public static void solvePE() {
        Scanner s = new Scanner(System.in);
        MAX_LIMIT = 50000000;
        solve();
        System.out.println(aa[MAX_LIMIT]);
        s.close();
    }

    public static void seive(int n) {
        p = new boolean[n+1];
        Arrays.fill(p, true);
        for(int i=2;i*i<=n;i++) if(p[i]) for(int j=i*i;j<=n;j+=i) p[j] = false;
    }

    public static void solve() {
        seive(8000);
        int primes[] = new int[1007];
        int i,j,k,m = 0,x = 0;
        for(i=2;i<p.length;i++) if(p[i]) primes[m++] = i;
        
        long power[][] = new long[primes.length][3];
        for(i=0;i<m;i++) {
            power[i][0] = primes[i]*primes[i];
            power[i][1] = power[i][0]*primes[i];
            power[i][2] = power[i][1]*primes[i];
            //System.out.println(i+" " + primes[i]+" "+power[i][0] + " "+power[i][1]+" " +power[i][2]);
        }
        TreeSet<Integer> an = new TreeSet<Integer>();
        for(i=0;i<908;i++) {
            for(j=0;j<73;j++) {
                for(k=0;k<23;k++) {
                    long val = power[i][0] + power[j][1] + power[k][2];
                    if(val <= MAX_LIMIT) {
                        an.add((int)val);
                    }
                }
            }
        }

        j = 1;
        aa = new int[MAX_LIMIT+1];
        while(!an.isEmpty()) {
            i = an.first();
            if(i<=j) {
                aa[j] = aa[j-1]+1;
                an.pollFirst();
                //System.out.println("happen" + j +" "+aa[j]);
            }
            else {
                aa[j] = aa[j-1];
            }
            j++;
            //System.out.println(i +" "+j+" "+aa[j]);
        }
        while(j<aa.length) {
            aa[j] = aa[j-1];
            j++;
        }
        //System.out.println(Arrays.toString(aa).substring(0, 1000));
    }
}