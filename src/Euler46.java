import java.util.*;
public class Euler46 {
    public static void main(String argsp[])throws Exception {
    int i,p;
    boolean pr[] = new boolean[500001];
    Arrays.fill(pr, true);
    pr[0] = pr[1] = false;
    for(p=2;p*p<pr.length;p++) if(pr[p]) for(i=p*p;i<pr.length;i+=p) pr[i] = false;
    int prime[] = new int[41538];
    p = 0;
    for(i=2;i<pr.length;i++) if(pr[i]) prime[p++] = i;

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0) {
        int n = sc.nextInt();
        int c = 0;
        for(i=1;i<p;i++) {
        if(prime[i]<n) {
            double x = (n - prime[i])/2.0;
            int y = (int)Math.sqrt(x);
            if(y*y == (int)x) c++;
        }
        else break;
        }
        System.out.println(c);
    }
    }
}
