import java.util.*;
public class Euler45 {
    public static void main(String arhs[])throws Exception {
    Scanner sc = new Scanner(System.in);
    long tp[] = new long[9];
    int i;
    tp[0] = 1; tp[1] = 210;
    for(i=2;i<tp.length;i++) {
        tp[i] = 194*tp[i-1]-tp[i-2]+16;
        //System.out.println(tp[i]);
    }

    long ph[] = new long[5];
    ph[0] = 1; ph[1] = 40755;
    for(i=2;i<ph.length;i++) {
        ph[i] = 37634*ph[i-1] - ph[i-2]+3136;
        //System.out.println(ph[i]);
    }

        long n = sc.nextLong(); int a = sc.nextInt(); int b = sc.nextInt();
    if(a==3) {
        ans(tp, n);
    }
    else ans(ph,n);
    }
    public static void ans(long a[], long n) {
    for(int i=0;i<a.length;i++) {
        if(a[i]<n) System.out.println(a[i]);
        else break;
    }
    }
}
     
