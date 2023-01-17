import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler077 {
    
    static boolean prime[];

    static long p[][];
    static long P[];
    static long MOD = (long)(1e9+7);
    
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
        seive();
        precompute();
        while(t-->0) {
            int n = s.nextInt();
            solve(n);
        }
        s.close();
    }

    public static void solvePE() {
        seive();
        precompute();
        for(int i=0;i<=1000;i++) {
            if(p[i][i]>5000) {
                System.out.println(i);
                break;
            }
        }
    }
    
    public static void seive() {
        prime = new boolean[1001];
        Arrays.fill(prime, true);
        for(int i=2;i<=1000;i++) {
            if(prime[i])
                for(int j=i*i;j<=1000;j+=i) {
                    prime[j] = false;
                }
        }
    }
   
    public static void precompute() {
        p = new long[1001][1001];
        
        int i,j;
        for(j=0;j<=1000;j++) p[0][j] = 1;
        for(i=2;i<=1000;i++) {
            for(j=2;j<=1000;j++) {
                //System.out.println(i+" "+j);
                if(j>i || !prime[j]) {
                    //System.out.println("Inside");
                    p[i][j] = p[i][j-1];
                }
                else {
                    p[i][j] = p[i-j][j] + p[i][j-1];
                }
                
            }
        }
    }
    
    public static void solve(int n) {
        System.out.println(p[n][n]);
    }

}
