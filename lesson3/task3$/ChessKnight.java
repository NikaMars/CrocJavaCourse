package croc.task3$;

/**
 * Конь. Ходит буквой Г
 */
public class ChessKnight {

    private Position currentPosition; //Текущая позиция коня.

    ChessKnight(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    /**
     * Проверяет, может ли конь ходить таким набором ходов.
     *
     * @return
     */
    public boolean checkSequence(Position[] positions) {

        for (Position p : positions) {
            try {
                move(p);
            } catch (IllegalMoveException e) {
                System.out.println("конь так не ходит: " + this.currentPosition + " -> " + p);
                return false;
            }
        }
        return true;
    }


    void move(Position newPosition) throws IllegalMoveException {
        if (checkNewPosition(newPosition)) {
            this.currentPosition = newPosition;
        } else {
            throw new IllegalMoveException("Конь так не ходит");
        }
    }

    private boolean checkNewPosition(Position newPosition) {
        //вверх-вправо
        if (newPosition.getX() - 1 == currentPosition.getX() && newPosition.getY() - 2 == currentPosition.getY())
            return true;

        //вправо-вверх
        if (newPosition.getX() - 2 == currentPosition.getX() && newPosition.getY() - 1 == currentPosition.getY())
            return true;

        //вправо-вниз
        if (newPosition.getX() - 2 == currentPosition.getX() && newPosition.getY() + 1 == currentPosition.getY())
            return true;

        //вниз-вправо
        if (newPosition.getX() - 1 == currentPosition.getX() && newPosition.getY() + 2 == currentPosition.getY())
            return true;

        //вниз-влево
        if (newPosition.getX() + 1 == currentPosition.getX() && newPosition.getY() + 2 == currentPosition.getY())
            return true;

        //влево-вниз
        if (newPosition.getX() + 2 == currentPosition.getX() && newPosition.getY() + 1 == currentPosition.getY())
            return true;

        //влево-вверх
        if (newPosition.getX() + 2 == currentPosition.getX() && newPosition.getY() - 1 == currentPosition.getY())
            return true;

        //вверх-влево
        if (newPosition.getX() + 1 == currentPosition.getX() && newPosition.getY() - 2 == currentPosition.getY())
            return true;

        return false;
    }


}
