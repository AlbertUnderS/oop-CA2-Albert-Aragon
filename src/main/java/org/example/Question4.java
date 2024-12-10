package org.example;

import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */

public class Question4  // Flood Fill (Stack, 2D Array)
{
    static final int ROWS = 10;
    static final int COLUMNS = 10;

    public static void main(String[] args) {
        System.out.println("Question 4: Flood-fill algorithm.");

        // 2D Array (10x10), initialized to 0
        int[][] matrix = new int[ROWS][COLUMNS];

        // Prompt user for starting cell
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter starting row (0 to 9): ");
        int startRow = scanner.nextInt();
        System.out.print("Enter starting column (0 to 9): ");
        int startCol = scanner.nextInt();

        // Run flood-fill from the given start position
        floodFill(startRow, startCol, matrix);

        // Display the resulting matrix
        display(matrix);
    }

    /*
        Helper function to display the 2D Array
    */
    public static void display(int[][] arr) {
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLUMNS; y++) {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    /*
        Flood-fill algorithm implementation using a stack
    */
    private static void floodFill(int r, int c, int[][] arr) {
        // Define a stack to hold Cell objects
        Stack<Cell> stack = new Stack<>();
        // Push the starting cell onto the stack
        stack.push(new Cell(r, c));

        int fillValue = 1; // Start filling with 1 and increment after each step

        // Continue until the stack is empty
        while (!stack.isEmpty()) {
            // Pop the top cell from the stack
            Cell current = stack.pop();
            int row = current.row;
            int col = current.col;

            // Skip if the cell is out of bounds or already filled
            if (row < 0 || row >= ROWS || col < 0 || col >= COLUMNS || arr[row][col] != 0) {
                continue;
            }

            // Fill the current cell
            arr[row][col] = fillValue++;

            // Push valid neighbors onto the stack (north, east, south, west)
            stack.push(new Cell(row - 1, col)); // North
            stack.push(new Cell(row + 1, col)); // South
            stack.push(new Cell(row, col - 1)); // West
            stack.push(new Cell(row, col + 1)); // East
        }
    }

    /*
        Helper class to represent a cell (row, column pair)
    */
    static class Cell {
        int row, col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
