import java.util.*;
public class Euler18
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt(),n,i,j;
        int a[][]=new int[15][15];
        while(t-->0)
        {
            n=s.nextInt();
            for(i=0;i<n;i++)
                for(j=0;j<=i;j++)
                    a[i][j]=s.nextInt();
            System.out.println(maximum(a,0,0,n));
        }
    }
    public static int maximum(int a[][],int i,int j,int n)
    {
        if(i==n-1) return a[i][j];
        return a[i][j]+Math.max(maximum(a,i+1,j,n),maximum(a,i+1,j+1,n));
    }
}
