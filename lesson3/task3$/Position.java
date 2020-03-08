package croc.task3$;

import croc.task3.ChessDesk;

import java.util.IllegalFormatException;

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Установка координаты по строке.
     *
     * @param p, например g8.
     */
    public void setPosition(String p) {
        try {
            if (p.length() == 2 &&
                    positionAlphabetX.contains("" + p.charAt(0))) {

                int x = positionAlphabetX.indexOf(p.charAt(0));
                int y = Integer.parseInt("" + p.charAt(1))-1;

                this.x = setPosition(x, croc.task3$.ChessDesk.xMax);
                this.y = setPosition(y, croc.task3$.ChessDesk.yMax);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Не правильная координата " + p);
        }
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


    public static Position[] convertPositions(String[] positions) {
        Position[] positions1 = new Position[positions.length];
        int i = 0;
        for (String s : positions) {
            Position p = new Position();
            p.setPosition(s);

            positions1[i] = p;
            i++;
        }
        return positions1;
    }

    @Override
    public String toString() {
        return "" + positionAlphabetX.charAt(x) + (y + 1);

    }
}
