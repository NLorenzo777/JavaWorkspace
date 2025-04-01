package org.projects.simple.medievalserialization;

import java.io.*;
import java.util.Scanner;

public class MedievalGame {
    public static final String RESOURCES_DIR = "src/main/java/org/projects/simple" +
            "/medievalserialization/resources/";
    /* Instance Variables */
    public Player player;

    /* Main Method */
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        MedievalGame game = new MedievalGame();

        game.player = game.start(console);

        game.addDelay(500);
        System.out.println("\nLet's take a quick look at you to make sure you're ready to head out the door.");
        System.out.println(game.player);

        game.addDelay(1000);
        System.out.println("\nWell, you're off to a good start, let's get your game saved so we don't lose it.");
        game.save();

        game.addDelay(2000);
        System.out.println("We just saved your game...");
        System.out.println("Now we are going to try to load your character to make sure the save worked...");

        game.addDelay(1000);
        System.out.println("Deleting character...");
        String charName = game.player.getName();
        game.player = null;

        game.addDelay(1500);
        game.player = game.load(charName, console);
        System.out.println("Loading character...");

        game.addDelay(2000);
        System.out.println("Now let's print out your character again to make sure everything loaded:");

        game.addDelay(500);
        System.out.println(game.player);
    } // End of main

    /* Instance Methods */
    private Player start(Scanner console) {
        // Add start functionality here
        Player player;
        Art.homeScreen();
        System.out.println("Welcome to the game! Do you want to enter the castle? (y/n)");
        String answer;

        while (true) {
            answer = console.next().toLowerCase();
            if (("y").equals(answer)) {
                System.out.println("Enter previous character name:");
                player = load(console.next(), console);
                break;
            } else if (("n".equals(answer))) {
                System.out.println("Create a new player by typing in your desired name");
                player = new Player(console.next());
                break;
            } else {
                System.out.println("Enter 'y' or 'n' only.");
                System.out.println("Enter previous character name:");
            }
        }


        return player;
    } // End of start

    private void save() {
        // Add save functionality here

        try (FileOutputStream userSaveFile = new FileOutputStream(RESOURCES_DIR
                + this.player.getName() + ".svr");
             ObjectOutputStream playerSaver = new ObjectOutputStream(userSaveFile))
        {
            playerSaver.writeObject(this.player);
        } catch (IOException e) {
            e.printStackTrace();
        }

    } // End of save

    private Player load(String playerName, Scanner console) {
        // Add load functionality here
        Player loadedPlayer;

        try (
                FileInputStream userSavedFile = new FileInputStream(RESOURCES_DIR
                        + playerName + ".svr");
                ObjectInputStream playerLoader = new ObjectInputStream(userSavedFile);
                ) {
            loadedPlayer = (Player) playerLoader.readObject();
            return loadedPlayer;
        } catch (ClassNotFoundException | IOException e) {
            addDelay(1500);
            System.out.println("Having trouble locating the player...");
            addDelay(2000);
            loadedPlayer = new Player(playerName);
            return loadedPlayer;
        }

    } // End of load

    // Adds a delay to the console so it seems like the computer is "thinking"
    // or "responding" like a human, not instantly like a computer.
    private void addDelay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}