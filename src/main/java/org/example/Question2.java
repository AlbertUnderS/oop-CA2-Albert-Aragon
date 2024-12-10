package org.example;

/**
 *  Name:
 *  Class Group:
 */
import java.util.Scanner;
import java.util.Stack;

public class Question2  // Car Parking - Stack
{
    public static void runSimulation() {
        Stack<Integer> driveway = new Stack<>();
        Stack<Integer> street = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Car Parking Simulation");
        System.out.println("Enter positive numbers to park a car (e.g., 1, 2, 3).");
        System.out.println("Enter negative numbers to retrieve a car (e.g., -2).");
        System.out.println("Enter 0 to stop the simulation.");

        while (true) {
            System.out.print("Enter your action: ");
            int action = scanner.nextInt();

            if (action == 0) {
                System.out.println("Simulation ended.");
                break;
            }

            if (action > 0) {
                // Park a car in the driveway
                driveway.push(action);
                System.out.println("Car " + action + " parked in the driveway.");
            } else if (action < 0) {
                // Retrieve a car from the driveway
                int carToRetrieve = -action;

                if (driveway.contains(carToRetrieve)) {
                    // Temporarily move cars blocking the requested car to the street
                    while (!driveway.isEmpty() && driveway.peek() != carToRetrieve) {
                        int movedCar = driveway.pop();
                        street.push(movedCar);
                        System.out.println("Car " + movedCar + " moved to the street.");
                    }

                    // Remove the requested car from the driveway
                    driveway.pop();
                    System.out.println("Car " + carToRetrieve + " retrieved from the driveway.");

                    // Move cars back from the street to the driveway
                    while (!street.isEmpty()) {
                        int movedBackCar = street.pop();
                        driveway.push(movedBackCar);
                        System.out.println("Car " + movedBackCar + " moved back to the driveway.");
                    }
                } else {
                    System.out.println("Car " + carToRetrieve + " is not in the driveway.");
                }
            }

            // Display the current state of the driveway
            System.out.println("Current driveway state: " + driveway);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
