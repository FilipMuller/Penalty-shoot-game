package Fotball;

import java.util.Random;

public class Game {
    private Team team1;
    private Team team2;
    private Player shooter;
    private Player goalkeeper;

    public Game(String team1Name, String team2Name) {
        this.team1 = new Team(team1Name);
        this.team2 = new Team(team2Name);
        this.shooter = new Player("Shooter");
        this.goalkeeper = new Player("Goalkeeper");
    }

    public void play() {
        System.out.println("Welcome to Penalty Shootout Game!");
        System.out.println("Team 1: " + team1.getName() + " vs Team 2: " + team2.getName());
        waitThreeSecond();

        Random random = new Random();
        boolean team1Starts = random.nextBoolean();

        if (team1Starts) {
            System.out.println("Team 1 starts!");
            waitThreeSecond();
            shootPenalties(team1, team2);
        } else {
            System.out.println("Team 2 starts!");
            waitThreeSecond();
            shootPenalties(team2, team1);
        }

        waitThreeSecond();
        if (team1.getScore() > team2.getScore()) {
            System.out.println("Congratulations to " + team1.getName() + "! You won the penalty shootout!");
        } else {
            System.out.println("Congratulations to " + team2.getName() + "! You won the penalty shootout!");
        }
    }

    private void shootPenalties(Team attackingTeam, Team defendingTeam) {
        boolean isAttackingTeamTurn = true;

        while (attackingTeam.getScore() < 5 && defendingTeam.getScore() < 5) {
            if (isAttackingTeamTurn) {
                int shooterScore = shooter.shoot();
                int goalkeeperScore = goalkeeper.shoot();

                if (shooterScore > goalkeeperScore) {
                    attackingTeam.incrementScore();
                    System.out.println("Goal! " + attackingTeam.getName() + " scores! (X)");
                } else {
                    System.out.println("Save! " + defendingTeam.getName() + " goalkeeper saves! (O)");
                }

                System.out.println("Score: " + attackingTeam.getName() + " " + attackingTeam.getScore() +
                        " - " + defendingTeam.getName() + " " + defendingTeam.getScore());
            } else {
                int shooterScore = goalkeeper.shoot();
                int goalkeeperScore = shooter.shoot();

                if (shooterScore > goalkeeperScore) {
                    defendingTeam.incrementScore();
                    System.out.println("Goal! " + defendingTeam.getName() + " scores! (X)");
                } else {
                    System.out.println("Save! " + attackingTeam.getName() + " goalkeeper saves! (O)");
                }

                System.out.println("Score: " + attackingTeam.getName() + " " + attackingTeam.getScore() +
                        " - " + defendingTeam.getName() + " " + defendingTeam.getScore());
            }

            waitThreeSecond();
            isAttackingTeamTurn = !isAttackingTeamTurn;
        }
    }

    private void waitThreeSecond() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
