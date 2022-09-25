import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler019 .java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler019 .java && java Euler001 1
*/

public class Euler019  {
    
    static long month[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        if (args.length==0) {
            solveHR();
        }
        else {
            solvePE();
        }
    }

    public static void solveHR() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            Date d1 = new Date(sc.nextLong(), sc.nextInt(), sc.nextInt());
            Date d2 = new Date(sc.nextLong(), sc.nextInt(), sc.nextInt());
            System.out.println(solve(d1, d2));
        }
        sc.close();
    }

    public static void solvePE() {
        Date d1 = new Date(1901, 1, 1);
        Date d2 = new Date(2000, 12, 31);
        System.out.println(solve(d1, d2));
    }

    public static int solve(Date d1, Date d2) {
        int sun = 0;
        d2 = d2.next();
        while(!d1.equal(d2)) {
            if(d1.zeller()==1 && d1.d==1) {
                sun++;
            }
            d1 = d1.next();
        }
        return sun;
    }

    

    static class Date {
        long y;
        int m;
        int d;
        public Date(long y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }
        public Date next() {
            Date nd = new Date(y,m,d);
            if(isLeap()) month[2]++;
            if(nd.d<month[(int)nd.m]) {
                nd.d++;
            } else {
                nd.d = 1;
                if(nd.m<12) nd.m++;
                else {
                    nd.m = 1;
                    nd.y++;
                }
            }
            month[2] = 28;
            return nd;
        }
        public boolean isLeap() {
            if(y%100==0) {
                if(y%400==0) return true;
                else return false;
            } else if(y%4==0) return true;
            return false;
        }
        public boolean equal(Date date) {
            return y==date.y && m==date.m && d==date.d;
        }
        public int zeller() {
            if (m<=2) {
                m+=12;
                y--;
            }
            long day = (
                d
                + (13 * (m+1))/5
                + y
                + y/4 
                - y/100
                + y/400
            ) % 7;
            if(m>=13) {
                m-=12;
                y++;
            }
            return (int)day;
        }
        public String toString() {
            return d +" "+m+" "+y;
        }
    }
}
