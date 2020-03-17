package croc.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Задача 4
 * В текстовом файле слова могут быть разделены одним или несколькими пробелами и символами перевода строки.
 * Необходимо реализовать программу, считающую количество слов в файле и выводящую результат на экран.
 * Путь к файлу задается первым аргументом командной строки (args[0]).
 */

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("Путь к файлу задается первым аргументом командной строки (args[0])");
        }
        String filePath = args[0];

        File myObj = new File(filePath);
        int numOfWords = 0; //число слов в тексте
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                numOfWords += countWords(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + filePath + " не найден. Проверьте, что путь полный.");
        }

        System.out.println("Число слов в тексте: "+ numOfWords);
    }

    /**
    * Подсчет числа слов, разделенных пробелом в строке.
    */
    private static int countWords(String line) {
        String[] arr = line.split(" ");
        int i = 0;
        for (String a : arr) {
            if (a.trim().length() > 0) {
                i++;
            }
        }
        return i;
    }

}
