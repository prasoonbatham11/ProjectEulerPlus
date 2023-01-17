import java.util.*;
import java.io.*;

/*
*   To run HackerRank PE+ solution run:
*   javac EulerNNN.java && java EulerNNN
*
*   To run projecteuler.net solution run:
*   javac EulerNNN.java && java EulerNNN 1
*/

class Euler081 {
    
    public static void main(String[] args) {
        if (args.length==0) {
            solveHR();
        }
        else {
            solvePE();
        }
    }

    public static void solveHR() {
        Scanner s = new Scanner(System.in);
        int n,i,j;
        n = s.nextInt();
        long p[][] = new long[n][n];
        long a[][] = new long[n][n];
        for(i=0;i<n;i++) 
            for(j=0;j<n;j++) {
                p[i][j] = s.nextLong();
                a[i][j] = -1;
            }
        a[n-1][n-1] = p[n-1][n-1];
        for(i=n-2;i>=0;i--) a[n-1][i] = p[n-1][i]+a[n-1][i+1];
        System.out.println(solve(p, a, n, 0, 0));
        s.close();
    }

    public static void solvePE() {
        int n = 80;
        long p[][] = new long[n][n];
        long a[][] = new long[n][n];
        int i,j;
        try {
            File file = new File("Euler081.txt");
            Scanner s = new Scanner(file);
            i = 0;
            while(s.hasNextLine()) {
                String data = s.nextLine();
                String arr[] = data.split(",");
                for(j=0;j<n;j++) p[i][j] = Integer.parseInt(arr[j]);
                i++;
            }
            s.close();
            /*for(i=0;i<n;i++) {
                for(j=0;j<n;j++) {
                    System.out.print(p[i][j]+" ");
                }
                System.out.println();
            }*/
            for(i=0;i<n;i++) for(j=0;j<n;j++) a[i][j] = -1;
            a[n-1][n-1] = p[n-1][n-1];
            for(i=n-2;i>=0;i--) a[n-1][i] = p[n-1][i]+a[n-1][i+1];
            System.out.println(solve(p, a, n, 0, 0));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        


    }

    public static long solve(long p[][], long a[][], int n, int i, int j) {
        if(i<0 || i>=n || j<0 || j>=n) return Long.MAX_VALUE;
        if(a[i][j]!=-1) return a[i][j];
        a[i][j] = p[i][j]+Math.min(
            solve(p,a,n,i+1, j),
            solve(p,a,n,i,j+1)
        );
        return a[i][j];
    }
   
    

}
