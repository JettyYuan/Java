package chapter5.abstractClasses;

/**
 * Person类
 *
 * @author Jetty
 * @version 18 2022-09-23
 */
public abstract class Person {
    /**
     * name: 姓名
     */
    private final String name;

    /**
     * 有参构造器
     *
     * @param name 姓名
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * @return 描述
     */
    public abstract String getDescription();

    /**
     * get
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}
