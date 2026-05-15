gitpackage com.example.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private static Game instance;
    private Room currentRoom;
    private boolean over = false;

    private Game() {
        Room foyer = new Room("foyer", "You are in a small foyer. There's a door to the north.");
        Room hall = new Room("hall", "You are in a hall. There's a door to the south and an exit to the east.");
        Room treasure = new Room("treasure", "You've found a small treasure room! You win if you 'take' the treasure.");

        foyer.setExit("north", hall);
        hall.setExit("south", foyer);
        hall.setExit("east", treasure);

        currentRoom = foyer;
    }

    public static Game getInstance() {
        if (instance == null) instance = new Game();
        return instance;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!over) {
            System.out.println(currentRoom.getDescription());
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("quit") || input.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            handleCommand(input);
        }
        scanner.close();
    }

    private void handleCommand(String cmd) {
        if (cmd.startsWith("move ")) {
            String dir = cmd.substring(5);
            Room next = currentRoom.getExit(dir);
            if (next == null) System.out.println("You can't go that way.");
            else { currentRoom = next; System.out.println("You move " + dir + "."); }
        } else if (cmd.equals("look")) {
            System.out.println(currentRoom.getDescription());
        } else if (cmd.equals("take")) {
            if (currentRoom.getName().equals("treasure")) {
                over = true;
                System.out.println("You take the treasure. You win!");
            } else System.out.println("There's nothing to take here.");
        } else if (cmd.equals("status")) {
            System.out.println("You are in: " + currentRoom.getName());
        } else {
            System.out.println("I don't understand that command.");
        }
    }
}
