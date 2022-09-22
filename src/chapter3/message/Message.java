/* args
 * @Author: Jetty 
 * @Date: 2022-08-30 20:17:48 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-30 20:21:35
 */
package chapter3.message;

public class Message {
    public static void main(String[] args){
        if (args.length == 0 || args[0].equals("-h")){
            System.out.print("Hello,");
        }
        else if (args[0].equals("-g")){
            System.out.print("Goodbye,");
        }
        for (int i = 1; i < args.length; i++){
            System.out.print(" " + args[i]);
        }
        System.out.println("!");
    }
}
