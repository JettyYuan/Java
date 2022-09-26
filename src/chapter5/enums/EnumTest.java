package chapter5.enums;

import java.util.Scanner;

/**
 * 枚举Size，尺码
 *
 * @author Jetty
 * @version 18 2022-09-26
 */
enum Size {
    /**
     * SMALL: S 小
     * MEDIUM: M 中
     * LARGE: L 大
     * EXTRA_LARGE: XL 超大
     */
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    /**
     * abbreviation: 尺码缩写
     */
    private final String abbreviation;

    /**
     * @param abbreviation 尺码缩写
     */
    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}

/**
 * This program demonstrates enumerated types.
 *
 * @author Jetty
 * @version 18 2022-09-26
 */
public class EnumTest {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        // 输入大写字母字符串
        String input = in.next().toUpperCase();
        // 将输入的内容转化为枚举值
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        // "XL"时的提示
        if (size == Size.EXTRA_LARGE) System.out.println("Good job--you paid attention to the _.");
        in.close();
    }
}
