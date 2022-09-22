package chapter5.inheritance;

/**
 * This program demonstrates inheritance.
 *
 * @author Jetty
 * @version 18 2022-09-22
 */
public class ManagerTest {
    /**
     * main
     *
     * @param args 编译参数
     */
    public static void main(String[] args) {
        // 创建一个对象变量boss引用一个经理类对象
        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        // 设置boss的bonus
        boss.setBonus(5000);
        // 创建一个对象变量staff引用一个员工类对象数组
        var staff = new Employee[3];
        // 初始化数组元素
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
        // 遍历staff打印
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
        }
    }
}
