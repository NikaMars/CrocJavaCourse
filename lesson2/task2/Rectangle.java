package croc.task2;

public class Rectangle extends Figure {
    //левая нижняя точка
    Point p1;
    //правая верхняя точка
    Point p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean isInFigure(Point p) {
        if (p.x >= p1.x && p.x <= p2.x && p.x >= p1.y && p.x <= p2.y) {
            return true;
        }
        return false;
    }

    @Override
    public void move(int dx, int dy) {
        p1.x = p1.x + dx;
        p1.y = p1.y + dy;
        p2.x = p2.x + dx;
        p2.y = p2.y + dy;
    }

    @Override
    public String toString() {
        return "Прямоугольник " + p1 + " " + p2;
    }
}
