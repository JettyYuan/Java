package chapter5.abstractClasses;

import java.time.LocalDate;

/**
 * Employee类
 *
 * @author Jetty
 * @version 18 2022-09-23
 */
public class Employee extends Person {
    private final LocalDate hireDay;
    /**
     * salary: 薪资
     * hireDay: 聘用日期
     */
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
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    /**
     * get
     *
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * get
     *
     * @return hireDay
     */
    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * @return 员工薪资描述
     */
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    /**
     * 涨薪
     *
     * @param byPercent 百分比于薪资
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
