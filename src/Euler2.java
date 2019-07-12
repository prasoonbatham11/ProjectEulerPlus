import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Euler2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        long f[]=new long[1000050];f[1]=1;f[2]=2;
        int t=s.nextInt(),i;
        for(i=3;i<f.length;i++) {f[i]=f[i-1]+f[i-2];}
        
        long sum,n;
        while(t-->0)
            {
            sum=0;
            n=s.nextLong();
            for(i=2;;i+=3)
                {
                if(f[i]<=n) sum+=f[i];
                else break;
            }
            System.out.println(sum);
        }
        
    }
}