import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler088 {

    static int LIMIT = 200000;
    static int k[];

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
        solve(12000);
    }

    public static boolean valid(int n, int mk) {
        //System.out.println("Valid check: "+n+" "+mk+" "+k[mk]);
        if(mk>=k.length) {
            return false;
        }
        if(n<k[mk]) {
            //System.out.println("Found a lower value: "+n+" "+k[mk]);
            k[mk] = n;
            return true;
        }
        return false;
    }

    public static int getminK(int n, int p, int s, int d, int f) {
        //System.out.println("n = "+n+" Product= "+p+" Sum= "+s+" Depth= "+d+" Factor min= "+f);
        if(p==1) return valid(n, d+s-1) ? 1:0;
        int result = 0;
        if(d>1) {
            //System.out.println("D>1");
            if(p==s) return valid(n,d)?1:0;
            if(valid(n,d+s-p)) result++;
        }
        //System.out.println("Result: "+result);
        for(int i=f;i*i<=p;i++) {
            if(p%i==0) {
                result+=getminK(n, p/i, s-i, d+1, i);
            }
        }
        return result;
    }

    public static void solve(int N) {
        k = new int[N+1];
        Arrays.fill(k, Integer.MAX_VALUE);

        int n = 4;
        long sum = 0;
        int t = N-1;
        while(t>0) {
            //System.out.println();
            //System.out.println("Checking for n= "+n);
            //System.out.println("Sum: "+sum);
            int found = getminK(n,n,n,1,2);
            //System.out.println("Found for "+n+" Found value = "+found);
            if(found>0) {
                t -= found;
                sum += n;
            }
            n++;
        }
        System.out.println(sum);
    }
}