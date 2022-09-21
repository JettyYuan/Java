package chapter4.employeetest;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This program tests the EmployeeTest
 * class: EmployeeTest
 * @version 18 2022-09-18
 * @author Jetty
 */
public class EmployeeTest {
    /**
     * method: main
     * @param args 编译参数
     */
    public static void main(final String[] args) {
        // 最多存放三个员工的数组
        Employee[] staff = new Employee[3];
        // 设定员工初始值
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        // 为数组中的每一个员工涨薪5%
        for (Employee e : staff) {
            e.raiseSalary(5);
        }
        // 输出数组中所有员工的信息
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
        }
    }
}

/**
 * class: Employee 员工
 */
class Employee {
    /**
     * name: 姓名
     * salary: 薪资
     * hireDay: 聘请日期
     */
    private final String name;
    private double salary;
    private final LocalDate hireDay;

    /**
     * Employee(...): 有参构造器
     * @param n 姓名
     * @param s 薪资
     * @param year 聘请日期的年
     * @param month 聘请日期的月
     * @param day 聘请日期的日
     */
    public Employee(String n, double s, int year, int month, int day) {
        Objects.requireNonNull(n, "The name can't be null");
        this.name = n;
        this.salary = s;
        this.hireDay = LocalDate.of(year, month, day);
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

    /**
     * get
     * @return hireDay
     */
    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * method: 涨薪
     * @param byPercent 相对于原本薪资的百分比
     */
    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
}
