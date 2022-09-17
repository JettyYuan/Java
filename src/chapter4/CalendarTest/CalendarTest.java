/**
 * @version 18 2022-09-17
 * @author Jetty
 */
package chapter4.CalendarTest;

import java.time.DayOfWeek;
import java.time.LocalDate;

// 类: 打印当前日期的月的日历并用*标记当前日期的日
public class CalendarTest {
    // 方法: main
    public static void main(String[] args) {
        LocalDate date = LocalDate.now(); // 当前日期
        int month = date.getMonthValue(); // 当前日期的月
        int today = date.getDayOfMonth(); // 当前日期的日
        date = date.minusDays(today - 1); // 重置date为当前月第一天日期
        DayOfWeek weekday = date.getDayOfWeek(); // 当前日期的星期
        int value = weekday.getValue(); // 根据星期设置对应的int值
        // 日历的第一行是缩进的，缩进到对应的日期下
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        // 遍历当前日期的月的所有日并打印
        while (date.getMonthValue() == month) { // 设置date的月为当前日期的月
            System.out.printf("%3d", date.getDayOfMonth()); // 格式化输出date的日
            // 如果date的日与当前日期的日对应就使用*标记
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            // 重置date为原date的后一天
            date = date.plusDays(1);
            // 如果date对应日期所对应的int值为1，则换行
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        // 如果date对应日期所对应的int值不为1，则换行
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}
