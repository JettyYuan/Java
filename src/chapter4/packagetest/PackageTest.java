package chapter4.packagetest;

import static java.lang.System.out;

/**
 * This program demonstrates the use of packages.
 * @version 18 2022-09-20
 * @author Jetty
 */
public class PackageTest {
    /**
     * main
     * @param args 编译参数
     */
    public static void main(String[] args) {
        // 创建一个变量引用创建的Employee类对象
        var harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        // 涨薪
        harry.raiseSalary(5);
        // 打印
        out.println("name=" + harry.getName() + ", salary=" + harry.getSalary());
    }
}
