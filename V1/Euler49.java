import java.util.*;

public class Euler49 {
    public static void main(String args[]) {
        solve();
    }
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();

        int[] primes = getPrimes(hm, 2000000);

        printRes(primes, hm, n, k);

    }

    public static void printRes(int[] primes, HashMap<String, ArrayList<Integer>> hm, int n, int k) {
        ArrayList<String> an = new ArrayList<>();
        int i = 0;
        while(primes[i]<n) {
            String hash = getHash(primes[i]);
            if(hm.containsKey(hash)) {
                an.addAll(printAns(find(hm.get(hash), n, k)));
                hm.remove(hash);
            }
            i++;
        }
        Collections.sort(an, new Comparator<String>() {
            public int compare(String a, String b) {
                if(a.length() < b.length()) return -1;
                else if(a.length() > b.length()) return 1;
                else {
                    return a.compareTo(b);
                }
            }
        });
        Iterator ii = an.listIterator();
        while(ii.hasNext()) {
            System.out.println(ii.next());
        }
    }

    public static ArrayList<ArrayList<Integer>> find(ArrayList<Integer> a, int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int siz = 0;
        if(k==3) {
            return find3(a, n);
        }
        else {
            ans = find3(a, n);
            siz = ans.size();
            int len = 0;
            int i, j;
            for(i=0;i<siz;i++) {
                len = ans.get(i).size();
                int indexoflast = bin(a, ans.get(i).get(len-1), 0);
                int d = ans.get(i).get(1) - ans.get(i).get(0);
                int next = ans.get(i).get(len-1) + d;
                int idxfourth = bin(a, next, indexoflast+1);
                if(idxfourth!=-1) ans.get(i).add(a.get(idxfourth));
            }
            i = 0;
            while(i<ans.size()) {
                if(ans.get(i).size()!=k) ans.remove(i);
                else i++;
            }
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> find3(ArrayList<Integer> a, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int siz = 0;
        for(int i=0;i<a.size();i++) {
            if(a.get(i)<n) {
                for(int j=i+1;j<a.size();j++) {
                    int d = a.get(j)-a.get(i);
                    int next = a.get(j)+d;
                    int m = bin(a, next, j+1);
                    if(m != -1) {
                        ans.add(new ArrayList<>());
                        siz++;
                        ans.get(siz-1).add(a.get(i)); ans.get(siz-1).add(a.get(j)); ans.get(siz-1).add(a.get(m)); 
                    }
                }
            }
        }
        return ans;
    }

    public static int bin(ArrayList<Integer> a, int num, int lo) {
        int mid, hi = a.size()-1;
        while(lo<=hi) {
            mid = lo+((hi-lo)/2);
            if(a.get(mid)==num) return mid;
            else if (a.get(mid)<num) lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }

    public static ArrayList<String> printAns(ArrayList<ArrayList<Integer>> a) {
        ArrayList<String> ans = new ArrayList<>();
        int siz = a.size();
        int i, j;
        for(i=0;i<siz;i++) {
            int len = a.get(i).size();
            StringBuilder sb = new StringBuilder();
            for(j=0;j<len;j++) {
                sb.append(a.get(i).get(j));
            }
            //System.out.println(sb.toString().trim());
            ans.add(sb.toString());
        }
        return ans;
    }

    public static boolean[] getSeive(int n) {
        boolean[] se = new boolean[n];
        int p = 2, j;
        Arrays.fill(se, true);
        se[0] = se[1] = false;
        for(p=2;p*p<se.length;p++) if(se[p]) for(j=p*p;j<se.length;j+=p) se[j] = false;
        return se;
    }
    public static int[] getPrimes(HashMap<String, ArrayList<Integer>> hm, int n) {
        boolean[] se = getSeive(n);
        ArrayList<Integer> primes = new ArrayList<>();
        int i;
        for(i=1000;i<n;i++) {
            if(se[i]) {
                primes.add(i);
                String hash = getHash(i);
                if(!hm.containsKey(hash)) {
                    hm.put(hash, new ArrayList<>());
                }
                hm.get(hash).add(i);
            }
        }
        int[] p = new int[primes.size()];
        for(i=0;i<p.length;i++) p[i] = primes.get(i);
        return p;
    }
    public static String getHash(int n) {
        int[] a = new int[10];
        while(n>0) {
            a[n%10]++;
            n/=10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++) sb.append(a[i]);
        return sb.toString();
    }
}