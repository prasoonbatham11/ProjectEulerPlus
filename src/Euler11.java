import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Euler11 {
    public static void main(String args[]) {
        int i, j;
        long a[][] = new long[20][20];
        Scanner s = new Scanner(System.in);
        for(i=0;i<20;i++) for(j=0;j<20;j++) a[i][j] = s.nextLong();
        long mul = 0, max = 0;
        
        for(i=0;i<20;i++)
            for(j=0;j<20;j++)
            {    
                if(v(j+3)) {mul = a[i][j] * a[i][j+1] * a[i][j+2] * a[i][j+3]; if(mul>max) max = mul;}
                if(v(j-3)) {mul = a[i][j] * a[i][j-1] * a[i][j-2] * a[i][j-3]; if(mul>max) max = mul;}
                if(v(i+3)) {mul = a[i][j] * a[i+1][j] * a[i+2][j] * a[i+3][j]; if(mul>max) max = mul;}
                if(v(i-3)) {mul = a[i][j] * a[i-1][j] * a[i-2][j] * a[i-3][j]; if(mul>max) max = mul;}
                if(v(i+3) && v(j+3)) {mul = a[i][j] * a[i+1][j+1] * a[i+2][j+2] * a[i+3][j+3]; if(mul>max) max = mul;}
                if(v(i+3) && v(j-3)) {mul = a[i][j] * a[i+1][j-1] * a[i+2][j-2] * a[i+3][j-3]; if(mul>max) max = mul;}
                if(v(i-3) && v(j+3)) {mul = a[i][j] * a[i-1][j+1] * a[i-2][j+2] * a[i-3][j+3]; if(mul>max) max = mul;}
                if(v(i-3) && v(j-3)) {mul = a[i][j] * a[i-1][j-1] * a[i-2][j-2] * a[i-3][j-3]; if(mul>max) max = mul;}
            }
        System.out.println(max);
    }
    public static boolean v(int a) {return a<20 && a>=0;}
}