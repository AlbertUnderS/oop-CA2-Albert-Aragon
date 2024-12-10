package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
 */

public class Question6 {    // Flight take-off (Queue)

    public static void main(String[] args) {
        // Queues for takeoff and landing
        Queue<String> takeoffQueue = new LinkedList<>();
        Queue<String> landingQueue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Airport Flight Simulation. Enter commands (takeoff, land, next, quit):");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim();

            // Parse the command
            if (command.startsWith("takeoff")) {
                String flightCode = command.substring(8).trim();
                takeoffQueue.add(flightCode);
                System.out.println("Flight " + flightCode + " added to the takeoff queue.");

            } else if (command.startsWith("land")) {
                String flightCode = command.substring(5).trim();
                landingQueue.add(flightCode);
                System.out.println("Flight " + flightCode + " added to the landing queue.");

            } else if (command.equalsIgnoreCase("next")) {
                if (!landingQueue.isEmpty()) {
                    String flightCode = landingQueue.poll();
                    System.out.println("Landing: " + flightCode);
                } else if (!takeoffQueue.isEmpty()) {
                    String flightCode = takeoffQueue.poll();
                    System.out.println("Takeoff: " + flightCode);
                } else {
                    System.out.println("No flights waiting to land or take off.");
                }

            } else if (command.equalsIgnoreCase("quit")) {
                System.out.println("Simulation ended.");
                break;

            } else {
                System.out.println("Invalid command. Use 'takeoff flightCode', 'land flightCode', 'next', or 'quit'.");
            }
        }

        scanner.close();
    }
}
