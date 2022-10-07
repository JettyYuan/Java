# chapter6

## 接口

接口中的所有方法都自动是public方法，但在类中要在实现的方法用public修饰，否则将会是默认的访问属性

要将类声明为实现某个接口，需要使用关键字implements

java.lang.Comparable<T>

- int compareTo(T other)
  用这个对象与other进行比较；如果这个对象小于other则返回一个负整数；如果相等则返回0；否则返回一个正整数

java.util.Arrays

- static void sort(Object[] a)
  对数组a中的元素进行排序；要求数组中的元素必须属于实现了Comparable接口的类，并且元素之间必须是可比较的

java.lang.Integer

- static int compare(int x, int y) 如果x<y返回一个负整数；如果相等返回；否则返回一个正整数

java.lang.Double

- static int compare(double x, double y) 如果x<y返回一个负整数；如果相等返回；否则返回一个正整数

不能使用new运算符实例化一个接口，但能声明接口的变量，接口变量**必须**引用实现这个接口的类对象

instanceof也可以检查对象是否实现了某个特定接口，接口也可以扩展接口，类可以多接口

接口中虽然不能有实例字段但可以包含常量，接口中的字段总是public static final

接口允许添加静态方法或实例方法，但一般是把它们放在接口的伴随类中

关键字default可以修饰接口中的方法，使之默认，这时这个方法可以有方法体

接口的方法与超类的方法，如果一个类从超类和接口处继承了相同的方法，“类优先”

javax.swing.JOptionPane

- static void showMessageDialog(Component parent, Object message)
  显示一个包含一条提示消息和OK按钮的对话框；这个对话框位于parent组件的中央；如果parent为null，对话框将显示在屏幕的中央

javax.swing.Timer

- Timer(int interval,ActionListener listener) 构造一个定时器，没经过interval毫秒通知listener一次
- void start() 启动定时器；一旦启动，定时器将调用监听器的actionPerformed
- void stop() 停止定时器；一旦停止，定时器将不再调用监听器的actionPerformed

java.awt.Toolkit

- static Toolkit getDefaultToolkit() 获得默认的工具箱；工具箱包含有关GUI环境的信息
- void beep() 发出一声铃响

所有**数组类型**都有一个公共的clone方法，而不是受保护的

## lambda表达式

无须指定lambda表达式的返回类型
