package chapter5.abstractClasses;

/**
 * Student类
 *
 * @author Jetty
 * @version 18 2022-09-23
 */
public class Student extends Person {
    /**
     * major: 专业
     */
    private final String major;

    /**
     * 有参构造器
     *
     * @param name  姓名
     * @param major 专业
     */
    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    /**
     * @return 学生专业描述
     */
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
