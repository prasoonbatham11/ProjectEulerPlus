import java.util.*;
public class Euler15
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int i,j,C[][]=new int[1001][1001],mod=1000000007;
        for(i=0;i<=1000;i++) for(j=0;j<=1000;j++) C[i][j]=0;
        for(i=1;i<=1000;i++) {C[i][1]=i;C[i][0]=1;C[i][i]=1;}
        for(i=1;i<=1000;i++)
        {
            for(j=2;j<i;j++)
            {
                    C[i][j]=(C[i-1][j-1]%mod+C[i-1][j]%mod)%mod;
            }
        }
        //for(i=0;i<=1000;i++) {for(j=0;j<=1000;j++) System.out.print(C[i][j]+" ");System.out.println();}
        int t=s.nextInt(),n,m;
        while(t-->0)
        {
            n=s.nextInt();m=s.nextInt();
            n++;m++;
            System.out.println(C[n+m-2][n-1]);
        }
    }
}