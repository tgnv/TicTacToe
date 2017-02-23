import java.util.Random;

public class TicTacToe {

    public static int field[] = new int[9];

    enum round {PLAYER1, PLAYER2}

    public static void main(String[] args) {
        round currentRound = round.PLAYER1;

        for (int i = 0; i < 9; i++)
        {
            field[i] = 0;
        }

        System.out.print("\u001b[2J"); // Erase entire window
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

    public static void drawPlayBoard() {
        System.out.print("\u001b[1;1H"); // Erase entire window

        System.out.println(figure(field[0]) + " | " + figure(field[1]) + " | " + figure(field[2]));
        System.out.println("---------");
        System.out.println(figure(field[3]) + " | " + figure(field[4]) + " | " + figure(field[5]));
        System.out.println("---------");
        System.out.println(figure(field[6]) + " | " + figure(field[7]) + " | " + figure(field[8]));
    }

    public static char figure (int i) {
        switch (i) {
            case 0 :
                return ' ';
            case 1 :
                return 'X';
            case 2:
                return 'O';
            default:
                return ' ';
        }
    }
}

