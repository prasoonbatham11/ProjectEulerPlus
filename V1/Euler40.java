import java.util.*;
public class Euler40
{
    public static void main(String args[])
    {
        long a[] = new long[18];a[0] = 0;
        int i;
        long k = 9;
        for(i=1;i<a.length;i++)
        {
            a[i] = a[i-1] + k*i;
            k = k*10;
        }
        //System.out.println(Arrays.toString(a));
        long start[] = new long[20]; start[0] = 0; start[1] = 1;
        for(i=2;i<20;i++) start[i] = 10*start[i-1];
        //System.out.println(Arrays.toString(start));
        
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0)
        {
            long f;
            long prod = 1;
            for(i=0;i<7;i++) 
            {
                //f = i;
                f = s.nextLong();
                int d = bin(a,f);
                //System.out.println(d);
                //System.out.println(d);
                f = f-a[d]-1;
                d++;
                long x = start[d];
                long g = f/d;
                int h = (int)(f%d);
                x = x+g;
                //System.out.print(x+" "+h+" "+f+" ");
                if(h<0) System.out.println(i);
                prod *= ((x+"").charAt(h)-'0');
                //System.out.print(Integer.parseInt((x+"").charAt(h)+""));
            }
            System.out.println(prod);
        }
        
        
    }
    public static int bin(long a[], long k)
    {
        int i;
        for(i=1;i<a.length;i++) if(k==a[i]) return i-1;
        int l = 0, h = a.length-1, mid=(l+h)/2;
        if(k<a[0]) return -1;
        while(h-l>1)
        {
            mid = l+(h-l)/2;
            if(a[mid]<=k) l = mid;
            else if(a[mid]>k) h = mid;
        }
        return l;
        
    }
}
        