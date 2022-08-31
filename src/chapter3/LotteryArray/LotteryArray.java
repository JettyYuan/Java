/* This program demonstrates a triangular array.
 * @Author: Jetty 
 * @Date: 2022-08-30 21:59:01 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-30 22:20:19
 */
package chapter3.LotteryArray;

public class LotteryArray {
    public static void main(String[] args) {
        final int NMAX = 10;
        // 三角二维数组
        int[][] odds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; n++) {
            odds[n] = new int[n + 1];
        }
        // 初始化
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++) {
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                }
                odds[n][k] = lotteryOdds;
            }
        }
        // 格式化输出二维数组
        // 数组
        for (int[] row : odds) {
            // 数组的数组
            for (int odd : row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }
}
