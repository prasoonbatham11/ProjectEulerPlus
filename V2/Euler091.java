import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler091 {

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
        long ans = solve(n);
        System.out.println(ans);
        s.close();
    }

    public static void solvePE() {
        System.out.println(solve(50));
    }

    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }

    public static long solve(int n) {
        long ans = 3*n*n;
        int px, py, qx, qy, factor, dx, dy, f;
        for(px=1;px<=n;px++) {
            for(py=1;py<=px;py++) {
                factor = gcd(px, py);
                dx = px/factor;
                dy = py/factor;

                f = 0;

                qx = px - dy;
                qy = py + dx;
                while(qx>=0 && qx<=n && qy>=0 && qy<=n) {
                    f++;
                    qx -= dy;
                    qy += dx;
                }

                qx = px + dy;
                qy = py - dx;
                while(qx>=0 && qx<=n && qy>=0 && qy<=n) {
                    f++;
                    qx += dy;
                    qy -= dx;
                }

                if(px!=py) f*=2;

                ans+=f;
            }
        }
        return ans;
    }
}