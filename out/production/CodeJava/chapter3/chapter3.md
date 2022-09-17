# chapter3

## 规范

### 命名规范

不能使用Java保留字
类名以大写字母开头遵循骆驼命名法
常量名全部大写
其他方法名、变量名等从第二个单词开始首字母大写遵循驼峰原则

### Java语言规范

main方法必须声明为public

## 数据类型

### 整型

在Java中，所有的数值类型所占据的字节数与平台无关
并且
Java没有任何无符号形式的int、long、short或byte类型

| 类型    | 存储需求 |
|-------|------|
| int   | 4字节  |
| short | 2字节  |
| long  | 8字节  |
| byte  | 1字节  |

长整型数值后缀L或l

十六进制数值前缀0X或0x 八进制数值前缀0 二进制数值前缀0B或0b

可以在数字字面量加下划线

默认值为0

多整型数值计算结果类型

- 数值中有long型，结果为long型
- 数值中无long型，结果为int型

### 浮点类型

| 类型     | 存储需求 | 有效位数 |
|--------|------|------|
| float  | 4字节  | 6~7位 |
| double | 8字节  | 15位  |

float类型数值后缀F或f

十六进制表示法中，使用p表示指数，尾数采用十六进制，指数采用十进制

避免浮点数之间的比较

用于表示溢出和出错情况的三个特殊浮点数值：

- 正无穷大 Double.POSITIVE_INFINITY
- 负无穷大 Double.NEGATIVE_INFINITY
- NaN（不是一个数字）Double.NaN

Double.isNaN方法判断NaN

默认值为0.0

### boolean类型

整型值和布尔值之间不能进行相互转换

默认值为false

### char类型

默认值为'\u0000'

## 量

### 变量

Java中“字母”和“数字”的范围更大

不能使用未初始化的变量

对于局部变量，如果可以从变量的初始值推断出它的类型就不再需要声明类型，只需要使用关键字var

类变量，在类中方法外部使用static声明的变量

实例变量是在类中方法外部声明的，如果要在方法中使用必须用类创建一个对象，才可以使用

### 常量

常量：final 一般常量名使用全大写。可以说是变量加上final

类常量：static final 在类中方法外部声明的，一个类的多个方法使用

如果一个常量被声明为public，那么其他类的方法也可以使用这个常量

## 运算符

### 算术运算符

整数除以0会产生一个异常，而浮点数除以0会得到无穷大或NaN结果

如果将一个类标记为strictfp，这个类中的所有方法都要使用严格的浮点计算

### 数学函数

java.lang.Math

- Math.sin Math.cos Math.tan Math.atan Math.atan2
- Math.exp Math.log Math.log10
- Math.PI Math.E
- Math.multiplyExact 捕获异常终止程序
- Math.round 对浮点数进行舍入运算得到最接近整数的结果 返回值long型
- Math.random 随机返回0 ~ 1之间（包含0不包含1）的浮点数

如果得到一个完全可预测的结果比运行速度更重要的话，使用StrictMath类multiplyExact

### 强制类型

强制类型转换通过截断小数部分将浮点值转换为整数

不要在boolean类型与任何数值类型之间进行强制类型转换

### 自增、自减运算符

不要在表达式中使用++或--

### 位运算符

比较的是二进制的每一位

    A: 0011 1100
    B: 0000 1101
    A & B: 0000 1100
    A | B: 0011 1101
    A ^ B: 0011 0001 （相同为0，不同为1）
    ~ B: 1111 0010
    <<: *2 空位补0
    >>: /2 最高位为1，空位补1；最高位为0，空位补0
    2: 0000 0010
    2 << 3: 16 (0001 0000)
    >>>: 空位补0

### 字符串

默认值为null

任何一个Java对象都可以转换成字符串，拼接字符串与非字符串的注意点

    ```java
    System.out.println("" + 10 + 20); // 结果为1020
    System.out.println(10 + 20 + ""); // 结果为30
    ```

不要使用==运算符检测两个字符串是否相等

CharSequence形参可以传入String实参

java.lang.String

- String substring(int beginIndex), String substring(int beginIndex, int endIndex)
返回一个新字符串。这个字符串包含原始字符串中从beginIndex到字符串末尾或endIndex-1的所有代码单元
- String join(CharSequence delimiter, CharSequence... elements) 返回一个新字符串，用给定的定界符连接所有元素
- String repeat(int count) 返回一个字符串，将当前字符串重复count次
- boolean equals(Object other) 如果字符串与other相等，返回true
- boolean equalsIgnoreCase(String other) 如果字符串与other相等（忽略大小写），返回true
- int compareTo(String other) 按照字典顺序，如果字符串位于other之前返回一个负数；如果位于other之后返回一个正数；相等返回0
- int length() 返回字符串代码单元的个数
- int codePointCount(int startIndex, int endIndex) 返回startIndex和endIndex-1之间的码点个数
- char charAt(int index) 返回给定位置的代码单元
- int codePointAt(int index) 返回从给定位置开始的码点
- int offsetByCodePoints(int startIndex, int cpCount) 返回从startIndex码点开始，cpCount个码点后的码点索引
- IntStream codePoints() 将这个字符串的码点作为一个流返回，调用toArray将它们放在一个数组中
- new String(int[] codePoints, int offset, int count) 用数组中从offset开始的count个码点构造一个字符串
- boolean empty(), boolean blank() 如果字符串为空或者由空格组成，返回true
- boolean startsWith(String prefix), boolean endsWith(String suffix) 如果字符串以prefix开头或以suffix结尾，返回true
- int indexOf(String str), int indexOf(String str, int fromIndex), int indexOf(int cp), int indexOf(int cp, int fromIndex)
返回与字符串str或码点cp匹配的第一个子串的开始位置。从索引0或fromIndex开始匹配。如果在原始字符串中不存在str，返回-1
- int lastIndexOf(String str), int lastIndexOf(String str, int fromIndex), int lastIndexOf(int cp), int lastIndexOf(int cp, int fromIndex)
返回与字符串str或码点cp匹配的最后一个子串的位置。从原始字符末尾或fromIndex开始匹配
- String replace(CharSequence oldString, CharSequence newString)
返回一个新字符串。这个字符串用newString代替原始字符串中的所有的oldString。可以用String或StringBuilder对象作为CharSequence参数
- String toLowerCase(), String toUpperCase() 返回一个新字符串。这个字符串将原始字符串中的大写字母改为小写，或者将原始字符串中的小写字母改为大写字母
- String trim(), String strip() 返回一个新字符串。这个字符串将删除原始字符串头部和尾部小于等于U+0020的字符(trim)或空格(strip)

### 构建字符串

StringBuilder类调用StringBuilder方法构建字符串构建器，调用append方法添加内容，构建完成调用toString方法得到String对象

java.lang.StringBuilder

- StringBuilder() 构造一个空的字符串构建器
- int length() 返回构建器或缓冲器中的代码单元数量
- StringBuilder append(String str) 追加一个字符串并返回this
- StringBuilder append(char c) 追加一个代码单元并返回this
- StringBuilder appendCodePoint(int cp) 追加一个码点，并将其转换为一个或两个代码单元并返回this
- void setCharAt(int i, char c) 将第i个代码单元设置为c
- StringBuilder insert(int offset, String str) 在offset位置插入一个字符串并返回this
- StringBuilder insert(int offset, char c) 在offset位置插入一个代码单元并返回this
- StringBuilder delete(int startIndex, int endIndex) 删除偏移量从startIndex到endIndex-1的代码单元并返回this
- String toString() 返回一个与构建器或缓冲器内容相同的字符串

### 输入输出

Console类可以隐式读取输入的一行字符

java.util.Scanner

- Scanner(InputStream in) 用给定的输入流创建一个Scanner对象
- String nextLine() 读取输入的下一行内容
- String next() 读取输入的下一个单词（以空格作为分隔符）
- int nextInt(), double nextDouble() 读取并转换下一个表示整数或浮点数的字符序列
- boolean hasNext() 检测输入中是否还有其他单词
- boolean hasNextInt(), boolean hasNextDouble() 检测是否还有下一个表示整数或浮点数的字符序列

java.lang.System

- static Console console() 如果可以进行交互，就返回一个Console对象通过控制台窗口与用户交互，否则返回null
对于任何一个在控制台窗口启动的程序，都可使用Console对象。否则，是否可用取决于所使用的系统

java.io.Console

- static char[] readPassword(String prompt, Object... args), static String readLine(String prompt, Object... args)
显示字符串prompt（提示符）并读取用户输入直到输入行结束。args参数可以用来提供个是参数

### 格式化输出

printf方法参数索引值从1开始

数字和日期的格式化规则是特定于本地化环境的

String.format方法创建格式化字符串而不打印输出

### 文件输入输出

java.util.Scanner

- Scanner(Path p, String encoding) 构造一个使用给定字符编码从给定路经读取数据的Scanner
- Scanner(String data) 构造一个从给定字符串读取数据的Scanner

java.io.PrintWriter

- PrintWriter(String fileName) 构造一个将数据写入文件的PrintWriter。文件名由参数指定

java.nio.file.Path

- static Path of(String pathName) 根据给定的路经名构造一个Path

## switch语句

switch的参数可以是整数量，char，String类对象

## 大数

BigInteger类实现任意精度的整数运算

java.math.BigInteger

- BigInteger add(BigInteger other), BigInteger subtract(BigInteger other), BigInteger multiply(BigInteger other), BigInteger divide(BigInteger other),
BigInteger mod(BigInteger other) 返回这个大整数和另一个大整数other的和、差、积、商以及余数
- BigInteger sqrt() 得到这个BigInteger的平方根
- int compareTo(BigInteger other) 如果这个大整数与另一个大整数other相等，返回0；如果这个大整数小于另一个大整数other，返回负数；否则，返回正数
- static BigInteger valueOf(long x) 返回值等于x的大整数

BigDecimal类实现任意精度的浮点数运算

java.math.BigDecimal

- BigDecimal add(BigDecimal other), BigDecimal subtract(BigDecimal other), BigDecimal multiply(BigDecimal other), BigDecimal divide(BigDecimal other),
BigDecimal divide(BigDecimal other, RoundingMode mode) 返回这个大实数和other的和、差、积、商。如果商是个无限循环小数，第一个divide方法会抛出一个异常。要得到一个舍入的结果，
就要使用第二个方法
- int compareTo(BigDecimal other) 如果这个大实数与other相等，返回0；如果这个大实数小于other，返回负数；否则，返回正数
- static BigDecimal valueOf(long x), static BigDecimal valueOf(long x, int scale) 返回值等于x或x/10^scale的一个大实数

静态的valueOF方法可以将普通的数值转换为大数

不能使用算术运算符处理大数，而需要使用大数类中的add和multiply方法

Java没有提供运算符重载功能

## 数组

数字数组元素初始值为0，boolean元素初始值为false，对象数组元素初始值为null

Java中的[]运算符被预定义为会完成越界检查，而且没有指数运算不能通过加1得到下一个元素

java.util.Arrays

- static void fill(xxx[] a, xxx[] v) 将数组的所有数据元素设置为v
- static void sort(xxx[] a) 使用优化的快速排序算法对数组进行排序
- static String toString(xxx[] a) 返回包含a中元素的一个字符串，这些元素用中括号包围，并用逗号分隔。在这个方法以及后面的方法，数组元素类型xxx可以是int、long、short、char、byte
boolean、float或double
- static xxx[] copyOf(xxx[] a, int end), static xxx[] copyOfRange(xxx[] a, int start, int end)
返回与a类型相同的一个数组，其长度为length或者end-start，数组元素为a的值。如果end大于a.length，结果会填充0或false的值
- static boolean equals(xxx[] a, xxx[] b) 如果两个数组大小相同，并且下标相同的元素都对应相等，返回true
- static int binarySearch(xxx[] a, xxx v), static int binarySearch(xxx[] a, int start, int end, xxx v)
使用二分查找算法在有序数组a中查找值v。如果找到v，则返回相应的下标；否则，返回一个负数值r。-r-1是v应插入的位置（为保持a有序）
