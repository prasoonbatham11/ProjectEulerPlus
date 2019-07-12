import java.io.*;
import java.util.*;

public class Euler4 {

    public static void main(String[] args) {
        int t,l,q=0,i,j,k,n;boolean flag;String p="";
        int a[]=new int[1000000];
        
        for(i=999;i>=100;i--)
            {
            for(j=i;j>=100;j--)
                {
                p=i*j+"";
                l=p.length();
                flag=true;
                for(k=0;k<=l/2;k++) if(p.charAt(k)!=p.charAt(l-k-1)) flag=false;
                
                if(flag) a[q++]=i*j;
            }
        }
        Arrays.sort(a,0,q);
        
       // System.out.println(Arrays.toString(a));
        
        Scanner s=new Scanner(System.in);
        t=s.nextInt();
        while(t-->0) {
            n=s.nextInt();
            k=q-1;
            while(true) {if(a[k]<n) break; k--;}
            System.out.println(a[k]);
        }
        
    }
}