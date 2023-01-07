import java.util.*;
import java.io.*;
public class Euler22
{
    public static void main(String args[])throws IOException
    {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine()),i,l,j;
        int[] a = new int[n];
        Arrays.fill(a,0);
        String[] name = new String[n];
        for(i=0;i<n;i++) name[i] = b.readLine();
        Arrays.sort(name);
        
        for(i=0;i<n;i++)
        {
            l=name[i].length();
            for(j=0;j<l;j++)
            {
                a[i]+=name[i].charAt(j)-'A'+1;
            }
            a[i]=a[i]*(i+1);
        }
        
        int q = Integer.parseInt(b.readLine());
        String que;
        for(i=1;i<=q;i++)
        {
            que = b.readLine();
            System.out.println(a[binarySearch(name, que)]);
        }
    }
    public static int binarySearch(String[] a,String k)
    {
        int l=0,u=a.length-1,m=(l+u)/2,f=0;
        while(l<=u)
        {
            m=(l+u)/2;
            if(a[m].compareTo(k)>0)
            u=m-1;
            if(a[m].compareTo(k)<0)
            l=m+1;
            if(a[m].compareTo(k)==0)
            {
                f=1;
                break;
            }
        }
        if(f==1)
        return m;
        return -1;
    }
}