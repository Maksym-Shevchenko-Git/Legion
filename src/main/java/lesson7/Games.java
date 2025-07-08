package lesson7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Games {
    public enum GameType {
        SOCCER,
        HOCKEY,
        RUGBY
    }

    public static void main(String[] args) {

        writeNumOfPlayersPerTeam(fillInGames());

    }

    public static Map<Integer, GameType> fillInGames() {
        HashMap<Integer, Games.GameType> games = new HashMap<>();
        games.put(11, GameType.SOCCER);
        games.put(15, GameType.RUGBY);
        games.put(6, GameType.HOCKEY);

        return games;
    }

    public static void writeNumOfPlayersPerTeam(Map<Integer, GameType> game) {
        int num = getInput();

        switch (num) {
            case 11:
                createNewFile(11, game);
                break;
            case 15:
                createNewFile(15, game);
                break;
            case 6:
                createNewFile(6, game);
                break;
            default:
                System.out.println("Oops! No game found for the entered number of players (" + num + ").");
        }

    }

    private static void createNewFile(int i, Map<Integer, GameType> game) {
        try {
            FileWriter myWriter;
            try {
                myWriter = new FileWriter(System.getProperty("user.home") + "/Desktop/" + game.get(i) + ".txt");
                myWriter.write(String.valueOf(i));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getInput() {
        Scanner mScanner = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a number: ");
            try {
                num = mScanner.nextInt();
                if (num <= 0) {
                    System.out.println("Invalid input. Please try again.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException m) {
                System.out.println("Invalid input. Please try again.");
                mScanner.next();
            }
        }
        mScanner.close();

        return num;
    }
}
