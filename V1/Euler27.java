import java.util.*;
import java.io.*;
public class Euler27
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        
        //SEIVE
        boolean seive[] = new boolean[1000000];Arrays.fill(seive,true);seive[0]=seive[1]=false;
        int p,j;
        for(p=2;p*p<1000000;p++) if(seive[p]) for(j=p*p;j<1000000;j+=p) seive[j]=false;
        
   
        int i,b=0,a=0,c,x,q=-100000,r=-100000,count=0,max=-100000;
        for(b=-n;b<=n;b++)
        {
               
            x=b;if(b<0) x=-x;
            if(seive[x])
            for(a=-n;a<=n;a++)
            {
                   
                    count=0;
                    for(i=0;;i++)
                    {
                        c=i*i+a*i+b;
                        if(c<0) c=-c;
                        if(!seive[c]) 
                        {
                            //System.out.println("break at a= b= c= i= "+a+" "+b+" "+c+" "+i);
                            break;
                        }
                        count++;
                        //System.out.println("a= b= c= i= count= "+a+" "+b+" "+c+" "+i+" "+count);
                    }
                    if(count>max) {max=count;q=a;r=b;}
            }
            
                    //System.out.println("************************************************************************************");
            
        }
        System.out.println(q+" "+r);
    }
}