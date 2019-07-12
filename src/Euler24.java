import java.io.*;
import java.util.*;

public class Euler24 {

    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        char a[] = new char[13];
        int t;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        long fact[] = new long[13];
        int j;
        fact[0] = 1;
        for(j=1;j<=12;j++) fact[j] = j*fact[j-1];
        String str;
        while(t-->0)
            {
            long n = s.nextLong()-1;
            long tex = n;
            int i;
            for(i=0;i<13;i++) a[i] = (char)('a'+i);
            long k;
            int m;
            str = "";
            for(i=13;i>=3;i--)
                {
                k = fact[i-1];
                m = (int)(n/k);
                n=n%k;
                str = str+a[m];
                
                for(j=m+1;j<13;j++) a[j-1] = a[j];
                //System.out.println(str+Arrays.toString(a));
                
            }
            if(tex%2==0) str+=a[0]+""+a[1];
            else str+=a[1]+""+a[0];
            
            System.out.println(str);
        }
    }
}