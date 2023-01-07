import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
public class Euler31
{
    final static int mod = 1000000007;
    static int money[] = {0,1,2,5,10,20,50,100,200};
    static int dp[][];
	public static void main(String args[])throws Exception
	{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//the code goes here
        dp = new int[100001][9];

        int i, j;
        for(i=0;i<=8;i++) dp[0][i] = 1;

        for(i=1;i<=100000;i++)
        {
            for(j=1;j<=8;j++)
            {
                if(i-money[j]>=0)
                    dp[i][j] = (dp[i][j]+dp[i-money[j]][j])%mod;
                dp[i][j]=(dp[i][j]+dp[i][j-1])%mod;
            }
        }

        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            System.out.println(dp[n][8]);
        }

	}
	public static int solve(int n, int i)
    {
        if(n<0) return 0;
        if(i==8 && n>0) return 0;
        if(n==0) return 1;
        if(dp[n][i] != -1) return dp[n][i];
        return dp[n][i] = ((solve(n, i+1)%mod)+(solve(n-money[i], i)%mod))%mod;
    }
}
