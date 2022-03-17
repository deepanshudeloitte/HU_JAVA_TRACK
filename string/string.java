package string;
import java.io.*;
import java.util.*;
import java.lang.*;
public class string {
    static boolean isInterleaved(String A, String B,String C){

        int m = A.length(), n = B.length();

        boolean b[][] = new boolean[m + 1][n + 1];
        if ((m + n) != C.length())
            return false;

        for(int i = 0; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if (i == 0 && j == 0)
                    b[i][j] = true;

                else if (i == 0)
                {
                    if (B.charAt(j - 1) ==
                            C.charAt(j - 1))
                        b[i][j] = b[i][j - 1];
                }


                else if (j == 0)
                {
                    if (A.charAt(i - 1) == C.charAt(i - 1))
                        b[i][j] = b[i - 1][j];
                }


                else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1))
                    b[i][j] = b[i - 1][j];


                else if (A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1))
                    b[i][j] = b[i][j - 1];
                else if (A.charAt(i - 1) ==
                        C.charAt(i + j - 1) &&
                        B.charAt(j - 1) ==
                                C.charAt(i + j - 1))
                    b[i][j] = (b[i - 1][j] ||
                            b[i][j - 1]);
            }
        }
        return b[m][n];
    }


    static void test(String A, String B, String C)
    {
        if (isInterleaved(A, B, C))
            System.out.println("Valid Shuffle");
        else
            System.out.println("Invalid Shuffle");
    }


    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        String a =scn.nextLine();
        String b =scn.nextLine();
        String c=scn.nextLine();

        test(a,b,c);
    }
}
