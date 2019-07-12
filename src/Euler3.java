import java.io.*;
import java.util.*;

public class Euler3 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int t;
        long n,l=1,i;
        t=s.nextInt();
        
        while(t-->0)
            {
            n=s.nextLong();
            
            while(n%2==0) {n/=2;l=2;}
            for(i=3;i*i<=n;i+=2) {while(n%i==0) {n/=i;l=i;}}
            if(n>1) l=n;
            System.out.println(l);
        }
        
    }
}