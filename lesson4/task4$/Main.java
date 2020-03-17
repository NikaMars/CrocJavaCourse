package croc.task4$;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Задача 4*
 * <p>
 * Вы разрабатываете систему в микросервисной архитектуре,
 * в которой сервисы в процессе работы записывают логи в отдельные файлы.
 * Каждая строка файла лога имеет вид:
 * <p>
 * time message\n
 * <p>
 * где time - время в формате POSIX time (количество миллисекунд с 1 января 1970 года), message - произвольный текст.
 * Строки в логах всегда отсортированы по времени в порядке возрастания.
 * Сервисов в системе много, и вы обнаружили, что при анализе ошибок тратите слишком много времени,
 * так как приходится восстанавливать общий порядок действий в системе по большому количеству разных логов.
 * Для оптимизации работы вы решили реализовать утилиту «слияния» нескольких логов в один общий.
 * Утилита в качестве аргументов командной строки принимает пути к файлам логов (произвольное количество)
 * и записывает в стандартный поток вывода результат: общую последовательность строк лога в порядке возрастания времени.
 * <p>
 * Реализуйте эту утилиту, имея в виду, что логи бывают большими и не всегда могут поместиться в оперативной памяти целиком.
 */
public class Main {
    //args - пути до разных файлов с логами
    public static void main(String[] args) {

//        String log1Path = "C:\Users\Veronika\IdeaProjects\Homework\src\croc\task4$.Log1.txt";
//        String log2Path = "C:\Users\Veronika\IdeaProjects\Homework\src\croc\task4$\log2.txt";
//        String log3Path = "C:\Users\Veronika\IdeaProjects\Homework\src\croc\task4$\log3.txt";
//
//        String[] logs = {log1Path, log2Path, log3Path};
        String[] logs = args;

        List<LogFile> logFiles = new ArrayList<>();
        for (String log : logs) {
            File myObj = new File(log);
            try {
                Scanner myReader = new Scanner(myObj);
                LogFile logFile = new LogFile(myReader);
                logFiles.add(logFile);
            } catch (FileNotFoundException e) {
                System.out.println("Файл " + log + " не найден. Проверьте, что путь полный.");
                throw new RuntimeException(e);
            }
        }

        /*
        Читаем по одной строчке из всех логов, чтобы понять какое событие произошло раньше.
        Как только нашли такую строчку, выводим ее и в этом файле читаем следующую, а в остальных следующую не читаем.
         */
        while (logFiles.size() > 0) {
            List<Integer> indexesOfEmptyLog = new ArrayList<>();
            for (int i = 0; i < logFiles.size(); i++) {
                LogFile s = logFiles.get(i);
                if (s.currentLine == null && !s.hasNextLine()) {
                    indexesOfEmptyLog.add(i);
                }
                if (s.currentLine == null && s.hasNextLine()) {
                    s.getNextLine();
                }
            }

            //Удаляем из списка логи, в которых закончились строчки.
            for (int i : indexesOfEmptyLog) {
                logFiles.remove(i);
            }
            if (logFiles.size() > 0) {
                int minIndex = getMinTimeLineIndex(logFiles);
                System.out.println(logFiles.get(minIndex).currentLine);
                logFiles.get(minIndex).currentLine = null;
            }
        }
    }

    /**
     * Проверка, что во всех файлах логов закончились строчки.
     */
    private static boolean isAllLogFinished(List<LogFile> logFiles) {
        for (LogFile logFile : logFiles) {
            if (logFile.hasNextLine()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Индекс лога в списке логов, у которого на текущей строчке минимальное время.
     */
    private static int getMinTimeLineIndex(List<LogFile> logFiles) {
        int minTimeLogIndex = 0;
        long minTimeLog = getTime(logFiles.get(minTimeLogIndex).currentLine);

        for (int i = 0; i < logFiles.size(); i++) {
            String line = logFiles.get(i).currentLine;
            long time = getTime(line);
            if (time < minTimeLog) {
                minTimeLog = time;
                minTimeLogIndex = i;
            }
        }

        return minTimeLogIndex;
    }

    /**
     * Парсим строку, чтобы достать время.
     */
    private static long getTime(String line) {
        return Long.parseLong(line.substring(0, line.indexOf(" ")));
    }
}
