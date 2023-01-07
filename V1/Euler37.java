import java.io.*;
import java.util.*;

public class Euler37 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        boolean seive[] = new boolean[1000000];Arrays.fill(seive,true); seive[0] = seive[1] = false;
        int p,j;
        for(p=2;p*p<seive.length;p++) if(seive[p]) for(j=p*p;j<seive.length;j+=p) seive[j] = false;
            boolean trun[] = new boolean[1000000]; Arrays.fill(trun, true);
        for(p=0;p<=10;p++) trun[p] = false;
        
        for(p=11;p<seive.length;p++) {
            
            if(seive[p]) {
                //System.out.print(p+" ");
                j = p;
                int c = 1;
                while(j>0) {
                    //System.out.print(j+" ");
                    if(!seive[j]) trun[p] = false;
                    j = j/10;c = c*10;
                    
                }
                c/=10;
                j = p;
                //System.out.print("c["+c+"] ");
                while(j>0) {
                    //System.out.print(j+" ");
                    if(!seive[j]) trun[p] = false;
                    j = j%c;
                    c/=10;
                }
                //System.out.println();
            }
            else trun[p] = false;
        }
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long sum = 0;
        for(p=23;p<n;p++) if(trun[p]) {sum+=p;}
            System.out.println(sum);
        
    }
}