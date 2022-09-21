package chapter4.constructortest;

import java.util.Random;

/**
 * This program demonstrates object construction
 * @version 18 2022-09-20
 * @author Jetty
 */
public class ConstructorTest {
    /**
     * main
     * @param args 编译参数
     */
    public static void main(String[] args) {
        // 创建Employee类对象数组存放三个对象，创建变量staff引用对象数组
        var staff = new Employee[3];
        // 初始化数组元素
        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();
        // 遍历数组打印
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
        }
    }
}

/**
 *
 */
class Employee {
    /**
     * nextId: 下一名员工的id
     * id: id
     * name: 姓名
     * salary: 薪资
     */
    private static int nextId;
    private final int id;
    private String name = "";
    private double salary;

    // 静态初始化块
    static {
        var generator = new Random();
        nextId = generator.nextInt(10000);
    }
    // 初始化块
    {
        id = nextId;
        nextId++;
    }

    /**
     * 有参构造器
     * @param n 姓名
     * @param s 薪资
     */
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    /**
     * 有参构造器
     * @param s 薪资
     */
    public Employee(double s) {
        this("Employee #" + nextId, s);
    }

    /**
     * 无参构造器
     */
    public Employee() {}

    /**
     * get
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * get
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get
     * @return salary
     */
    public double getSalary() {
        return salary;
    }
}