import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler014.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler014.java && java Euler001 1
*/

class Euler014 {

    static int max[]; // max[i] = Number <=i which produces the longest collatz chain

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
        while(t-->0) {
            n = s.nextInt();
            System.out.println(solve(n));
        }
        s.close();
    }

    public static void solvePE() {
        precompute();
        System.out.println(solve((int)1e6));
    }

    public static int solve(int n) {
        return max[n];
    }

    public static void precompute() {
        int CONST = (int)(5e6+1);
        int len[] = new int[CONST]; // chain length starting from number i.
        len[1] = 1;
        int i; long j;
        for(i=2;i<len.length;i++) {
            j = i;
            do {
                if(j%2==0) {
                    j/=2;
                } else {
                    j = 3*j + 1;
                }
                len[i]++;
            }while(j>i);
            len[i] += len[(int)j];
        }

        max = new int[CONST];
        max[1] = 1;
        for(i=2;i<CONST;i++) {
            int current_len = len[i];
            int prev_len = len[max[i-1]];
            if(current_len>=prev_len) {
                max[i] = i;
            } else {
                max[i] = max[i-1];
            }
        }
    }
}