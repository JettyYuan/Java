package chapter6.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * 这个程序演示了lambda表达式的使用
 *
 * @author Jetty
 * @version 18 2022-10-07
 */
public class LambdaTest {
    public static void main(String[] args) {
        var planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        // 按字典顺序排序
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        // 按字符串长度排序
        System.out.println("Sorted by length:");
        Arrays.sort(planets, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(planets));
        // 创建一个Timer对象并用对象变量timer引用
        var timer = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        // 开始计时
        timer.start();
        // 窗口并提示可点击选项
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
