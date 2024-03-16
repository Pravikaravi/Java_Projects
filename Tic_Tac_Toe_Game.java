import java.util.Scanner;

public class Tic_Tac_Toe_Game{
	
    private static char[][] board = new char[3][3];
    // Current player (X or O)
    private static char currentPlayer = 'X';
    // Number of turns played
    private static int turnsPlayed = 0;

    // Initialize the game board
    private static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    // Print the game board
    private static void printBoard() {
        System.out.println("  0 1 2");
        for (int row = 0; row < 3; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Check if the game is over (win or tie)
    private static boolean isGameOver() {
        return isWin() || isTie();
    }

    // Check if any player has won the game
    private static boolean isWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    // Check if the game is a tie (board is full)
    private static boolean isTie() {
        return turnsPlayed == 9;
    }

    // Check if any row has all the same marks
    private static boolean checkRows() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != '-' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }
        return false;
    }

    // Check if any column has all the same marks
    private static boolean checkColumns() {
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != '-' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }
        return false;
    }

    // Check if any diagonal has all the same marks
    private static boolean checkDiagonals() {
        return (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    // Switch player
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Make a move on the board
    private static void makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            turnsPlayed++;
            switchPlayer();
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the game
        initializeBoard();

        // Main game loop
        while (!isGameOver()) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn");
            System.out.print("Enter row and column (e.g., 0 0): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            makeMove(row, col);
        }

        // Game over, print final board and result
        printBoard();
        if (isWin()) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
