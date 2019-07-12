import java.io.*;
import java.util.*;

public class Euler42 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0) {
            long k = s.nextLong();
            long n = (long)Math.sqrt(2*k);
            long i = -1;
            if(tr(n)==k) i = n;
            else if(tr(n-1)==k) i = n-1;
                else if(tr(n+1)==k) i = n+1;
                System.out.println(i);
        }
    }
    public static long tr(long n) {
        return (n*(n+1))/2;
    }
    
}