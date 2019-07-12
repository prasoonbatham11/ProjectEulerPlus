import java.util.*;
import java.io.*;
public class Euler14
{
    public static final int MAX = 5000001;
    public static void main(String args[])
    {
        long a[] = new long[MAX];a[0]=0;a[1]=1;
        long i,j;
        for(i=2;i<MAX;i++)
        {
            if(i%2==0) a[(int)i] = a[(int)(i/2)]+1;
            else
            {
                a[(int)i]=1;
                j = 3*i+1;
                while(j>i)
                {
                    if(j%2==0) j/=2;
                    else j = 3*j+1;
                    a[(int)i]++;
                }
                a[(int)i] += a[(int)j];
            }
        }
        
        //for(i=0;i<10;i++) System.out.print(a[(int)i]+ " ");
        
        int max[] = new int[MAX];
        long p = 1; max[1] = 1;
        
        for(i=2;i<MAX;i++)
        {
            if(a[(int)i]>=a[(int)p]) {max[(int)i] = (int)i;p=i;}
            else max[(int)i] = max[(int)i-1];
        }
        //for(i=0;i<10;i++) System.out.print(max[(int)i]+ " ");
        
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int n;
        while(t-->0)
        {
            n = s.nextInt();
            System.out.println(max[n]);
        }
    }
}