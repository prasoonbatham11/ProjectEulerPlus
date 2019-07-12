import java.util.*;
public class Euler12
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        boolean seive[]=new boolean[1005];Arrays.fill(seive,true);seive[0]=seive[1]=false;
        int prime[]=new int[200];
        int p,j,k=0;
        for(p=2;p*p<=1000;p++)
        {
            if(seive[p])
            {
                for(j=p*p;j<=1000;j+=p)
                {
                    seive[j]=false;
                }
            }
        }
        
        for(j=2;j<=1000;j++)
            if(seive[j]) prime[k++]=j;
            
        long i,m;
        long a[]=new long[1000004];
        int div[]=new int[1000004];
        int c,pro;
        for(i=1;i<=1000000;i++)
        {
            a[(int)i]=(i*(i+1))/2;
            m=a[(int)i];
            pro=1;
            for(j=0;j<k;j++)
            {
                c=0;
                while(m%prime[j]==0)
                {m/=prime[j];c++;}
                pro*=(c+1);
            }
            if(m>1) pro*=2;
            div[(int)i]=pro;
        }
            
        int t=s.nextInt(),n;
        
        
        while(t-->0)
        {
            n=s.nextInt();
            for(j=1;j<=1000000;j++)
            {
                if(div[j]>n)
                break;
            }
            System.out.println(a[j]);
        }
    }
}
       