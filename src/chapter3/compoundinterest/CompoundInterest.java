/* This program shows how to store tabular data in a 2D array
 * @Author: Jetty
 * @Date: 2022-08-30 20:54:33
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-30 21:50:03
 */
package chapter3.compoundinterest;

import java.util.Arrays;

public class CompoundInterest {
    public static void main(String[] args) {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;
        // 初始化一维数组
        double[] interestRate = new double[NRATES];
        for (int j = 0; j < interestRate.length; j++) {
            interestRate[j] = (STARTRATE + j) / 100.0;
        }
        // 初始化二维数组
        double[][] balances = new double[NYEARS][NRATES];
        Arrays.fill(balances[0], 10000);
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                double oldBalance = balances[i - 1][j];
                double interest = oldBalance * interestRate[j];
                balances[i][j] = oldBalance + interest;
            }
        }
        // 格式化输出一维数组
        for (double v : interestRate) {
            System.out.printf("%9.0f%%", 100 * v);
        }
        System.out.println();
        // 格式化输出二维数组
        // 数组
        for (double[] row : balances) {
            // 数组的数组
            for (double b : row) {
                System.out.printf("%10.2f", b);
            }
            System.out.println();
        }
    }
}
