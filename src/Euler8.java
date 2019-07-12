import java.io.*;
import java.util.*;

public class Euler8 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt(),n,k,i,j;
        long pro,max;
        String x;
        while(t-->0)
            {
            n=s.nextInt();k=s.nextInt();
            x=s.next();
            pro=1;
            for(i=0;i<k;i++) pro*=(x.charAt(i)-'0');
            max=pro;
            for(i=1;i<=n-k;i++) 
                {
                pro=1;
                for(j=i;j<i+k;j++) pro*=(x.charAt(j)-'0'); if(pro>max) max=pro;
            }
            System.out.println(max);
        }
    }
}