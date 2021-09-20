import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class SudokuGame {

    int NUMBER_OF_LEVELS = 3;
    int NUMBER_OF_GAMES_PER_LEVEL = 12;
    int NUMBER_OF_ROWS = 9;
    int NUMBER_OF_COLS = 9;

    public static void main(String[] args) throws FileNotFoundException {
        new SudokuGame();
    }

    public SudokuGame() throws FileNotFoundException {
        Scanner sudokuDataBaseScanner = getSudokuDataBaseScanner();
        int[][][][] sudokuGames = getAllSudokuGames(sudokuDataBaseScanner);
        sudokuDataBaseScanner.close();
        goToMainMenu(sudokuGames);
    }

    private Scanner getSudokuDataBaseScanner() throws FileNotFoundException {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        Scanner scanner = new Scanner(file);
        return scanner;
    }

    private int[][][][] getAllSudokuGames(Scanner sudokuDataBaseScanner) {
        int[][][][] allSudokuGames = new int[NUMBER_OF_LEVELS][NUMBER_OF_GAMES_PER_LEVEL][NUMBER_OF_ROWS][NUMBER_OF_COLS];

        allSudokuGames[0] = getGamesForLevel(0, sudokuDataBaseScanner); // Beg
        allSudokuGames[1] = getGamesForLevel(1, sudokuDataBaseScanner); // Medium
        allSudokuGames[2] = getGamesForLevel(2, sudokuDataBaseScanner); // Hard

        return allSudokuGames;
    }

    private int[][][] getGamesForLevel(int level, Scanner sudokuDataBaseScanner) {
        int[][][] gamesForLevelN = new int[NUMBER_OF_GAMES_PER_LEVEL][NUMBER_OF_ROWS][NUMBER_OF_COLS];
        int gameNumber = 0;
        for (int i = 0; i < NUMBER_OF_GAMES_PER_LEVEL; i++) {
            int[][] currentGame = new int[NUMBER_OF_ROWS][NUMBER_OF_COLS];
            String line = sudokuDataBaseScanner.nextLine();
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                line = sudokuDataBaseScanner.nextLine();
                String[] items = line.split("(?!^)");
                for (int k = 0; k < NUMBER_OF_COLS; k++) {
                    currentGame[j][k] = Integer.parseInt(items[k]);
                }
            }
            gamesForLevelN[gameNumber] = currentGame;
            gameNumber++;
        }
        return gamesForLevelN;
    }

    private void goToMainMenu(int[][][][] allSudokuGames) {
        try (Scanner userInput = new Scanner(System.in)) {
            int chosenLevel = -1;
             while (chosenLevel != 4) {
                System.out.println("Enter level");
                System.out.println("1) Beginner \n2) Intermediate \n3) Advanced \n4) Exit");
                chosenLevel = Integer.parseInt(userInput.nextLine());
                if (chosenLevel < 4) {
                    int[][][] gamesForLevel = getAllGamesForLevel(chosenLevel, allSudokuGames);
                    printGamesPerLevel(gamesForLevel);
                    System.out.println("What game do you want to play?");
                    int chosenGame = Integer.parseInt(userInput.nextLine());
                    checkBounds(chosenGame);
                    int[][] game = getGame(chosenGame, gamesForLevel);
                    printGame(game); // 2d array
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private int[][][] getAllGamesForLevel(int level, int[][][][] allSudokuGames) {
        return allSudokuGames[level - 1]; // since arrays are 0 indexed
    }

    private void printGamesPerLevel(int[][][] sudokuGames) {
        for (int i = 0; i < NUMBER_OF_GAMES_PER_LEVEL; i++) {
            System.out.println("Game number: " + (i + 1));
            for (int j = 0; j < sudokuGames[i].length; j++) {
                for (int k = 0; k < sudokuGames[j].length; k++) {
                    System.out.print(sudokuGames[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("========================");
        }
    }

    private int[][] getGame(int gameNum, int[][][] gamesForLevel) {
        return gamesForLevel[gameNum-1];
    }

    private void printGame(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void checkBounds(int num) throws Exception {
        if (!(num >= 1 && num <= 12)) {
            throw new Exception("Choose a game between 1 and 12");
        }
    }

    // create the missing methods here...
}