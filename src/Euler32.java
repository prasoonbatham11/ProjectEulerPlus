import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
public class Euler32
{
    static int a[];
    static int count;
    static boolean vis[];
	public static void main(String args[])throws Exception
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//the code goes here
        int n = sc.nextInt();
        a = new int[n];
        int i;
        for(i=0;i<n;i++) a[i] = i+1;
        count = 0;
        vis = new boolean[1000000];
        Arrays.fill(vis, false);
        permute(0, n-1);
        System.out.println(count);

	}

	public static void permute(int l, int r)
    {
        if(l==r) {pandigital();return;}
        int i;
        for(i=l;i<=r;i++)
        {
            swap(i,l);
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
        int n = a.length;
        int i,j;
        long x = 0, y = 0, z = 0;
        for(i=1;i<=n-2;i++)
        {
            for(j=1;j<=n-1;j++)
            {
                int k = n-i-j;
                if(k>0)
                {
                    x = y = z = 0;
                    int l = 0;
                    while (l<i)
                    {
                        x = x*10+a[l];
                        l++;
                    }
                    while(l<i+j)
                    {
                        y = y*10+a[l];
                        l++;
                    }
                    while (l<n)
                    {
                        z = z*10+a[l];
                        l++;
                    }

                    if(x*y==z) {
                        //System.out.println(x+" "+y+" "+z);
                        if(!vis[(int)z])
                        {
                            count+=z;
                            vis[(int)z] = true;
                        }

                    }
                }
            }
        }
    }
}