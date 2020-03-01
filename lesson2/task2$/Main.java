package croc.task2$;

import croc.task2.*;

/**
 * От пользователей приложения пришел запрос на возможности перемещать уже размеченные области.
 * Для поддержки новой функциональности вам требуется внести несколько изменений:
 * <p>
 * 1) выбор аннотации по координатам точки (x, y);
 * В массиве аннотаций требуется найти первую, фигура которой содержит точку с заданными координатами.
 * Annotation findByPoint(Annotation[] annotations, int x, int y) {
 * // ...
 * }
 * <p>
 * 2) перемещение фигуры выбранной аннотации на смещение (dx, dy);
 * В рамках этого изменения вы решили доработать классы фигур таким образом, чтобы они реализовывали интерфейс
 * public interface Moveable {
 * void move(int dx, int dy);
 * }
 * <p>
 * Доработайте классы и реализуйте метод findByPoint.
 */


public class Main {

    Annotation findByPoint(Annotation[] annotations, Point p) {
        boolean flag = false;
        for (Annotation a : annotations) {
            if (a.figure.isInFigure(p)) {
                flag = true;
                System.out.println("Точка " + p + " принадлежит " + a.figure);
                break;
            }
        }

        if (!flag) {
            System.out.println("Точка " + p + " находится вне области");
        }


        return null;
    }

    public static void main(String[] args) {

        int numOfAnnotations = 4;
        Annotation[] annotations = new Annotation[numOfAnnotations];

        Point p1 = new Point(-1, 4);
        Point p2 = new Point(3, 10);
        Point p0 = new Point(0, 2);
        Point p3 = new Point(-2, 7);
        Point p4 = new Point(11, 10);


        Figure circle1 = new Circle(p0, 10); //(x, y, radius)
        Figure rectangle1 = new Rectangle(p1, p2); //(x1, y1, x2, y2)
        Figure circle2 = new Circle(p1, 7);
        Figure rectangle2 = new Rectangle(p3, p4);

        Annotation ant1 = new Annotation(circle1, "Круг 1");
        Annotation ant2 = new Annotation(circle2, "Круг 2");
        Annotation ant3 = new Annotation(rectangle1, "Прямоугольник 1");
        Annotation ant4 = new Annotation(rectangle2, "Прямоугольник 2");

        annotations[0] = ant1;
        annotations[1] = ant3;
        annotations[2] = ant2;
        annotations[3] = ant4;


        Main m = new Main();
        m.findByPoint(annotations, new Point(6, 8));
        System.out.println(circle1);
        circle1.move(2, 2);
        System.out.println(circle1);

        System.out.println(rectangle1);
        rectangle1.move(2, 2);
        System.out.println(rectangle1);
    }
}
