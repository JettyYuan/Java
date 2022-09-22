/* This program demonstrates a <code>for</code> loop.
 * @Author: Jetty 
 * @Date: 2022-08-28 20:08:12 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-28 20:32:55
 */
package chapter3.lotteryodds;

import java.util.Scanner;

public class LotteryOdds {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();
        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();
        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++){
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
        }
        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
        in.close();
    }
}
