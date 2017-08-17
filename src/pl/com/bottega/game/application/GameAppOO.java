package pl.com.bottega.game.application;

import pl.com.bottega.game.engine.*;

import java.util.Scanner;

public class GameAppOO {

    public static Player player1;
    public static Player player2;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        try {
            initializePlayers();
            short gamesCount = readGamesCount();
            SoundDevice speaker = Sound();

            //HumanPlayer human = new HumanPlayer("Andrzej");

            Arbiter arbiter = new Arbiter(gamesCount, player1, player2);
            ScoreBoard primaryScoreBoard = new ScoreBoard(gamesCount, player1.getName(), player2.getName(), speaker);

            Arbiter.GameResult result;
            do {
                result = arbiter.playRound();
                primaryScoreBoard.refresh(result);
            } while (result != Arbiter.GameResult.GAME_OVER);

            System.out.println(arbiter.generateReport());
        }
        catch(Exception ex){
                System.out.println("Nieoczekiwany blad " + ex.getMessage());
            }
        }

    private static Player initializePlayers() {
        System.out.println("Wybierz rodzaj graczy: 1, 2 lub 3");
        System.out.println("1: human vs computer");
        System.out.println("2: computer vs computer");
        System.out.println("3: human vs human");
        int wybor = scanner.nextInt();
        scanner.nextLine();

        switch (wybor) {
            case 1:
                System.out.println("Podaj imie gracza:");
                String playerName = scanner.nextLine();
                player1 = new HumanPlayer(playerName);
                player2 = new SmartComputerPlayer("HAL");
                break;
            case 2:
                player1 = new ComputerPlayer("HAL");
                player2 = new SmartComputerPlayer("Deep Blue");
                break;
            case 3:
                System.out.println("Podaj imie gracza 1:");
                String player1name = scanner.nextLine();
                System.out.println("Podaj imie gracza 2:");
                String player2Name = scanner.nextLine();
                player1 = new HumanPlayer(player1name);
                player2 = new HumanPlayer(player2Name);
                break;
                    }
        return null;
    }

    private static short readGamesCount() {
        System.out.print("Podaj ilosc gier: ");
        short count = scanner.nextShort();
        scanner.nextLine();
        return count;
    }

    private static SoundDevice Sound() {

        System.out.println("Wybierz rodzaj fanfar: Wcisnij 1 jezeli wybierasz Sony, Wcisnij 2 jezeli wybierasz Bose, Wcisnij 3 jezeli wybierasz Manta");
        int s = scanner.nextInt();
        scanner.nextLine();
        switch (s) {
            case 1:
                return new SonyDevice();
            case 2:
                return new BoseDevice();
            case 3:
                return new MantaDevice();
            default:
                return null;
        }
    }

}

