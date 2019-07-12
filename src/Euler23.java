import java.util.*;
import java.io.*;
public class Euler23
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        boolean check[]=new boolean[28130];
        int i,j,count;
        int sq;
        for(i=1;i<=28126;i++)
        {
            sq=(int)Math.sqrt(i);
            count=1;
            for(j=2;j*j<=i;j++)
            {
                if(i%j==0) count+=j+i/j;
            }
            if(sq*sq==i) count-=sq;
            check[i]=count>i?true:false;
        }
        
        int n;
        
        while(t-->0)
        {
            n=Integer.parseInt(br.readLine());
            if(n>28123) System.out.println("YES");
            else
            {
                int flag=0;
                for(i=1;i<=n/2;i++)
                {
                    if(check[i]&& check[n-i]) {System.out.println("YES");flag=1;break;}
                }
                if(flag==0) System.out.println("NO");
            }
        }
    }
}