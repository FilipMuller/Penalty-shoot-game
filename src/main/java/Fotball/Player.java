package Fotball;

import java.util.Random;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int shoot() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
