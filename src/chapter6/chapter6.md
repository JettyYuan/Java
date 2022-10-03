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
