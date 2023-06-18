import java.util.*;

public class TicTacToe
{
    static int[][] board = new int[3][3];
    static Scanner user = new Scanner(System.in);

    public static void main (String[] args)
    {
        boardSetup();
        printBoard();

        for (int i = 0; i < 9; i++)
        {
            placeX();
            printBoard();
            if (checkWin(1))
            {
                victory("X");
            }
            placeO();
            printBoard();
            if (checkWin(2))
            {
                victory("O");
            }
        }
        System.out.println("You have tied!");
        user.close();
    } // main

    public static void printBoard ()
    {
        for (int i = 0; i < 3; i++)
        {   
            for (int j = 0; j < 3; j++)
            {
                int currSymbol = board[i][j];
                
                if (currSymbol == 1)
                {
                    System.out.print(" X ");
                    if (j < 2)
                    {
                        System.out.print("|");
                    } // if
                } else if (currSymbol == 2)
                {
                    System.out.print(" O ");
                    if (j < 2)
                    {
                        System.out.print("|");
                    } // if
                } else {
                    System.out.print(" - ");
                    if (j < 2)
                    {
                        System.out.print("|");
                    } // if
                } // if
            } // for

            if (i < 2)
            {
                System.out.print("\n-----------\n");
            } // if
        } // for
        System.out.println();
    } // printBoard

    public static void boardSetup ()
    {
        for (int i = 0; i < 3; i++)
        {   
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = 0;
            } // for
        } // for
    } // boardSetup

    public static void placeX ()
    {
        System.out.print("Type the coordinates for \'X\' seperated by spaces or -1 to quit the game.\t");
        int coordX = user.nextInt();
        if (coordX == -1)
        {
            System.exit(0);
        } // if
        int coordY = user.nextInt();
        user.nextLine();

        if (coordX >= 0 && coordX < 3 && coordY >= 0 && coordY < 3)
        {
            if (board[coordY][coordX] == 0)
            {
                board[coordY][coordX] = 1;
            } // if
        } else {
            System.out.println("Invalid Placement!");
            placeX();
        } // if
    } // placeX

    public static void placeO ()
    {
        System.out.print("Type the coordinates for \'O\' seperated by spaces or -1 to quit the game.\t");
        int coordX = user.nextInt();
        if (coordX == -1)
        {
            System.exit(0);
        } // if
        int coordY = user.nextInt();
        user.nextLine();

        if (coordX >= 0 && coordX < 3 && coordY >= 0 && coordY < 3)
        {
            if (board[coordY][coordX] == 0)
            {
                board[coordY][coordX] = 2;
            } //if
        } else {
            System.out.println("Invalid Placement!");
            placeO();
        } // if
    } // placeO

    public static boolean checkWin (int symbol)
    {
        if (board[0][0] == symbol && board[0][0] == board[0][1] && board[0][0] == board[0][2])
        {
            return true;
        } // if

        if (board[1][0] == symbol && board[1][0] == board[1][1] && board[1][0] == board[1][2])
        {
            return true;
        } // if

        if (board[2][0] == symbol && board[2][0] == board[2][1] && board[2][0] == board[2][2])
        {
            return true;
        } // if

        if (board[0][0] == symbol && board[0][0] == board[1][0] && board[0][0] == board[2][0])
        {
            return true;
        } // if

        if (board[0][1] == symbol && board[0][1] == board[1][1] && board[0][1] == board[2][1])
        {
            return true;
        } // if

        if (board[0][2] == symbol && board[0][2] == board[1][2] && board[0][2] == board[2][2])
        {
            return true;
        } // if

        if (board[0][0] == symbol && board[0][0] == board[1][1] && board[0][0] == board[2][2])
        {
            return true;
        } // if

        if (board[0][2] == symbol && board[2][0] == board[1][1] && board[2][0] == board[0][2])
        {
            return true;
        } // if

        return false;
    } //checkWin

    public static void victory (String victor)
    {
        System.out.println("Congratulations!," + victor + " has won the game!");
        System.exit(0);
    } // victory
} // TicTacToe