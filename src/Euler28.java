import java.io.*;
import java.util.*;

public class Euler28 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        long n,ans;
        long m = 1000000007;
        long six = mod(6,m-2,m);
        long two = mod(2,m-2,m);
        while(t-->0)
            {
            n = s.nextLong();
            if(n==1) ans = 1;
            else
            {
                long a = ((((( (((n%m)*((n+1)%m))%m) * ((n+2)%m) )%m ) * ((4*six)%m) )%m) - 4+m)%m;
                long b = ( ( ( ((n+3)%m) * ((n-1+m)%m) )%m ) * ((3*two)%m) )%m;
                long c = (3*((n-1)%m))%m;
                ans = ((a+c)%m -b+m)%m;
                ans = (ans+1)%m;
            }
            //ans = (((((n+1)%m) * (((4*((n%m)*(n%m))%m)%m)-n+9+m)%m )%m*six)%m - 3 + m)%m;
            System.out.println(ans);
            
        }
    }
    public static long mod(long a, long b, long c)
    {
        long x = 1, y = a;
        while(b>0)
        {
            if(b%2==1) x = (x*y)%c;
            y = (y*y)%c;
            b/=2;
        }
        return x%c;
    }
}