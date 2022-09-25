import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Euler43
{
    static int a[];
    static long sum;
    static int b[];
    static int n;
	public static void main(String args[])throws Exception
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//the code goes here
        n = sc.nextInt();
        b = new int[]{2, 3, 5, 7, 11, 13, 17};
        sum = 0;
        a = new int[n+1];
        int i;
        for(i=0;i<=n;i++) a[i] = i;
        permute(0, n);
        System.out.println(sum);

	}
	public static void permute(int l, int r)
    {
        if(l==r)
        {
            pandigital();
            return;
        }
        int i;
        for(i=l;i<=r;i++)
        {
            swap(i, l);
            permute(l+1, r);
            swap(i,l);
        }
    }
    public static void swap(int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void pandigital()
    {
        int i = 1;
        int k = 0;
        boolean v = true;
        while(i<=n-2)
        {
            int x = 100*a[i]+10*a[i+1]+a[i+2];
            if(x%b[k]!=0) v = false;
            i++; k++;
        }
        if(v)
        {
            i = 0;
            long y = 0;
            for(i=0;i<=n;i++)
            {
                y  = y*10+a[i];
            }
            //System.out.println(y);
            sum+=y;
        }
    }
}