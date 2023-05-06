/*
 * Author - Debag101
 * Purpose - MineSweeper
 * Date - 6 5 2023
 */
import java.util.*;

public class Minesweeper {
    //Creating Random object
    static Random rand = new Random();
    //Maximum number of tries
    static int tries = 10;

    //Method to print board
    public static void printBoard(int[][] board, int size) {
        for (int i = 0; i < size; i++)
            System.out.println(Arrays.toString(board[i]));
    }
    //Method to create board
    public static int[][] BoardGenerator(int side) {
        int[][] Board = new int[side][side];
        for (int i = 0; i < side; i++)
            Arrays.fill(Board[i], 0);

        return Board;

    }
    //Method to generate bombed board
    public static int[][] bombPlacer(int side) {
        int[][] bombBoard = new int[side][side];
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (rand.nextBoolean())
                    bombBoard[i][j] = -1;
            }
        }
        return bombBoard;
    }
    //Running the game
    public static void play(int[][] NB, int[][] BB, int size)  {
        Scanner rd = new Scanner(System.in);
        for (int i = 0; i < tries; i++) {
            System.out.println("Current Board => ");
            printBoard(NB, size);
            while (true) {
                System.out.println(">> Enter the row index for the safe square");
                int row = rd.nextInt();
                System.out.println(">> Enter safe index for coloumn sqaure");
                int coloumns = rd.nextInt();
                if (row >= size || row < 0 || coloumns >= size || coloumns < 0)
                    System.out.println("Invalid Sqaure");
                else {
                    if (BB[row][coloumns] == -1) {
                        System.out.println("You lost there was a bomb there !");
                        NB[row][coloumns] = -1;
                        printBoard(NB, size);
                        System.exit(0);
                    } else if (BB[row][coloumns] == 0) {
                        NB[row][coloumns] = 1;
                        System.out.println("You are safe !!");
                        break;
                    } else if (BB[row][coloumns] == 1) {
                        System.out.println("Sqaure has already been pressed !");
                        break;
                    }
                }

            }
        }
        System.out.println(">> You have won !!!");
        rd.close();
    }

    //Main method
    public static void main(String[] args) {
        int squares = rand.nextInt(4, 11);
        int[][] Board, BombedBoard;
        Board = BoardGenerator(squares);
        BombedBoard = bombPlacer(squares);
        play(Board, BombedBoard, squares);
        System.out.printf(">> The board has %d rows and %d coloumns ", squares, squares);
    }
}
