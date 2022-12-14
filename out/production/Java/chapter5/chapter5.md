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

## Object类

只有基本类型不是对象，所有的数组类型，不管是对象数组还是基本类型的数组都扩展了Object类

每一个类都有**必要**重写Object类的equals方法、hashCode方法和toString方法，子类再重写超类的，尽管可能用不到

java.lang.Object

- Class getClass() 返回包含对象信息的类对象
- boolean equals(Object otherObject)
  比较两个对象是否相等，如果两个对象指向同一块存储区域，方法返回true；否则方法返回false，要在自定义的类中覆盖这个方法
- String toString() 返回表示该对象值的字符串，要在自定义的类中覆盖这个方法

java.lang.Class

- String getName() 返回这个类的名字
- Class getSuperclass() 以Class对象的形式返回这个类的超类

### equals方法

Object类中的equals方法用于检测一个对象是否等于另外一个对象

getClass方法返回一个对象**所属的类**

编写一个equals方法：

- 显示参数命名为otherObject，之后转换成other
- 使用"=="检测this与otherObject是否引用的是同一个对象
- 检测otherObject是否为null
- 比较this与otherObject的类，如果equals的语义可以在子类中改变使用getClass检测
  如果所有的子类都有相同的相等性语义，使用instanceof检测
- 将otherObject强制类型转换为this的类并赋值给other
- 比较，使用==比较基本类型字段；使用Objects.equals比较对象字段；如果在子类中重新定义equals方法，就要包含一个super.equals(
  other)调用

java.util.Arrays

- static boolean equals(xxx[] a, xxx[] b)
  如果两个数组长度相同，并且在对应的位置上数据元素也相同，将返回true；数组元素类型xxx可以是Object、int、long、short、char、byte、boolean、float或double

java.util.Objects

- static boolean equals(Object a, Object b)
  如果a和b都为null，返回true；如果只有其中之一为null，则返回false；否则返回a.equals(b)

### hashCode方法

字符串的散列码(hash code)是由内容导出的，而Object类的默认hashCode方法会从对象的存储地址得出散列码

如果重新定义了equals方法就必须重新定义hashCode方法，两者定义必须相容

java.lang.Object

- int hashCode()
  返回对象的散列码，散列码可以是任意的整数，包括正数或负数；两个相等的对象要求返回相等的散列码

java.util.Objects

- static int hash(Object... objects) 返回一个散列码，由提供的所有对象的散列码组合而得到
- static int hashCode(Object a) 如果a为null返回0，否则返回a.hashCode()

java.lang.(Integer|Long|Short|Byte|Double|Float|Character|Boolean)

- static int hashCode(xxx value) 返回给定值的散列码，这里xxx是对应给定包装器类型的基本类型

java.util.Arrays

- static int hashCode(xxx[] a)
  计算数组a的散列码，组成这个数组的元素类型xxx可以是object、int、long、short、char、byte、boolean、float或double

### toString方法

只要对象与一个字符串通过操作符"+"连接起来，Java编译器就会自动地调用toString方法来获得这个对象的字符串描述

打印数组调用静态方法Arrays.toString，打印多维数组调用Arrays.deepToString方法

为自定义的每一个类添加toString方法

## 泛型数组列表

ArrayList类是一个有类型参数的泛型类，能够**自动**地调整数组容量，再类后面加上<>添加**数组列表**类型

<>结合new操作符使用**菱形语法**，省略类型，编译器会检测泛型类型，这是在对象变量声明了类型的情况，如果是var则不可以这样做，会导致生成的是Object类数组

数组列表在没有创建元素时，是不包含任何元素的，即使完成初始化构造之后

java.util.ArrayList<E>

- ArrayList<E>() 构造一个空数组列表
- ArrayList<E>(int initialCapacity) 用指定容量构造一个空数组列表
- boolean add(E obj) 在数组列表的末尾追加一个元素，永远返回true
- int size() 返回当前存储在数组列表中的元素个数（永远不会大于数组列表的容量）
- void ensureCapacity(int capacity)
  确保数组列表在不重新分配内部存储数组的情况下有足够的容量存储给定数量的元素
- void trimToSize() 将数组列表的存储容量削减到当前大小
- E set(int index, E obj) 将值obj放置在数组列表的指定索引位置，返回之前的内容
- E get(int index) 得到指定索引位置存储的值
- void add(int index, E obj) 后移元素从而将obj插入到指定索引位置
- E remove(int index) 删除指定索引位置的元素，并将后面的所有元素前移，返回所删除的元素

将一个原始ArrayList赋给一个类型化ArrayList会得到一个警告，但反之不会；强制类型转换也无法避免

可以使用@SupperssWarnings("unchecked")标记接受强制类型转换

## 对象包装器与自动装箱

基本类型在有些情况下需要转换成对象，这是就要使用到包装器类

所有的基本类型都有一个与之对应的类，就是**包装器**；包装器类是**不可变**的，一旦构造了包装器，就不允许更改包装在其中的值

包装器类是final，无法派生它们的子类，ArrayList类的<>内**不允许**是基本类型，这里使用到的是它们的包装器类，但效率极低，特殊情况使用

将基本类型装换成对应的包装器类对象是**自动装箱**；相反，则是自动拆箱

自动装箱**规范**要求boolean、byte、char <=
127，介于-128和127之间的short和int被包装到固定的对象中；如果满足这个规范，包装器类对象就可以使用"=="比较数值

java.lang.Integer

- int intValue() 将这个Integer对象的值作为一个int返回（覆盖Number类中的intValue方法）
- static String toString(int i) 返回一个新的String对象，表示指定的数值i的十进制表示
- static String toString(int i, int radix) 返回数值i基于radix参数指定进制的表示
- static int parseInt(String s), static int parseInt(String s, int radix)
  返回字符串s表示的整数，指定字符串必须表示一个十进制整数（第一种方法），或者采用radix参数指定的进制（第二种方法）
- static Integer valueOf(String s), static Integer valueOf(String s, int radix)
  返回一个新的Integer对象，用字符串s表示的整数初始化；指定字符串必须表示一个十进制整数（第一种方法），或者采用radix参数指定的进制（第二种方法）

java.text.NumberFormat

- Number parse(String s) 返回数字值，假设给定的String表示一个数值

## “变参”方法

使用省略号...接收任意数量的对象，可变参数**本质**是接收一定数量的参数将它们存放在一个对应类或类型的数组中，并依次使用数组中的元素

## 枚举

在比较两个枚举类型的值时，不需要equals，直接使用"=="即可，枚举的构造器总是私有的

java.lang.Enum<E>

- static Enum valueOf(Class enumClass, String name) 返回给定类中有指定名字的枚举常量
- String toString() 返回枚举常量名
- int ordinal() 返回枚举常量在enum声明中的位置，位置从0开始计数
- int compareTo(E other)
  如果枚举常量出现在other之前，返回一个负整数；如果this==other，则返回0；否则，返回一个正整数；枚举常量的出现次序在enum声明中给出

## 反射

Object类中的getClass()方法将会返回一个Class类型的实例，Class类实际上是泛型类

两个类对象可以通过Class类利用"=="运算符比较，只有当两者的类是同一个类才是true，子类也不行

java.lang.Class

- static Class forName(String className) 返回一个Class对象，表示名为className的类
- Constructor getConstructor(Class... parameterTypes) 生成一个对象，描述有指定参数类型的构造器
- URL getResource(String name) InputStream getResourceAsStream(String name)
  找到与类位于同一位置的资源，返回一个可以用来加载资源的URL或者输入流；如果没有找到资源，则返回null，所以不会抛出异常或者I/O错误
- Field[] getFields(), Field[] getDeclaredFields()
  getFields方法将返回一个包含Field对象的数组，这些对象对应这个类或其超类的公共字段
  getDeclaredField方法也返回包含Field对象的数组，这些对象对应这个类的全部字段
  如果类中没有字段，或者Class对象描述的是基本类型或数组类型，这些方法将返回一个长度为0的数组
- Method[] getMethod(), Method[] getDeclaredMethods()
  返回包含Method对象的数组：getMethods将返回所有的公共方法，包括从超类继承来的方法
  getDeclaredMethods返回这个类或接口的全部方法，但不包括由超类继承的方法
- Constructor[] getConstructors(), Constructor[] getDeclaredConstructors()
  返回包含Constructor对象的数组，其中包含Class对象所表示的类的所有公共构造器(getConstructors)或全部构造器(
  getDeclaredConstructors)
- String getPackageName()
  得到包含这个类型的包的包名，如果这个类型是一个数组类型，则返回元素类型所属的包，或如果这个类型是一个基本类型，则返回"
  java.lang"
- Field getField(String name), Field[] getFields() 得到指定名的公共字段，或所有这些字段的一个数组
- Field getDeclaredField(String name), Field[] getDeclaredFields()
  得到类中声明的指定名的字段，或者所有这些字段的一个数组

java.lang.reflect.Constructor

- Object newInstance(Object... params) 将params传递到构造器，来构造这个构造器声明类的一个新实例

java.lang.Throwable

- void printStackTrace() 将Throwable对象和堆栈轨迹打印到标准错误流

如果在一个方法的方法名上增加了一个throws子句，那么调用这个方法的任何方法都需要throws声明，这也包括main方法

java.lang.reflect.Field, java.lang.reflect.Method, java.lang.reflect.Constructor

- Class getDeclaringClass() 返回一个Class对象，表示定义了这个构造器、方法或字段的类
- Class[] getExceptionTypes()（在Constructor和Method classes类中）
  返回一个Class对象数组，其中各个对象表示这个方法所抛出异常的类型
- int getModifiers()
  返回一个整数，描述这个构造器、方法或字段的修饰符；使用Modifier类中的方法来分析这个返回值
- String getName() 返回一个表示构造器名、方法名或字段名的字符串
- Class[] getParameterTypes() （在Constructor和Method classes类中）
  返回一个Class对象数组，其中各个对象表示参数的类型
- Class getReturnType() （在Method类中）
  返回一个用于表示返回类型的Class对象

java.lang.reflect.Modifier

- static String toString(int modifiers) 返回一个字符串，包含对应modifiers中位设置的修饰符
- static boolean isAbstract(int modifiers), static boolean isFinal(int modifiers),
  static boolean isInterface(int modifiers), static boolean isNative(int modifiers),
  static boolean isPrivate(int modifiers), static boolean isProtected(int modifiers),
  static boolean isPublic(int modifiers), static boolean isStatic(int modifiers),
  static boolean isStrict(int modifiers), static boolean isSynchronized(int modifiers),
  static boolean isVolatile(int modifiers) 这些方法将检测modifiers值中与方法名中修饰符对应的二进制位

反射机制的**默认行为**受限于Java的访问控制

java.lang.reflect.AccessibleObject

- void setAccessible(boolean flag)
  设置或取消这个可访问对象的可访问标志，如果拒绝访问则抛出一个IllegalAccessException异常
- void setAccessible(boolean flag), boolean trySetAccessible()
  为这个可访问的对象设置可访问标志，如果拒绝访问则返回false
- boolean isAccessible() 得到这个可访问对象的可访问标志值
- static void setAccessible(AccessibleObject[] array, boolean flag)
  这是一个便利方法，用于设置一个对象数组的可访问标志

java.lang.reflect.Field

- Object get(Object obj) 返回obj对象中用这个Field对象描述的字段的值
- void set(Object obj, Object newValue) 将obj对象中这个Field对象描述的字段设置为一个新值

java.lang.reflect.Array

- static Object get(Object array, int index), static xxx getXxx(Object array, int index)
  （xxx是一种基本类型）这些方法将返回存储在给定数组中给定索引位置上的值
- static void set(Object array, int index, Object newValue), static setXxx(Object array, int index, xxx newValue)
  （xxx是一种基本类型）这些方法将一个新值存储到给定数组中的给定位置上
- static int getLength(Object array) 返回给定数组的长度
- static Object newInstance(Class componentType, int length), static Object newInstance(Class componentType, int[]
  lengths)
  返回一个有给定类型、给定大小的新数组

java.lang.reflect.Method

- public Object invoke(Object implicitParameter, Object explicitParameters)
  调用这个对象描述的方法，传入给定参数，并返回方法的返回值；对于静态方法，传入null作为隐式参数；使用包装器传递基本类型值；基本类型的返回值必须是未包装的

## 继承设计技巧

- 将公共操作与字段放在超类
- 不要使用受保护字段
