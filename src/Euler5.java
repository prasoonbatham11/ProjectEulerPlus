import java.io.*;
import java.util.*;

public class Euler5 {

    public static void main(String[] args) {
        /* Enter your codehere. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        long a[]=new long[45];int i,t,n;a[1]=1;
        long lcm=1,hcf=1;
        
        for(i=2;i<=40;i++) {
            hcf=gcd(i,lcm);
            lcm=(i*lcm)/hcf;
            a[i]=lcm;
        }
        //System.out.println(Arrays.toString(a));
        
        t=s.nextInt();
        while(t-->0)
            {
            n=s.nextInt();
            System.out.println(a[n]);
        }
        
    }
    
    public static long gcd(long a,long b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}