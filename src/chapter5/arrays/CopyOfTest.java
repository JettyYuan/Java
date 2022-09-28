package chapter5.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 这个程序演示了如何使用反射操作数组
 *
 * @author Jetty
 * @version 18 2022-09-28
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));
        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));
        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b, 10);
    }

    /**
     * 此方法试图通过分配新数组并复制所有元素来增长数组
     *
     * @param a         需要增长的数组
     * @param newLength 新数组的长度
     * @return 包含a的较大数组，但返回的数组类型与a不同
     */
    public static Object[] badCopyOf(Object[] a, int newLength) {
        var newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    /**
     * 此方法通过分配一个相同类型的新数组并处理所有元素来增长数组
     *
     * @param a         需要增长的数组
     * @param newLength 新数组的长度
     * @return 包含a的较大数组
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class<?> cl = a.getClass();
        if (!cl.isArray()) return null;
        Class<?> componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
