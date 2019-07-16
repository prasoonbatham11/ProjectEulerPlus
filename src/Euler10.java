import java.io.*;
import java.util.*;

public class Euler10 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        boolean seive[]=new boolean[2000005];Arrays.fill(seive,true);seive[0]=seive[1]=false;
        int p,j=0,i,flag,n;
        int prime[]=new int[2000000];
        long sum;
        for(p=2;p*p<seive.length;p++) if(seive[p]) for(j=p*p;j<seive.length;j+=p) seive[j]=false;
            j=0;
        for(i=2;i<seive.length;i++) if(seive[i]) prime[j++]=i;
        //for(i=1001;i<1000000;i++) {flag=0; for(p=0;p<j;p++) if(i%prime[p]==0) {flag=1;break;} if(flag==0) {prime[j++]=i;}}
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0) {
            n=s.nextInt();
            sum=0;
            for(i=0;i<j;i++) if(prime[i]>n) break; else sum+=prime[i];
            System.out.println(sum);
        }
    }
}