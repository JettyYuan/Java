package chapter4.statictest;

/**
 * This program demonstrates static methods
 * class: StaticTest
 * @version 18 2022-09-19
 * @author Jetty
 * @see Employee
 */
public class StaticTest {
    /**
     * static method: main
     * @param args 编译参数
     */
    public static void main(String[] args) {
        // 存放三个Employee对象的数组
        var staff = new Employee[3];
        // 分别初始化
        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);
        // 为每一个对象赋值id并打印数组中所有元素的信息
        for (Employee e : staff) {
            e.setId();
            System.out.println("name" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
        }
        int n = Employee.getNextId();
        System.out.println("Next available id=" + n);
    }
}

/**
 * 员工类
 * class: Employee
 * @version 18 2022-09-19
 * @author Jetty
 */
class Employee {
    /**
     * nextId: 初始id
     * name: 姓名
     * salary: 薪资
     * id: id
     */
    private static int nextId = 1;
    private final String name;
    private final double salary;
    private int id;

    /**
     * method: Employee 有参构造器
     * @param n 姓名
     * @param s 薪资
     */
    public Employee(String n, double s) {
        this.name = n;
        this.salary = s;
        this.id = 0;
    }

    /**
     * method: getName
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method: getSalary
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * method: getId
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * method: setId
     */
    public void setId() {
        this.id = nextId;
        nextId++;
    }

    /**
     * static method: getNextId
     * @return nextId
     */
    public static int getNextId() {
        return nextId;
    }

    /**
     * 测试类
     * static method: main
     * @param args 编译参数
     */
    public static void main(String[] args) {
        var e = new Employee("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
