/* @(#)Euler159.java
 */
/**
 *@author <a href="mailto:prasoonbatham@gmail.com">Prasoon Batham</a>
 */

import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
class Euler159
{
    static Set<String> s;
    static long MOD = 1000000007;
    public static void main(String args[])throws Exception
    {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
        FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i,j;
        int md[] = new int[10000001];
        for(i=2;i<md.length;i++) md[i] = dr(i);
        for(i=2;i<=3200;i++) for(j=2;i*j<md.length;j++) if(md[i*j]<md[i]+md[j]) md[i*j] = md[i]+md[j];
        for(i=3;i<md.length;i++) md[i] = md[i]+md[i-1];
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(md[n]);
        }

        out.flush();
    }
    public static int dr(int n) {
        return ((n-1)%9)+1;
    }
}