package com.example.game;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        System.out.println("Welcome to the Minimal Text Adventure (no Maven)!");
        game.play();
    }
}
