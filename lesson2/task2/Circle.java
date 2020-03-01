package croc.task2;

public class Circle extends Figure {
    int r;
    Point p0;

    public Circle(Point p0, int r) {
        this.p0 = p0;
        this.r = r;
    }

    //принадлежность кругу
    public boolean isInFigure(Point p) {
        if ((p.x - p0.x) * (p.x - p0.x) + (p.y - p0.y) * (p.y - p0.y) <= r * r) {
            return true;
        }
        return false;
    }

    @Override
    public void move(int dx, int dy) {
        p0.x = p0.x + dx;
        p0.y = p0.y + dy;
    }

    @Override
    public String toString() {
        return "Круг с центром в" + p0 + " и радиусом " + r;
    }
}
