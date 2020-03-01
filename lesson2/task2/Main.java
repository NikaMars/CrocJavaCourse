package croc.task2;

import java.util.Arrays;
import java.awt.geom.Arc2D.Double;
import java.awt.geom.Area;
import java.awt.Dimension;

/**
 * Задача 2
 * Вы разрабатываете небольшое приложение по аннотированию (разметке) изображений
 * с целью последующего использования этой разметки для обучения моделей computer vision.
 * В этом приложении пользователь может выделять области на изображении с помощью прямоугольников и окружностей
 * и подписывать их произвольным текстом.
 * Прямоугольники определяются координатами левого нижнего и правого верхнего углов,
 * а окружности - координатами центра и радиусом.
 * <p>
 * Вся разметка для изображения представляется массивом Annotation[].
 * Определите класс Annotation для представления данных разметки (подпись + фигура)
 * и классы Figure, BoundingBox, Circle для задания размеченных областей.
 */

public class Main {


    public static void main(String[] args) {

        int numOfAnnotations = 4;
        Annotation[] annotations = new Annotation[numOfAnnotations];

        Point p1 = new Point(-1,4);
        Point p2 = new Point(3,10);
        Point p0 = new Point(0,2);
        Point p3 = new Point(-2,7);
        Point p4 = new Point(11,10);


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

        System.out.println(Arrays.toString(annotations));


    }
}
