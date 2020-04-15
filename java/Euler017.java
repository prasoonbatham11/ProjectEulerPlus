import java.util.*;

/*
*   To run HackerRank PE+ solution run:
*   javac Euler017.java && java Euler001
*
*   To run projecteuler.net solution run:
*   javac Euler017.java && java Euler001 1
*/

public class Euler017 {

    static String w[];
    static String y[] = {"", "Thousand", "Million", "Billion", "Trillion"};

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
        int t = sc.nextInt();
        init();
        while(t-->0) {
            String s = sc.next();
            System.out.println(solve(s));
        }
        sc.close();
    }

    public static void solvePE() {
        init();
        int i = 1;
        int ans = 0;
        for(i=1;i<=1000;i++) {
            String s = solve(""+i);
            ans += countLetters(s);
        }
        ans -= 27;
        System.out.println(ans);
    }

    public static int countLetters(String s) {
        String temp[] = s.split(" ");
        int ans = 0;
        for(int i=0;i<temp.length;i++) {
            ans += temp[i].length();
            if(temp[i].equals("Hundred")) ans+=3; // British English adds an and after Hundred
        }
        return ans;
    }

    public static String solve(String s) {
        String ans = "";
        int len = s.length();
        int c = 0;
        while(len>0) {
            int fr = len-3;
            if(fr<0) fr =0;
            int to = len;
            //System.out.println("ehllof" +s);
            String in = getThreeDig(s.substring(fr, to));
            if(!in.equals("")) in = in +" "+y[c];
            ans =  in+" "+ans;
            c++;
            len -=3;
        }
        return getTrimmedOutput(ans);
    }

    public static String getTrimmedOutput(String s) {
        String temp[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<temp.length;i++) if(!temp[i].equals("")) sb.append(temp[i]+" ");
        return sb.toString().trim();
    }
    public static String getThreeDig(String s) {
        s = Integer.parseInt(s)+"";
        //System.out.println(s+" fds");
        int len = s.length();
        //System.out.println(len+" "+s);
        if(len == 1) return w[Integer.parseInt(s)];
        if(len == 2) {
            return getTwoDig(s);
        }
        else {
            return w[Integer.parseInt(s.charAt(0)+"")]+" "+w[100]+" "+getTwoDig(s.substring(1));
        }
    }
    public static String getTwoDig(String s) {
        int num = Integer.parseInt(s);
        //System.out.println(num);
        if(num<=20 || num%10==0) return w[num];
        return w[(num/10)*10] +" "+w[num%10]; 
    }
    public static void init() {
        w = new String[200];
        Arrays.fill(w, "");
        w[1] = "One"; w[2] = "Two"; w[3] = "Three"; w[4] = "Four"; w[5] = "Five";
        w[6] = "Six"; w[7] = "Seven"; w[8] = "Eight"; w[9] = "Nine"; w[10] = "Ten";
        w[11] = "Eleven"; w[12] = "Twelve"; w[13] = "Thirteen"; w[14] = "Fourteen"; 
        w[15] = "Fifteen";
        w[16] = "Sixteen"; w[17] = "Seventeen"; w[18] = "Eighteen"; w[19] = "Nineteen"; 
        w[20] = "Twenty"; w[30] = "Thirty"; w[40] = "Forty"; w[50] = "Fifty"; 
        w[60] = "Sixty"; w[70] = "Seventy"; w[80] = "Eighty"; w[90] = "Ninety";
        w[100] = "Hundred";
    }
}

