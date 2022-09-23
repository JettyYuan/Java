package chapter5.abstractClasses;

/**
 * PersonTest类
 *
 * @author Jetty
 * @version 18 2022-09-23
 */
public class PersonTest {
    public static void main(String[] args) {
        // 创建一个people对象变量引用Person类对象数组
        var people = new Person[2];
        // 初始化people
        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");
        // 遍历people打印
        for (Person p : people) {
            System.out.println(p.getName() + ", " + p.getDescription());
        }
    }
}
