import java.io.*;
import java.util.*;

public class Euler25 {

    public static void main(String[] args)throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        String fib[] = new String[10000];
        int i;
        fib[1] = "1";
        fib[2] = "1";
        /*for(i=3;i<fib.length;i++) {
            fib[i] = add(fib[i-1], fib[i-2]);
            //if(i<=50)
            //System.out.println(fib[i]);
        }*/
        int a[] = new int[5010];
        int b[] = new int[5010];

        double phi = (1+Math.sqrt(5))/2;
        double logphi = Math.log(phi);
        double x = Math.log(10);
        double y = Math.log(5)/2;

        b[1] = a[1] = 1;

        for(i=2;i<b.length;i++) b[i] = (int)Math.ceil((x*(i-1) + y)/logphi);

        int j=2;
        /*for(i=1;i<fib.length;i++)
        {
            if(fib[i].length()==j)
            {
                a[j++] = i;
                System.out.println(a[j-1] + " " + b[j-1] + " " +(b[j-1]-a[j-1]));
            }

        }*/

        //System.out.println(j-1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            System.out.println(b[n]);
        }




    }
    public static String add(String a, String b)
    {
        int na = a.length();
        int nb = b.length();
        int c = 0;
        int i=na-1, j=nb-1;
        StringBuilder sb = new StringBuilder();
        int x = 0;

        while(i>=0 && j>=0) {
            x = c+a.charAt(i)-'0' + b.charAt(j)-'0';
            c = x/10;
            x = x%10;
            sb.append(x);
            i--; j--;
        }
        while(i>=0)
        {
            x = c+a.charAt(i)-'0';;
            c = x/10;
            x = x%10;
            sb.append(x);
            i--;
        }
        while(j>=0)
        {
            x = c+b.charAt(j)-'0';
            c = x/10;
            x = x%10;
            sb.append(x);
            j--;
        }

        String ans = sb.toString();
        ans = reverse(ans);
        if(c>0) ans = c+ans;
        return ans;
    }

    public static String reverse(String str)
    {
        StringBuilder sb = new StringBuilder();
        int i;
        int n = str.length();

        for(i=n-1;i>=0;i--)
        {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}