import java.io.*;
import java.util.*;

public class Euler30 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long a = 100;
        long b = 600000;
        //System.out.println(a+" "+b);
        long i,j,k;
        long count = 0;
        long sum;
        for(i=a;i<=b;i++)
            {
            j = i;k=0;sum=0;
            while(j>0)
                {
                sum = sum + (int)Math.pow(j%10,n);
                j/=10;
            }
            if(sum==i) count+=i;
        }
        System.out.println(count);
    }
}