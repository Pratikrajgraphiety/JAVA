import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Collections;
import java.util.Scanner;

public class PRACTICAL4B {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // a. Demonstrating List Interface with Mathematical Calculations
        System.out.println("--- Demonstrating List Interface (Numbers) ---");

        List<Double> numbersList = new ArrayList<>();

        // Add elements with user input
        System.out.println("Enter 5 numbers for the list:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbersList.add(input.nextDouble());
        }

        System.out.println("Initial List: " + numbersList);

        // Calculate sum
        double sumList = 0;
        for (Double num : numbersList) {
            sumList += num;
        }
        System.out.println("Sum of list elements: " + sumList);

        // Calculate average
        if (!numbersList.isEmpty()) {
            System.out.println("Average of list elements: " + (sumList / numbersList.size()));
        }

        // Find minimum and maximum
        if (!numbersList.isEmpty()) {
            System.out.println("Minimum element in list: " + Collections.min(numbersList));
            System.out.println("Maximum element in list: " + Collections.max(numbersList));
        }

        // Remove an element
        System.out.print("Enter a number to remove from the list: ");
        double numToRemove = input.nextDouble();

        if (numbersList.remove(Double.valueOf(numToRemove))) {
            System.out.println(numToRemove + " removed. New List: " + numbersList);
        } else {
            System.out.println(numToRemove + " not found in the list.");
        }

        // Recalculate sum and average
        sumList = 0;
        for (Double num : numbersList) {
            sumList += num;
        }

        System.out.println("New sum of list elements: " + sumList);

        if (!numbersList.isEmpty()) {
            System.out.println("New average of list elements: " + (sumList / numbersList.size()));
        }

        numbersList.clear();
        System.out.println("List cleared.");

        // b. Demonstrating Set Interface
        System.out.println("\n--- Demonstrating Set Interface (Unique Numbers) ---");

        Set<Integer> uniqueNumbers = new HashSet<>();

        System.out.println("Enter 5 integer values for the set (duplicates will be ignored):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            uniqueNumbers.add(input.nextInt());
        }

        System.out.println("Initial Set: " + uniqueNumbers);

        // Sum of set elements
        int sumSet = 0;
        for (Integer num : uniqueNumbers) {
            sumSet += num;
        }

        System.out.println("Sum of set elements: " + sumSet);

        // Square each element
        Set<Integer> squaredNumbers = new HashSet<>();
        for (Integer num : uniqueNumbers) {
            squaredNumbers.add(num * num);
        }

        System.out.println("Set of squared numbers: " + squaredNumbers);

        // Remove an element
        System.out.print("Enter an integer to remove from the set: ");
        int intToRemove = input.nextInt();

        if (uniqueNumbers.remove(intToRemove)) {
            System.out.println(intToRemove + " removed. New Set: " + uniqueNumbers);
        } else {
            System.out.println(intToRemove + " not found in the set.");
        }

        // c. Demonstrating Map Interface
        System.out.println("\n--- Demonstrating Map Interface (Product Scores) ---");

        Map<String, Double> productScores = new HashMap<>();

        // Add products
        System.out.println("Enter scores for 3 products:");

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter product name " + (i + 1) + ": ");
            String productName = input.next();

            System.out.print("Enter score for " + productName + ": ");
            double score = input.nextDouble();

            productScores.put(productName, score);
        }

        System.out.println("Initial Map: " + productScores);

        // Calculate total score
        double totalScore = 0;
        for (Double score : productScores.values()) {
            totalScore += score;
        }

        System.out.println("Total score of all products: " + totalScore);

        // Update score
        System.out.print("Enter a product name to update its score: ");
        String productToUpdate = input.next();

        if (productScores.containsKey(productToUpdate)) {
            System.out.print("Enter the new score for " + productToUpdate + ": ");
            double newScore = input.nextDouble();

            productScores.put(productToUpdate, newScore);

            System.out.println("Map after updating " + productToUpdate + ": " + productScores);
        } else {
            System.out.println(productToUpdate + " not found in the map.");
        }

        // Calculate new total score
        totalScore = 0;
        for (Double score : productScores.values()) {
            totalScore += score;
        }

        System.out.println("New total score: " + totalScore);

        // Remove product
        System.out.print("Enter a product name to remove: ");
        String productToRemove = input.next();

        if (productScores.remove(productToRemove) != null) {
            System.out.println(productToRemove + " removed. New Map: " + productScores);
        } else {
            System.out.println(productToRemove + " not found in the map.");
        }

        input.close();
    }
}
