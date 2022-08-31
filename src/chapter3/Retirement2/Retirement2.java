/* This program demonstrates a <code>do/while</code> loop
 * @Author: Jetty 
 * @Date: 2022-08-25 17:29:07 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-25 17:58:28
 */
package chapter3.Retirement2;

import java.util.*;

public class Retirement2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();
        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();
        double balance = 0;
        int year = 0;
        String input;
        // 计算 year 后的大小
        do{
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            year++;
            System.out.printf("After year %d, your balance is %,.2f%n", year,balance);
            System.out.print("Ready to retire? (Y/N) ");
            input = in.next();
        }while (input.equals("N"));
        in.close();
    }
}
