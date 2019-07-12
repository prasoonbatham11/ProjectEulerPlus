import java.io.*;
import java.util.*;

public class Euler9 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt(),n,a,b,c;
        long abc,x;
        
        while(t-->0) {
            n=s.nextInt();
            abc=-1;
            for(a=1;a<n;a++) {
                b=(n*n-2*a*n)/(2*n-2*a);
                c=n-a-b;
                if(b>0 && c>0 && a*a+b*b==c*c && a+b+c==n) {x=a*b*c; if(x>abc) abc=x;} 
            }
            System.out.println(abc);
        }
    }
}