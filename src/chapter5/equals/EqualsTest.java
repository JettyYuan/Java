package chapter5.equals;

/**
 * This program demonstrates the equals method.
 *
 * @author Jetty
 * @version 18 2022-09-24
 */
public class EqualsTest {
    /**
     * main
     *
     * @param args 编译参数
     */
    public static void main(String[] args) {
        // 创建并初始化四个引用Employee类对象的对象变量alice1、alice2、alice3和bob
        var alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        var alice2 = alice1;
        var alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        var bob = new Employee("Bob Grandson", 50000, 1989, 10, 1);
        // 使用"=="比较alice1与alice2、alice1与alice3
        // true
        System.out.println("alice1 == alice2: " + (alice1 == alice2));
        // false
        System.out.println("alice1 == alice3: " + (alice1 == alice3));
        // 使用equals方法比较alice1与alice3、alice1与bob
        // true
        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
        // false
        System.out.println("alice1.equals(bob): " + alice1.equals(bob));
        // 打印bob
        System.out.println("bob.toString(): " + bob);
        // 创建并初始化两个引用Manager类对象的对象变量carl和boss
        var carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        // 设置boss奖金
        boss.setBonus(5000);
        // 打印boss
        System.out.println("boss.toString(): " + boss);
        // 使用equals方法比较carl与boss
        // false
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        // 打印alice1、alice3、bob和carl的散列码
        // 两个对象的字段相等，散列码相同
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        // 两个对象的字段不等，散列码不同
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());
    }
}
