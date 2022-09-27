package chapter5.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 这个程序使用反射来打印一个类的所有特征
 *
 * @author Jetty
 * @version 18 2022-09-27
 */
public class ReflectionTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        // name: 类名
        String name;
        // 将编译参数赋值给name，否则运行时输入name
        if (args.length > 0) name = args[0];
        else {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
            in.close();
        }
        /*
        cl: 类
        supercl: cl的超类
        modifiers: cl的修饰符
         */
        Class<?> cl = Class.forName(name);
        Class<?> supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        // 如果修饰符存在就打印出来
        if (modifiers.length() > 0) System.out.print(modifiers + " ");
        // 打印类名
        System.out.print("class " + name);
        // 如果supercl存在且不是Object类，打印supercl
        if (supercl != null && supercl != Object.class) System.out.print(" extends " + supercl.getName());
        // 打印类体
        System.out.print(" {" + "\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }

    /**
     * 打印构造器
     *
     * @param cl 未知类
     */
    public static void printConstructors(Class<?> cl) {
        // constructors: cl内的构造器声明
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            // name: 构造器名
            String name = c.getName();
            System.out.print("    ");
            // modifiers: 构造器的修饰符
            String modifiers = Modifier.toString(c.getModifiers());
            // 如果修饰符存在就打印出来
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            // 打印构造器名
            System.out.print(name + "(");
            printParameterType(c.getParameterTypes());
        }
    }

    /**
     * 打印方法
     *
     * @param cl 未知类
     */
    public static void printMethods(Class<?> cl) {
        // methods: cl内的方法声明
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            /*
            reType: 方法的返回类型
            name: 方法名
             */
            Class<?> reType = m.getReturnType();
            String name = m.getName();
            System.out.print("    ");
            // modifiers: 方法的修饰符
            String modifiers = Modifier.toString(m.getModifiers());
            // 如果修饰符存在就打印出来
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            // 打印返回类型和方法名
            System.out.print(reType.getName() + " " + name + "(");
            printParameterType(m.getParameterTypes());
        }
    }

    /**
     * 打印构造器或方法的参数类型
     *
     * @param parameterTypes 构造器或方法
     */
    private static void printParameterType(Class<?>[] parameterTypes) {
        for (int j = 0; j < parameterTypes.length; j++) {
            if (j > 0) System.out.print(", ");
            // 打印参数类型名
            System.out.print(parameterTypes[j].getName());
        }
        System.out.println(");");
    }

    /**
     * 打印字段
     *
     * @param cl 未知类
     */
    public static void printFields(Class<?> cl) {
        // fields: cl内的字段
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            /*
            type: 字符类型
            name: 字段名
             */
            Class<?> type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            // modifiers: 字段的修饰符
            String modifiers = Modifier.toString(f.getModifiers());
            // 如果修饰符存在就打印出来
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            // 打印字段类型和字段名
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
