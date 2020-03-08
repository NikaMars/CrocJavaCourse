package croc.task3$;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


//        String[] movementsAll = new String[]{"g8", "e7", "e6"}; //Ходы конем. // [out] "конь так не ходит: e7 -> e6"
//        String[] movementsAll = new String[]{"g8", "e7", "c8"};
        String[] movementsAll = new String[]{"b1", "a3", "c4", "d6"};
        String[] movements = new String[movementsAll.length - 1];

        for (int i = 0; i < movements.length; i++) {
            movements[i] = movementsAll[i + 1];
        }


        Position p1 = new Position();
        p1.setPosition(movementsAll[0]);

        ChessKnight knight = new ChessKnight(p1);
        System.out.println(Arrays.toString(movementsAll));

        if (knight.checkSequence(Position.convertPositions(movements))) {
            System.out.println("ОК");
        }

    }
}
