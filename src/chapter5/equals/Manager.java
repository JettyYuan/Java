package chapter5.equals;

/**
 * 经理继承员工
 *
 * @author Jetty
 * @version 18 2022-09-24
 */
public class Manager extends Employee {
    /**
     * bonus: 奖金
     */
    private double bonus;

    /**
     * @param name   姓名
     * @param salary 薪资
     * @param year   年
     * @param month  月
     * @param day    日
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    /**
     * 重写用于计算Manager类对象的薪资（原薪资 + 奖金）
     *
     * @return 薪资
     */
    public double getSalary() {
        // baseSalary: 原薪资
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * 重写用于比较Manager类对象与未知类对象
     *
     * @param otherObject 未知类对象
     * @return true or false
     */
    public boolean equals(Object otherObject) {
        // 调用超类的equals方法比较两个对象变量
        if (!super.equals(otherObject)) return false;
        // 将显式参数强制类型转换为隐式参数的类(Manager)
        var other = (Manager) otherObject;
        // 转换之后对两者的字段bonus进行比较
        return bonus == other.bonus;
    }

    /**
     * 重写用于组合Manager类字段的散列码
     *
     * @return 散列码
     */
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), bonus);
    }

    /**
     * 重写用于输出Manager类的字段
     *
     * @return 字符串
     */
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
