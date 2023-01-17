import java.util.*;
import java.io.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler099 {

    static class P {
        long b,e;
        double log;
        P(long b, long e) {
            this.b = b;
            this.e = e;
            log = e*Math.log(b);
        }
        void print() {
            System.out.println(b+" "+e+" "+log);
        }
    }

    static class SortP implements Comparator<P> {
        public int compare(P a, P b) {
            if(a.log<=b.log) return -1;
            else return 1;
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
        int n = s.nextInt();
        ArrayList<P> p = new ArrayList<>();
        for(int i=0;i<n;i++) p.add(new P(s.nextLong(), s.nextLong()));
        int k = s.nextInt();
        solve(p, k);
        s.close();
    }

    public static void solvePE() {
        try {
            File f = new File("Euler099.txt");
            Scanner s = new Scanner(f);
            ArrayList<P> p = new ArrayList<>();
            while(s.hasNextLine()) {
                String l[] = s.nextLine().split(",");
                p.add(new P(Long.parseLong(l[0]), Long.parseLong(l[1])));
            }
            int k = p.size();
            solve(p, k);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void solve(ArrayList<P> p, int k) {
        Collections.sort(p, new SortP());
        //for(int i=0;i<p.size();i++) p.get(i).print();
        System.out.println(p.get(k-1).b+" "+p.get(k-1).e);
    }
}
