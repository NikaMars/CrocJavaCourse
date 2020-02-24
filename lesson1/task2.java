package croc.task2;

import java.util.Locale;

/**
 * Задача 2.
 * <p>
 * Написать метод, форматирующий и выводящий на экран
 * заданный размер в байтах в человекочитаемом виде.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(printBytes(23));
        System.out.println(printBytes(1024));
        System.out.println(printBytes(2024));
        System.out.println(printBytes(53692044905543L));
        System.out.println(printBytes(536920000004490553L));
        System.out.println(printBytes(Long.MAX_VALUE));
    }

    /**
     * Преобразует число, представляющее собой число байт в человеко-читаемый вид.
     * {целая часть <= 1024}.{дробная часть макс. 1 знак} {единица измерения}
     * <p>
     * printBytes(23) -> "23.0 B"
     * printBytes(1024) -> "1.0 KB"
     * printBytes(53692044905543) -> "48.8 TB"
     */
    public static String printBytes(long bytes) {
        if (bytes < 0) {
            return "Error value";
        }

        if (bytes < 1024) {
            return bytes + ".0 B";
        }
        int measure = 1; //степень
        double d = bytes / 1024d;
        while (d > 1024) {
            measure++;
            d = d / 1024d;
        }
//        System.out.println(bytes + " " + measure + " " + d);

        //При форматировании будет округление 1.97 -> 2.0
        return String.format(Locale.US, "%.1f", d) + " " + getMeasure(measure);
    }

    /**
     * Приставка, обозначающая степень: кило, мега, гига, тера, пета, экза.
     */
    public static String getMeasure(int measure) {
        switch (measure) {
            case 1:
                return "KB";
            case 2:
                return "MB";
            case 3:
                return "GB";
            case 4:
                return "TB";
            case 5:
                return "PB";
            case 6:
                return "EB";
            default:
                return "Слишком большое число";//Никогда не произойдет, т.к. весь long умещается
        }
    }
}
