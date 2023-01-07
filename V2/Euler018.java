import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler018.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler018.java && java Euler001 1
*/

public class Euler018 {

    public static void main(String[] args) {
        if (args.length==0) {
            solveHR();
        }
        else {
            solvePE();
        }
    }

    public static void solveHR() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n, i, j;
        int[][] a = new int[15][15];
        while(t-->0) {
            n=sc.nextInt();
            for(i=0;i<n;i++)
                for(j=0;j<=i;j++)
                    a[i][j]=sc.nextInt();
            System.out.println(solve(a, 0, 0, n));
        }
        sc.close();
    }

    public static void solvePE() {
        int a[][] = new int[][]{
            {75},
            {95,64},
            {17, 47, 82},
            {18, 35, 87, 10},
            {20, 04, 82, 47, 65},
            {19, 01, 23, 75, 03, 34},
            {88, 02, 77, 73, 07, 63, 67},
            {99, 65, 04, 28, 06, 16, 70, 92},
            {41, 41, 26, 56, 83, 40, 80, 70, 33},
            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
            {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
            {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
            {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
            {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23}
        };
        System.out.println(solve(a, 0, 0, 15));
    }

    public static int solve(int a[][], int i, int j, int n) {
        if(i==n-1) return a[i][j];
        return a[i][j]+Math.max(solve(a,i+1,j,n),solve(a,i+1,j+1,n));
    }
}
