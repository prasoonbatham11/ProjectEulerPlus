import java.io.*;
import java.util.*;

public class Euler36 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(),k = s.nextInt();
        
        boolean palin[] = new boolean[1000000];
        Arrays.fill(palin, false);
        int i,j,a,b,c,d;
        for(i=0;i<palin.length;i++)
        {
            j = i; a = 0;
            while(j>0)
            {
                a = a*10+j%10;
                j/=10;
            }
            if(a==i) palin[i] = true;
        }
        String p;
        for(i=1;i<palin.length;i++)
        {
            if(palin[i])
            {
                j = i; p = "";
                while(j>0)
                {
                    a = j%k;
                    p = a + p;
                    j/=k;
                }
                b = p.length();
                for(c = 0;c<=b/2;c++) if(p.charAt(c)!=p.charAt(b-1-c)) {palin[i] = false; break;}
            }
        }
        long sum = 0;
        for(i=0;i<n;i++)
        {
            if(palin[i]) sum+=i;
        }
        System.out.println(sum);
    }
}