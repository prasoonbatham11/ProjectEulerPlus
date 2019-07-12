import java.io.*;
import java.util.*;

public class Euler13 
{
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),i,c=0,k=99,j,t;
        String a[]=new String[n];
        int sum[]=new int[100];
        for(i=0;i<n;i++) a[i]=s.next();
        //System.out.println(Arrays.toString(a));
        for(i=49;i>=0;i--)
        {
            sum[k]=c;
            for(j=0;j<n;j++)
            {
                sum[k]+=a[j].charAt(i)-'0';
            }
            t=sum[k]%10;
            c=(sum[k]-t)/10;
            sum[k]=t;
            k--;
        }
        while(c>0)
        {
            sum[k]=c%10;
            c/=10;
            k--;
        }
        for(i=k+1;i<=k+10;i++)
        System.out.print(sum[i]);
        System.out.println();
    }
}