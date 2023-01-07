import java.io.*;
import java.util.*;

public class Euler44
{
    //static long a[];
    static long[] a = new long[1000001];
    public static void main(String[] args)
    {

        int i;
        for(i=0;i<a.length;i++)
        {
            if(i%2==0) a[i] = ((long)(i/2))*((long)(3*i-1));
            else a[i] = (long) i*((long)((3*i-1)/2));
        }
        //for(i=0;i<a.length;i++) if(a[i]<0) {System.out.println(i);break;}
        //System.out.println(i);
        //System.out.println(Arrays.toString(a));
        //for(i=0;i<=100;i++) System.out.print(a[i]+" ");
        Scanner s = new Scanner(System.in);
        int n,k;
        n = s.nextInt(); k = s.nextInt();
        for(i=k+1;i<n;i++)
        {
            //System.out.println(a[i]+" "+(a[i]-a[i-k]));
            //System.out.println(b(a[i]-a[i-k]));
            //if(b(a[i]-a[i-k])>=0 || b(a[i]+a[i-k])>=0) System.out.println(a[i]);
            if(check(a[i]-a[i-k]) || check(a[i]+a[i-k])) System.out.println(a[i]);
        }
    }
    public static int b(long k)
    {
        int l = 0, h = a.length-1, m;
        while(l<=h)
        {
            m = l+(h-l)/2;
            if(a[m]==k) return m;
            else if(a[m]<k) l = m+1;
            else h = m-1;
        }
        return -1;
    }
    public static boolean check(long y)
    {
        long x = 24*y+1;
        long sq = (long)Math.sqrt(x);
        if(sq*sq!=x) return false;
        x = sq+1;
        if(x%6!=0) return false;
        return true;
    }
}
//projecteuler.net
        /*for(i=1;i<=5000;i++)
        {
            for(k=i+1;k<=5000;k++)
            {
                if(check(a[i]+a[k]) && check(a[k]-a[i]) && a[k]-a[i]<d) d = a[k]-a[i];
            }
        }
        System.out.println(d);*/