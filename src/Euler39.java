import java.util.*;
public class Euler39
{
    public static void main(String args[])
    {
        int a[] = new int[5000001];
        Arrays.fill(a,0);
        int m,n;
        int p,k;
        int i;
        for(m=2;m<=1200;m++)
        {
            for(n=1;n<m;n++)
            {
                if((m+n)%2!=0 && gcd(m,n)==1)
                {
                    p = 2*m*(m+n);
                    for(k=1;;k++)
                    {
                        if(k*p>5000000) break;
                        else a[k*p]++;
                    }
                }
            }
        }
        //for(i=0;i<=100;i++) System.out.println(i+" "+a[i]);
        int b[] = new int[5000001];
        b[0] = 0;
        for(i=1;i<b.length;i++)
        {
            if(a[i]>a[b[i-1]]) b[i] = i;
            else b[i] = b[i-1];
        }
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0)
        {
            int g = s.nextInt();
            System.out.println(b[g]);
        }
    }
    public static int gcd(int a, int b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}