import java.io.*;
import java.util.*;

public class Euler38 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int i = 2,j;
        String str;
        for(i = 2;i<n;i++) {
            str = "";
            for(j=1;;j++) {
                str += (i*j);
                if(str.length()>k) break;
                else if(str.length()==k && pandigital(str,k)) System.out.println(i);
            }
        }
    }
    public static boolean pandigital(String s, int k) {
        int a[] = new int[k+1];
        int n = s.length();
        int i;
        for(i=0;i<n;i++) {
            if(s.charAt(i)-'0' == 0) return false;
            else if(s.charAt(i)-'0' > k) return false;
                else
            a[s.charAt(i)-'0']++;
        }
        for(i=1;i<=k;i++) if(a[i]!=1) return false;
            return true;
    }
}