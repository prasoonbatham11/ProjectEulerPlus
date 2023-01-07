import java.io.*;
import java.util.*;

public class Euler34 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        long fact[] = new long[10];
        fact[0] = 1;
        int i;
        for(i=1;i<10;i++) fact[i] = i*fact[i-1];
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long k = 0;
        for(i=10;i<n;i++)
            {
            int j = i;
            long sum = 0;
            while(j>0)
                {
                sum+=fact[j%10];
                j/=10;
            }
            if(sum%i==0) k+=i;
        }
        System.out.println(k);
    }
}