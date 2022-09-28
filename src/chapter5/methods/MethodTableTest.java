package chapter5.methods;

import java.lang.reflect.Method;

/**
 * 这个程序展示如何通过反射调用方法
 *
 * @author Jetty
 * @version 18 2022-09-28
 */
public class MethodTableTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        /*
        square: MethodTableTest类中的名为square，参数为double类型的方法对象
        sqrt: Math类中的名为sqrt，参数为double类型的方法对象
         */
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);
        // 打印
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * 参数的平方
     *
     * @param x 需要运算的数
     * @return 运算结果
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * @param from 从...
     * @param to   到...
     * @param n    总数
     * @param f    方法
     * @throws ReflectiveOperationException 反射操作异常
     */
    public static void printTable(double from, double to, int n, Method f) throws ReflectiveOperationException {
        // 打印方法签名
        System.out.println(f);
        // 两个数字之间的间隔值
        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            // 调用方法并强制转换为Double类赋值给double类变量
            double y = (Double) f.invoke(null, x);
            // 格式化打印
            System.out.printf("%10.4f | %10.4f%n", x, y);
        }
    }
}
