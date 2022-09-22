/* This program demonstrates a <code>while</code> loop
 * @Author: Jetty 
 * @Date: 2022-08-25 17:15:25 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-25 17:26:10
 */
package chapter3.retirement;

import java.util.Scanner;

public class Retirement {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("How much money do you need to retire? ");
        double goal = in.nextDouble();
        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();
        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();
        in.close();
        double balance = 0;
        int years = 0;
        // 计算 years
        while (balance < goal){
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }
        System.out.println("You can retire in " + years + " years.");
    }
}
