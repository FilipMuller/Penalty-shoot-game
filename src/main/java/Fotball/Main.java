package Fotball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name for Team 1: ");
        String team1Name = scanner.nextLine();

        System.out.println("Enter name for Team 2: ");
        String team2Name = scanner.nextLine();

        Game game = new Game(team1Name, team2Name);
        game.play();
    }
}
