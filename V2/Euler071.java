import java.math.BigInteger;
import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler071.java && java Euler071
*
*   To run projecteuler.net solution run:
*   javac Euler071.java && java Euler071 1
*/

class Euler071 {

    static BigInteger A,B,C,D;

    public static class F {
        long n, d;
        public F(long n, long d) {
            this.n = n;
            this.d = d;
        }
        public boolean equals(F f) {
            if(this.n==f.n && this.d==f.d) return true;
            return false;
        }
        public boolean isLessThan(F f) {
            A = new BigInteger(n+"");
            B = new BigInteger(d+"");
            C = new BigInteger(f.n+"");
            D = new BigInteger(f.d+"");
            return (A.multiply(D)).compareTo(B.multiply(C))<0;
        }
        public boolean isGreaterThan(F f) {
            A = new BigInteger(n+"");
            B = new BigInteger(d+"");
            C = new BigInteger(f.n+"");
            D = new BigInteger(f.d+"");
            return (A.multiply(D)).compareTo(B.multiply(C))>0;
        }
        public String print() {
            return n+"/"+d+" ";
        }
    }

    public static class G {
        F l, m, r;
        public G(F l, F m, F r) {
            this.l = l;
            this.m = m;
            this.r = r;
        }
        public void left() {
            long n = l.n+m.n;
            long d = l.d+m.d;
            r.n = m.n; 
            r.d = m.d;
            m.n = n;
            m.d = d;
        }
        public void right() {
            long n = m.n+r.n;
            long d = m.d+r.d;
            l.n = m.n;
            l.d = m.d;
            m.n = n;
            m.d = d;
        }
        public String print() {
            return l.print()+m.print()+r.print();
        }
    }

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
        F f;
        long N;
        while(t-->0) {
            f = new F(s.nextLong(), s.nextLong());
            N = s.nextLong();
            F a = solve(f,N);
            System.out.println(a.n+" "+a.d);
        }
        s.close();
    }

    public static void solvePE() {
        F f = new F(3, 7);
        long N = 1000000;
        F a = solve(f, N);
        System.out.println(a.n+" "+a.d);
    }

    public static F solve(F f, long N) {
        G g = new G(new F(0,1), new F(1,1), new F(1,0));
        while(true) {
            if(f.equals(g.m)) {
                break;
            }
            else if(f.isLessThan(g.m)) {
                g.left();
            } else {
                g.right();
            }
        }
        g.left();
        if(g.m.d>N) return g.l;
        long x = (long)Math.floor((N-g.m.d)/(g.r.d*1.0))+1;
        F ans = new F(g.m.n+(x-1)*g.r.n, g.m.d+(x-1)*g.r.d);
        /*while(true) {
            if(g.m.d>N) {
                break;
            }
            g.right();
        }*/
        return ans;
    }

    
}