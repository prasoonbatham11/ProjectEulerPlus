import java.io.*;
import java.util.*;

public class Euler26 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] lon = get();
        while(t-->0) {
            int n = sc.nextInt();
            System.out.println(lon[n-1]);
        }
    }
    public static int[] get() {
        int[] lon = new int[10001];
        int[] val = new int[10001];

        int vis[] = new int[10001];
        lon[3] = 3; val[3] = 1;
        for(int i=4;i<=10000;i++) {
            Arrays.fill(vis, 0);
            int value = 1;
            int count = 0;
            while(vis[value]==0 && value != 0) {
                vis[value] = count;
                value *= 10;
                value %= i;
                count++;
            }
            if (value == 0) count = 0;
            else val[i] = count - vis[value];
            if(val[i] > val[lon[i-1]]) lon[i] = i;
            else lon[i] = lon[i-1];
        }

        //System.out.println(Arrays.toString(val).substring(0, 40));
        return lon;
    }
}
