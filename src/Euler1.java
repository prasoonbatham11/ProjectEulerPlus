import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Euler1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        long n,sum;
        while(t-->0)
            {
            n=s.nextLong();
            n--;
            sum=3*(((n/3)*(n/3+1))/2)+5*(((n/5)*(n/5+1))/2)-15*(((n/15)*(n/15+1))/2);
            
            System.out.println(sum);
        }
    }
}