package chapter5.equals;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 员工
 *
 * @author Jetty
 * @version 18 2022-09-24
 */
public class Employee {
    /**
     * name: 姓名
     * salary: 薪资
     * hireDay: 聘用日期
     */
    private final String name;
    private final LocalDate hireDay;
    private double salary;

    /**
     * @param name   姓名
     * @param salary 薪资
     * @param year   年
     * @param month  月
     * @param day    日
     */
    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * 按百分比涨薪
     *
     * @param byPercent 百分比于原薪资
     */
    public void raiseSalary(double byPercent) {
        /*
        raise: 涨薪的额度
        salary: 涨薪之后的薪资
         */
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * 重写用于比较Employee类对象与未知类对象
     *
     * @param otherObject 未知类对象
     * @return true or false
     */
    public boolean equals(Object otherObject) {
        // 比较两个对象变量
        if (this == otherObject) return true;
        // 检测参数是否是null
        if (otherObject == null) return false;
        // 比较两个对象变量的类
        if (getClass() != otherObject.getClass()) return false;
        // 将显式参数强制类型转换为隐式参数的类(Employee)
        var other = (Employee) otherObject;
        // 转换之后对两者的字段进行一一比较
        return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }

    /**
     * 重写用于组合Employee类字段的散列码
     *
     * @return 散列码
     */
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    /**
     * 重写用于输出Employee类的字段
     *
     * @return 字符串
     */
    public String toString() {
        return getClass().getName() + "[name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
    }
}
