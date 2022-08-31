/* This program displays a greeting for the reader
 * @Author: Jetty 
 * @Date: 2022-08-24 21:59:33 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-25 11:55:36
 */
package chapter2.Welcome;

public class Welcome {
    public static void main(String[] args){
        String greeting = "Welcome to Core Java!"; // greeting
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); ++i){
            System.out.print("=");
        }
        System.out.println();
    }
}