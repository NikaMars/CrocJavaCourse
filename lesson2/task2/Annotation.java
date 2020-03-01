package croc.task2;

/**
 * Класс состоит из подписи и фигуры
 */

public class Annotation {

    //подпись
    String signature = "";

    //фигура
    public Figure figure;

    public Annotation(Figure f, String s) {
        figure = f;
        signature = s;
    }

    @Override
    public String toString() {
        return "Подпись = " + signature + " - " + "Фигура = " + figure;
    }
}
