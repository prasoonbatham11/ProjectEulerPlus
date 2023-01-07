import java.io.*;
import java.util.*;

public class Euler21
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int al[]=new int[500001];
        int t=Integer.parseInt(br.readLine());
        int n,i;
        long sum;
        int a,b,c;
        //int i;
        for(i=1;i<=500000;i++)
            {
            al[i] = d(i);
        }
        //System.out.println(al[220]+" "+al[284]);
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            //Arrays.fill(al,0);
            sum=0;
            for(i=1;i<n;i++)
            {
                
                
                if(i!=al[i] && al[al[i]]==i)
                    {
                       // System.out.println(i+" "+al[i]+" "+al[al[i]]);
                    sum+=i;
                    //if(al[i]<n) sum+=al[i];
                }
                    
                
            }
            System.out.println(sum);
        }
    }
    public static int d(int a)
    {
        int i=1,sum=1;
        int b = (int)Math.sqrt(a);
        for(i=2;i<=b;i++) if(a%i==0 && i!=a/i) sum+=i+a/i; else if(a%i==0 && i==a/i) sum+=i; 
        return sum;
    }
}