import java.util.*;
public class Euler20
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int a[]=new int[5000];
        int k=4999,sum,c,n,i,j;
        
        while(t-->0)
        {
            n=s.nextInt();
            Arrays.fill(a,0);
            k=4999;
            a[k]=1;
            sum=0;c=0;
            for(i=1;i<=n;i++)
            {
                for(j=4999;j>=k;j--)
                {
                    a[j]=i*(a[j])+c;
                    c=a[j]/10;
                    a[j]=a[j]%10;
                    //System.out.println(Arrays.toString(a));
                }
                while(c>0)
                {
                    a[--k]=c%10;
                    c/=10;
                }
                //System.out.println(Arrays.toString(a));
                
            }
            
            for(j=k;j<a.length;j++)
                {sum+=a[j];}
                //System.out.println();
            System.out.println(sum);
        }
    }
}
            