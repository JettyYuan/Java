package chapter5.inheritance;

/**
 * 经理类
 *
 * @author Jetty
 * @version 18 2022-09-22
 */
public class Manager extends Employee {
    /**
     * bonus: 奖金
     */
    private double bonus;

    /**
     * 有参构造器
     *
     * @param name   姓名
     * @param salary 薪资
     * @param year   年
     * @param month  月
     * @param day    日
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus = 0;
    }

    /**
     * get
     *
     * @return salary
     */
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }

    /**
     * set
     *
     * @param b bonus
     */
    public void setBonus(double b) {
        this.bonus = b;
    }
}
