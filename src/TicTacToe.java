package net.tgnv.Khasang;

import java.util.Random;

enum round {PLAYER1, PLAYER2}

public class TicTacToe {

    private static int field[] = new int[9];

    public static void main(String[] args) {
        round currentRound = round.PLAYER1;

        for (int i = 0; i < 9; i++)
        {
            field[i] = 0;
        }

        System.out.print("\u001b[1;1H\u001b[0J"); // Erase entire window
        drawPlayBoard();

        for (int n = 0; n < 9; n++) {
            java.util.Random random = new Random();
            int i = random.nextInt(9);
            while (field[i] != 0) {
                i = random.nextInt(9);
            }
            field[i] = (currentRound == round.PLAYER1) ? 1 : 2;
            drawPlayBoard();
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            currentRound = (currentRound == round.PLAYER1) ? round.PLAYER2 : round.PLAYER1;
        }
    }

    private static void drawPlayBoard() {
        System.out.print("\u001b[1;1H"); // Erase entire window

        System.out.println(" " + figure(field[0]) + " \u2503 " + figure(field[1]) + " \u2503 " + figure(field[2]));
        System.out.println("\u2501\u2501\u2501\u254B\u2501\u2501\u2501\u254B\u2501\u2501\u2501");
        System.out.println(" " + figure(field[3]) + " \u2503 " + figure(field[4]) + " \u2503 " + figure(field[5]));
        System.out.println("\u2501\u2501\u2501\u254B\u2501\u2501\u2501\u254B\u2501\u2501\u2501");
        System.out.println(" " + figure( field[6]) + " \u2503 " + figure(field[7]) + " \u2503 " + figure(field[8]));
    }

    private static String figure(int i) {
        switch (i) {
            case 0 :
                return " ";
            case 1 :
                return "\u001b[1;31mX\u001b[0m";
            case 2:
                return "\u001b[34mO\u001b[0m";
            default:
                return " ";
        }
    }
}

