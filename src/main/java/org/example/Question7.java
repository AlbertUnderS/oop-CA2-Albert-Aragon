package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
 */
public class Question7 {    // Shares Tax Calculations (Queue)

    // A helper class to represent a batch of shares
    static class ShareBatch {
        int quantity;
        double price;

        public ShareBatch(int quantity, double price) {
            this.quantity = quantity;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<ShareBatch> sharesQueue = new LinkedList<>(); // FIFO queue for bought shares
        String command;
        double totalProfit = 0.0;

        System.out.println("Enter commands: buy qty price, sell qty price, or quit");

        do {
            System.out.print("> ");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {
                int qty = in.nextInt();
                double price = in.nextDouble();

                // Add a new batch of shares to the queue
                sharesQueue.add(new ShareBatch(qty, price));
                System.out.println("Bought " + qty + " shares at $" + price + " each.");

            } else if (command.equalsIgnoreCase("sell")) {
                int sellQty = in.nextInt();
                double sellPrice = in.nextDouble();
                double sellTotal = 0.0; // Total selling amount
                double costTotal = 0.0; // Total cost of sold shares
                int remainingSellQty = sellQty;

                while (remainingSellQty > 0 && !sharesQueue.isEmpty()) {
                    ShareBatch batch = sharesQueue.peek();

                    if (batch.quantity <= remainingSellQty) {
                        // Sell the entire batch
                        sellTotal += batch.quantity * sellPrice;
                        costTotal += batch.quantity * batch.price;
                        remainingSellQty -= batch.quantity;
                        sharesQueue.poll(); // Remove the batch from the queue
                    } else {
                        // Partially sell this batch
                        sellTotal += remainingSellQty * sellPrice;
                        costTotal += remainingSellQty * batch.price;
                        batch.quantity -= remainingSellQty;
                        remainingSellQty = 0;
                    }
                }

                if (remainingSellQty > 0) {
                    System.out.println("Not enough shares to sell.");
                } else {
                    double profit = sellTotal - costTotal;
                    totalProfit += profit;
                    System.out.printf("Sold %d shares at $%.2f each.\n", sellQty, sellPrice);
                    System.out.printf("Cost: $%.2f, Profit: $%.2f\n", costTotal, profit);
                }
            }
        } while (!command.equalsIgnoreCase("quit"));

        System.out.printf("Total Profit: $%.2f\n", totalProfit);
        System.out.println("Exiting program...");
        in.close();
    }
}
