import java.io.*;
import java.util.*;

public class Euler52 {

    static int[] v;
    public static void main(String[] args)throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tem[] = br.readLine().split(" ");

        long n = Long.parseLong(tem[0]);
        int k = Integer.parseInt(tem[1]);
        v = new int[10];

        boolean ipm = false;
        StringBuilder sb = new StringBuilder();
        for(long i = 2; i<=n;i++) {
            ipm = true;
            for(int j=2;j<=k;j++) {
                if(!checkSameDig(i, i*j)) {
                    ipm = false;break;
                }
            }
            if(ipm) {
                for(int j=1;j<=k;j++) sb.append(i*j+" ");
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }
    public static boolean checkSameDig(long a, long b) {
        Arrays.fill(v, 0);
        //System.out.println(a+" "+b);
        int x = 0;
        while(a>0) {
            x = (int)(a%10);
            v[x]++;
            a/=10;
        }
        while(b>0) {
            x = (int)(b%10);
            v[x]--;
            b/=10;
        }

        //System.out.println(Arrays.toString(v));
        x = 0;
        while(x<10) {
            if(v[x]!=0) return false;
            x++;
        }
        return true;
    }
}

