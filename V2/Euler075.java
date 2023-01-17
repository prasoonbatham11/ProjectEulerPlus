import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler075 {

    static int py[], count[];
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
        precompute();
        while(t-->0) {
            int n = s.nextInt();
            solve(n);
        }
        s.close();
    }

    public static void solvePE() {
        precompute();
        solve(1500000);
    }
    
    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
    
    public static void precompute() {
        count = new int[5000000+1];
        py = new int[count.length];
        int m, n;
        for(m = 2;m*m<count.length;m++) {
            for(n = 1;n<m;n++) {
                if((m+n)%2==0) continue;
                if(gcd(m,n)!=1) continue;
                int a = m*m-n*n;
                int b = 2*m*n;
                int c = m*m+n*n;
                int sum = a+b+c;
                int k = 1;
                while(k*sum<count.length) {
                    py[k*sum]++;
                    k++;
                }
            }
        }
        for(m=1;m<count.length;m++) {
            count[m] = count[m-1];
            if(py[m]==1) count[m]++;
        }
    }
    
    public static void solve(int n) {
        System.out.println(count[n]);
    }

}
