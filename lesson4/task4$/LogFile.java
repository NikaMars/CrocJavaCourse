package croc.task4$;

import java.util.Scanner;

public class LogFile {
    public String currentLine = null;
    private Scanner scanner;

    LogFile(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public String getNextLine() {
        currentLine = scanner.nextLine();
        return currentLine;
    }

}
