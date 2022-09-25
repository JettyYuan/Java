package chapter5.arrayList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This program demonstrates the ArrayList class.
 *
 * @author Jetty
 * @version 18 2022-09-25
 */
public class ArrayListTest {
    public static void main(String[] main) {
        // staff: Employee类对象的泛型类数组列表
        var staff = new ArrayList<Employee>();
        // staff添加三个元素
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
        // 遍历staff执行raiseSalary方法
        for (Employee e : staff) e.raiseSalary(5);
        // 遍历staff打印name、salary和hireDay
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
    }
}

/**
 * 员工
 *
 * @author Jetty
 * @version 18 2022-09-25
 */
class Employee {
    /**
     * name: 姓名
     * salary: 薪资
     * hireDay: 聘请日期
     */
    private final String name;
    private final LocalDate hireDay;
    private double salary;

    /**
     * @param n     姓名
     * @param s     薪资
     * @param year  聘请日期的年
     * @param month 聘请日期的月
     * @param day   聘请日期的日
     */
    public Employee(String n, double s, int year, int month, int day) {
        Objects.requireNonNull(n, "The name can't be null");
        this.name = n;
        this.salary = s;
        this.hireDay = LocalDate.of(year, month, day);
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
     * 涨薪
     *
     * @param byPercent 相比于原薪资的百分比
     */
    public void raiseSalary(double byPercent) {
        /*
        raise: 涨薪的额度
        salary: 涨薪之后的薪资
         */
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
}
