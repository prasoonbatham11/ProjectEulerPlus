import java.io.*;
import java.util.*;

public class Euler35 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        boolean seive[] = new boolean[1000000];
        Arrays.fill(seive,true);seive[0]=seive[1]=false;
        int p,j;
        for(p=2;p*p<1000000;p++) if(seive[p]) for(j=p*p;j<1000000;j+=p) seive[j] = false;
        
        boolean isrot[] = new boolean[1000000]; Arrays.fill(isrot, false);
        for(p=2;p<=7;p++) if(seive[p]) isrot[p] = true;
        for(p=11;p<1000000;p++)
            {
            if(seive[p])
                {
                j=p;
                int c = 0;
                int f = 0;
                int d;
                
                while(j>0) {d = j%10; if(d%2==0) f=1; j/=10;c++;}
                j=p;
                if(f==0) {
                for(int k=1;k<c;k++)
                    {
                        d = j%10;j/=10;
                    j=j + (int)(d*Math.pow(10,c-1));
                    if(!seive[j]) f = 1;
                }
                    if(f==0) {isrot[p] = true;}}
            }
        }
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long sum = 0;
        for(p=2;p<n;p++) {
            if(isrot[p]) sum+=p;
        }
        System.out.println(sum);
    }
}