import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Euler19 {

    static int month[] = {31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s= new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0) {
            long y1 = s.nextLong(), m1 = s.nextLong(), d1 = s.nextLong();
            long y2 = s.nextLong(), m2 = s.nextLong(), d2 = s.nextLong();
            if(d1!=1)
            {
                if(m1<12) m1++;
                else {m1 = 1; y1++;}
            }
            int sun = 0;
            if(y2==y1)
            {
                for(long i = m1;i<=m2;i++)
                {
                    if(current(y1,i,1)==7) sun++;
                }
            }
            else if(y1<y2)
            {
                for(long i = m1;i<=12;i++) if(current(y1,i,1)==7) sun++;
                for(long i = y1+1;i<=y2-1;i++)
                {
                    for(long j = 1;j<=12;j++) if(current(i,j,1)==7) sun++;
                }
                for(long i=1;i<=m2;i++) if(current(y2,i,1)==7) sun++;
            }
            System.out.println(sun);
            /*long n = (y2-y1)*365 + d2-d1;
            int i;
            System.out.println(y1+" "+m1+" "+d1);            
            System.out.println(y2+" "+m2+" "+d2);
            for(i=0;i<m1-1;i++) n-=month[i];
            for(i=0;i<m2-1;i++) n+=month[i];
            n = n + count(y2,m2) - count(y1,m1)+1;
            System.out.println(n);*/
            
            //long c = current(y1,m1,d1);
            //System.out.println(c);
            //long sun = n/7;
            //n = n%7;
            //if(n>=8-c) sun++;
            //System.out.println(sun);
            
            
            
        }
        
    }
    public static long count(long y, long m)
        {
        if(m<=2) y--;
        return y/4 - y/100 +y/400;
    }
    
    public static long current(long y, long m, long d)
    {
        if(m==1 || m==2) {m+=12;y--;}
        long j = y/100;
        y = y%100;
        long h = ( d+ ((13*(m+1))/5) + (y%7 + ((y/4)%7 + (j/4)%7)%7)%7 + (5*(j%7)) )%7;
        if(h>=2 && h<=6) h-=1;
        else h+=6;
        return h;
        //return h;
    }
}