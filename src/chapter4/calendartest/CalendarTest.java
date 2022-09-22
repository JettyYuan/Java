package chapter4.calendartest;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @version 18 2022-09-17
 * @author Jetty
 */
public class CalendarTest {
    public static void main(final String[] args) {
        // 当前日期
        LocalDate date = LocalDate.now();
        // 当前日期的月
        int month = date.getMonthValue();
        // 当前日期的日
        int today = date.getDayOfMonth();
        // 重置date为当前月第一天日期
        date = date.minusDays(today - 1);
        // 当前日期的星期
        DayOfWeek weekday = date.getDayOfWeek();
        // 根据星期设置对应的int值
        int value = weekday.getValue();
        // 日历的第一行是缩进的，缩进到对应的日期下
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        // 遍历当前日期的月的所有日并打印
        // 设置date的月为当前日期的月
        while (date.getMonthValue() == month) {
            // 格式化输出date的日
            System.out.printf("%3d", date.getDayOfMonth());
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
