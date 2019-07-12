import java.io.*;
import java.util.*;

public class Euler7 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        boolean seive[]=new boolean[700000];Arrays.fill(seive,true);seive[0]=seive[1]=false;
        int p,j,prime[]=new int[700000],i=1;
        for(p=2;p*p<700000;p++) if(seive[p]) {for(j=p*p;j<700000;j+=p) seive[j]=false;}
        for(j=2;j<700000;j++) if(seive[j]) prime[i++]=j;
        //System.out.println(Arrays.toString(prime));
        Scanner s=new Scanner(System.in);
        int t=s.nextInt(),n;
        while(t-->0) {
            n=s.nextInt();
            System.out.println(prime[n]);
        }
            
    }
}