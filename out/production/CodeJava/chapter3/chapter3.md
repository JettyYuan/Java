# 规范

## 命名规范

不能使用Java保留字
类名以大写字母开头遵循骆驼命名法

## Java语言规范

main方法必须声明为public

# 数据类型

## 整型

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

## 浮点类型

| 类型     | 存储需求 | 有效位数 |
|--------|------|------|
| float  | 4字节  | 6~7位 |
| double | 8字节  | 15位  |

float类型数值后缀F或f

十六进制表示法中，使用p表示指数，尾数采用十六进制，指数采用十进制

用于表示溢出和出错情况的三个特殊浮点数值：

- 正无穷大 Double.POSITIVE_INFINITY
- 负无穷大 Double.NEGATIVE_INFINITY
- NaN（不是一个数字）Double.NaN

Double.isNaN方法判断NaN

## boolean类型

整型值和布尔值之间不能进行相互转换

# 量

## 变量

Java中“字母”和“数字”的范围更大

不能使用未初始化的变量

对于局部变量，如果可以从变量的初始值推断出它的类型就不再需要声明类型，只需要使用关键字var

## 常量

常量：final 一般常量名使用全大写

类常量：static final 一个类的多个方法使用

如果一个常量被声明为public，那么其他类的方法也可以使用这个常量

# 运算符

## 算术运算符

整数被0除将会产生一个异常，而浮点数被0除将会得到无穷大或NaN结果

如果将一个类标记为strictfp，这个类中的所有方法都要使用严格的浮点计算

## 数学函数

Math类的部分方法与值

- Math.sin Math.cos Math.tan Math.atan Math.atan2
- Math.exp Math.log Math.log10
- Math.PI Math.E
- Math.multiplyExact 捕获异常终止程序
- Math.round 对浮点数进行舍入运算得到最接近整数的结果 返回值long型
- Math.random 随机返回0 ~ 1之间（包含0不包含1）的浮点数

如果得到一个完全可预测的结果比运行速度更重要的话，使用StrictMath类multiplyExact

## 强制类型

强制类型转换通过截断小数部分将浮点值转换为整数

不要在boolean类型与任何数值类型之间进行强制类型转换

## 自增、自减运算符

不要在表达式中使用++或--

## 字符串

任何一个Java对象都可以转换成字符串

不要使用==运算符检测两个字符串是否相等

CharSequence形参可以传入String实参

String类的部分方法

- substring 从大字符串提取小字符串
- join 将多个字符串放在一起并用界定符分隔
- repeat 重复字符串
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
- int lastIndexOf(String str), int lastIndexOf(String str, int fromIndex), int lastindexOf(int cp), int lastindexOf(int cp, int fromIndex)
返回与字符串str或码点cp匹配的最后一个子串的位置。从原始字符末尾或fromIndex开始匹配

StringBuilder类调用StringBuilder方法构建字符串构建器，调用append方法添加内容，构建完成调用toString方法得到String对象

Console类可以隐式读取输入的一行字符

## 格式化输出

printf方法参数索引值从1开始

数字和日期的格式化规则是特定于本地化环境的

String.format方法创建格式化字符串而不打印输出

## 文件输入输出



# 大数

BigInteger类实现任意精度的整数运算

BigDecimal类实现任意精度的浮点数运算

静态的valueOF方法可以将普通的数值转换为大数

不能使用算术运算符处理大数，而需要使用大数类中的add和multiply方法

Java没有提供运算符重载功能

# 数组

数字数组元素初始值为0，boolean元素初始值为false，对象数组元素初始值为null

Java中的[]运算符被预定义为会完成越界检查，而且没有指数运算不能通过加1得到下一个元素

Arrays类的部分方法

- Arrays.copyOf 将一个数组所有元素拷贝到一个新数组
- Arrays.sort 对数值型数组进行排序