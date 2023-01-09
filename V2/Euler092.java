import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler092 {

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
        solve(7);
    }

    public static boolean is89(int n) {
        int m = n;
        int sum;
        do {
            sum = 0;
            while(m>0) {
                sum += (int)Math.pow(m%10, 2);
                m/=10;
            }
            if(sum==89) return true;
            else if(sum==1) return false;
            m = sum;
        } while(true);
    }

    public static void solve(int n) {
        int mod = 1000000007;
        int i,l,sum,j;
        int s[] = new int[n*9*9+1];
        for(i=0;i<=9;i++) s[i*i]++;

        for(l=2;l<=n;l++) {
            for(sum=l*9*9;sum>0;sum--) {
                for(j=1;j<=9;j++) {
                    int sq = j*j;
                    if(sq>sum) break;
                    s[sum] += s[sum-sq];
                    s[sum] %= mod;
                }
            }
        }

        int c = 0;
        for(i=1;i<=n*9*9;i++) {
            if(is89(i)) {
                c += s[i];
                c %= mod;
            }
        }
        System.out.println(c);
    }
}