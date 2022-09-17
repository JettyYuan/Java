# chapter4

## 面向对象

### 类

子类继承父类，会继承父类的所有属性与方法；包括私有的，但不能在子类中直接访问

依赖是指一个类的方法使用或操纵另一个类的对象，但应将这种依赖减至最少，这就是降低耦合；聚合是指一个类的对象包含另一个类的对象

### 对象

三个特性：

- 行为，就是对象的可以应用的方法
- 状态，调用方法后，对象产生的响应
- 标识，区分具有相同行为与状态不同的对象

构造对象必须使用构造器，并使用new关键字，一个简单的类对象就是new加上构造器；同样可以将这个类对象赋值给变量，这种行为称为变量引用对象，这种变量就是对象变量

Java的对象变量类似于C++的对象指针，因此对象都存放在堆中。Java也可以不使用这种方式引用对象，通过clone方法获得对象的副本

### 方法

更改器方法：访问对象会导致对象状态的改变的方法

访问器方法：只访问对象而不修改对象的方法；类似于C++中有const后缀修饰的方法

java.time.LocalDate

- static LocalDate now() 构造一个表示当前日期的对象
- static LocalDate of(int year, int month, int day) 构造一个表示给定日期的对象
- int getYear(), int getMonthOfValue(), int getDayOfValue() 得到当前日期的年、月和日
- DayOfWeek getDayOfWeek 得到当前日期是星期几，作为DayOfWeek类的一个实例返回。调用getValue来得到1~7之间的一个数，表示这是星期几，1表示星期一，7表示星期日
- LocalDate plusDays(int n), LocalDate minusDays(int n) 生成当前日期之后或之前n天的日期
