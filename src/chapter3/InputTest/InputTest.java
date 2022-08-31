/* This program demonstrates console input
 * @Author: Jetty 
 * @Date: 2022-08-25 10:21:59 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-25 12:04:46
 */
package chapter3.InputTest;

import java.util.*;

public class InputTest {
    public static void main(String[] args){
        // 定义了一个输入对象同时也要有语句调用方法 close() 关闭对象
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = in.nextLine();
        System.out.print("How old are you? ");
        int age = in.nextInt();
        String message = String.format("Hello, %s. Next year, you'll be %d", name, (age + 1));
        // System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
        // System.out.printf("Hello, %s. Next year, you'll be %d", name, (age + 1));
        // System.out.println();
        System.out.println(message);
        in.close();
    }
}
