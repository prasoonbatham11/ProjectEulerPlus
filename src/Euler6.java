import java.io.*;
import java.math.*;
import java.util.*;

public class Euler6 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        BigInteger n,x,twelve=new BigInteger("12"),two=new BigInteger("2"),three=new BigInteger("3"),ab;
        while(t-->0) {
            n=s.nextBigInteger();
            x=three.multiply(n.multiply(n)).subtract(n.add(two));
            ab=n.multiply(n.add(BigInteger.ONE)).multiply(x).divide(twelve);
            System.out.println(ab);
        }
    }
}