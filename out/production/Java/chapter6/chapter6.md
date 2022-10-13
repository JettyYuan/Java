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

**只有**一个抽象方法的接口是函数式接口，有些方法需要这种接口作为参数，可以提供一个lambda表达式处理

只有当lambda表达式的体只调用一个方法而不做其他操作时，才能把lambda表达式重写为**方法引用**

用::运算符分隔方法名与对象或类名：

- object::instanceMethod
- Class::instanceMethod
- Class::staticMethod

包含对象的方法引用与等价的lambda表达式还有细微的差别

除了方法引用之外，还可以使用构造器引用，也可以为数组类型建立构造器引用

lambda表达式可以捕获外围作用域中变量的值，但这个变量必须是事实最终变量，同时lambda表达式在使用变量的过程中也不能改变变量的值

lambda表达式的体与嵌套体有相同的作用域
