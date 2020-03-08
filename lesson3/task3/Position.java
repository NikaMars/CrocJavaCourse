package croc.task3;

/**
 * Позиция на шахматной доске
 */
public class Position {
    private int x = 0;
    private int y = 0;

    Position() {

    }

    Position(int x, int y) {
        this.x = setPosition(x, ChessDesk.xMax);
        this.y = setPosition(y, ChessDesk.yMax);
    }

    public void setX(int x) {
        this.x = setPosition(x, ChessDesk.xMax);
    }

    public void setY(int y) {
        this.y = setPosition(y, ChessDesk.yMax);
    }

    private int setPosition(int coordinate, int maxValue) {
        if (coordinate > maxValue || coordinate < 0) {
            throw new IllegalArgumentException("Не правильная координата " + coordinate);
        } else {
            return coordinate;
        }
    }

    private String positionAlphabetX = "abcdefgh";

    @Override
    public String toString() {
        return "" + positionAlphabetX.charAt(x) + (y + 1);
    }

}
