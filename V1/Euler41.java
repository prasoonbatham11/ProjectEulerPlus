import java.io.*;
import java.util.*;

public class Euler41 {

    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner sc = new Scanner(System.in);
    int i,p;
    boolean vis[] = new boolean[100000000];
    Arrays.fill(vis, true);
    vis[0] = vis[1] = false;
    for(p=2;p*p<vis.length;p++) if(vis[p]) for(i=p*p;i<vis.length;i+=p) vis[i] = false;
    int prime[] = new int[5045];
    //System.out.println(vis[7654321]);
    p = 0;
    for(i=1000;i<vis.length;i++) if(vis[i] && i<=4999 && pan(i,4)) prime[p++] = i;
        else if(vis[i] && i>=1000000 && i<8000000 && pan(i,7)) prime[p++] = i;
    //System.out.println(p);
    
    int t = sc.nextInt();
    //    System.out.println(bin(prime, p, 4231, 0));
    while(t-->0) {
        long n = sc.nextLong();
        long ans = bin(prime, p, n, 1);
        System.out.println(ans);
    }
    
    }
    public static boolean pan(int i, int n) {
    boolean[] v = new boolean[n+1];
    while(i>0) {
        int d = i%10;
        if(d<=n)
        v[i%10] = true;
        i/=10;
    }
    for(i=1;i<=n;i++) if(!v[i]) return false;
    return true;
    }
    public static long bin(int p[], int len,long k, int mode) {
    int lo = 0, hi = len-1, res = -1;
    while(lo<=hi) {
        int m = lo+(hi-lo)/2;
        //System.out.println(lo+" "+hi+" "+p[m]);
        if(p[m]<=k) lo = m+1;
        else if(p[m]>k) hi = m-1;
    }
    if(hi>=0) return p[hi];
    return hi;
    }
        
}
