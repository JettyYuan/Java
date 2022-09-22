package chapter5.inheritance;

import java.time.LocalDate;

/**
 * 员工类
 *
 * @author Jetty
 * @version 18 2022-09-22
 */
public class Employee {
    /**
     * name: 姓名
     * salary: 薪资
     * hireDay: 聘用日期
     */
    private final String name;
    private double salary;

    /**
     * 有参构造器
     *
     * @param name   姓名
     * @param salary 薪资
     * @param year   年
     * @param month  月
     * @param day    日
     */
    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        LocalDate hireDay = LocalDate.of(year, month, day);
    }

    /**
     * get
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * get
     *
     * @return salary
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * 涨薪
     *
     * @param byPercent 相比于薪资的百分比
     */
    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
}
