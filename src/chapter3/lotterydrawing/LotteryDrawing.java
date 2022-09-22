/* This program demonstrates array manipulation
 * @Author: Jetty 
 * @Date: 2022-08-30 20:29:51 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-30 20:41:51
 */
package chapter3.lotterydrawing;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();
        // 初始化数组
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = i + 1;
        }
        // 随机抽取数组中的数并存放在另一个数组
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++){
            int r = (int) (Math.random() * n);
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }
        // 对数组中的数进行排序并输出
        Arrays.sort(result);
        System.out.println("Bet the following combination. It'll make you rich!");
        for (int r : result){
            System.out.println(r);
        }

        in.close();
    }
}
