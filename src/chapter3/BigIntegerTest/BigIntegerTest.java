/* This program uses big numbers to compute the odds of winning the grand prize in a lottery.
 * @Author: Jetty 
 * @Date: 2022-08-28 20:31:03 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-28 20:39:45
 */
package chapter3.BigIntegerTest;

import java.math.*;
import java.util.*;

public class BigIntegerTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();
        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();
        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for (int i = 1; i <= k; i++){
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        }
        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
        in.close();
    }
}
