# chapter5

## 超类与子类

在Java中使用关键字super调用超类的方法

由于子类不能访问超类的私有字段，所以子类的构造器**必须**
调用超类的构造器；如果没有显示调用超类构造器，子类构造器将默认调用超类的无参构造器；超类构造器必须是子类构造器方法体的**
第一条语句**

多态是指一个对象变量可以指示多种实际类型的现象

子类的每个对象也是超类的对象，但**反之不成立**；因此超类的对象可以引用任何一个其子类的对象，不能将超类的引用赋给子类变量

子类会覆盖超类中**签名相同**的方法，需要保证返回类型的**兼容性**，**允许**子类将返回类型改回为超类的返回类型

动态绑定：在运行时自动选择适当的方法，优先寻找当前引用对象的实际类型，找不到再去寻找其超类方法；无须对现有代码进行修改即可对程序进行扩展

静态绑定：如果是private方法、static方法、final方法或者构造器，编译器可以准确调用

在覆盖方法时，子类方法**不能低于**超类方法的可见性

不允许扩展的类，加上final修饰符被称为final类，final类中的所有方法都会设置为final方法，而字段不会

final方法不能被子类的方法覆盖

## 强制类型转换

只能再继承层次内进行强制类型转换，转换前使用instanceof操作符查看变量能否强制类型转换，但一般不建议这么做

## 抽象类

如果有抽象方法，这个类必须为抽象类；但抽象类可以不含抽象方法，并且抽象类不能实例化

可以定义一个抽象类的对象变量，但只能引用非抽象类的子类对象

**只允许子类**访问的字段或方法，使用protected修饰；但字段只能是**同一个包**的类才能访问，所以一般是方法才保护

访问控制修饰符

- private 仅对本类可见
- public 对外部完全可见
- protected 对本包和所有子类可见
- 无修饰符 对本包可见

## Object

只有基本类型不是对象

Object类中的equals方法用于检测一个对象是否等于另外一个对象

getClass方法返回一个对象**所属的类**

编写一个equals方法：

- 显示参数命名为otherObject，之后转换成other
- 检测this与otherObject是否相等
- 检测otherObject是否为null
- 比较this与otherObject的类，如果equals的语义可以在子类中改变使用getClass检测
  如果所有的子类都有相同的相等性语义，使用instanceof检测
- 将otherObject强制类型转换为this的类并赋值给other
- 比较，使用==比较基本类型字段；使用Objects.equals比较对象字段

java.util.Arrays

- static boolean equals(xxx[] a, xxx[] b)
  如果两个数组长度相同，并且在对应的位置上数据元素也相同，将返回true；数组元素类型xxx可以是Object、int、long、short、char、byte、boolean、float或double

java.util.Objects

- static boolean equals(Object a, Object b)
  如果a和b都为null，返回true；如果只有其中之一为null，则返回false；否则返回a.equals(b)