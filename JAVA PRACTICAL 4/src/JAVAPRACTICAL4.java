import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

public class JAVAPRACTICAL4 {

    public static void main(String[] args) {

        // a. Demonstrating List Interface (using ArrayList)
        System.out.println("--- Demonstrating List Interface ---");

        List<String> fruits = new ArrayList<>();

        // Basic List operations
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicates allowed

        System.out.println("Initial List: " + fruits);

        fruits.add(1, "Grape");
        System.out.println("List after adding Grape at index 1: " + fruits);

        System.out.println("First fruit: " + fruits.get(0));

        fruits.set(2, "Mango");
        System.out.println("List after updating element at index 2 to Mango: " + fruits);

        fruits.remove("Apple");
        System.out.println("List after removing the first Apple: " + fruits);

        fruits.remove(fruits.size() - 1);
        System.out.println("List after removing the last element: " + fruits);

        // Other List methods
        System.out.println("Index of Orange: " + fruits.indexOf("Orange"));
        System.out.println("Does list contain Banana? " + fruits.contains("Banana"));
        System.out.println("Size of the list: " + fruits.size());

        fruits.clear();
        System.out.println("List after clearing: " + fruits);

        // b. Demonstrating Set Interface (using HashSet)
        System.out.println("\n--- Demonstrating Set Interface ---");

        Set<String> uniqueColors = new HashSet<>();

        // Basic Set operations
        uniqueColors.add("Red");
        uniqueColors.add("Green");
        uniqueColors.add("Blue");
        uniqueColors.add("Red"); // Duplicate, won't be added

        System.out.println("Initial Set: " + uniqueColors);

        uniqueColors.remove("Green");
        System.out.println("Set after removing Green: " + uniqueColors);

        // Other Set methods
        System.out.println("Does set contain Blue? " + uniqueColors.contains("Blue"));
        System.out.println("Size of the set: " + uniqueColors.size());
        System.out.println("Is the set empty? " + uniqueColors.isEmpty());

        // Iterating through the set
        System.out.print("Iterating over the set: ");
        Iterator<String> iterator = uniqueColors.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        Set<String> moreColors = new HashSet<>();
        moreColors.add("Yellow");
        moreColors.add("Blue");

        uniqueColors.addAll(moreColors);
        System.out.println("Set after adding more colors: " + uniqueColors);

        // c. Demonstrating Map Interface (using HashMap)
        System.out.println("\n--- Demonstrating Map Interface ---");

        Map<String, Integer> studentScores = new HashMap<>();

        // Basic Map operations
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 88);
        studentScores.put("Charlie", 76);
        studentScores.put("Alice", 98); // Updates existing key

        System.out.println("Initial Map: " + studentScores);

        System.out.println("Bob's score: " + studentScores.get("Bob"));

        studentScores.remove("Charlie");
        System.out.println("Map after removing Charlie: " + studentScores);

        // Other Map methods
        System.out.println("Does map contain key Bob? " + studentScores.containsKey("Bob"));
        System.out.println("Does map contain value 98? " + studentScores.containsValue(98));

        // Getting views of the map
        System.out.println("Keys in the map: " + studentScores.keySet());
        System.out.println("Values in the map: " + studentScores.values());
        System.out.println("Entries in the map: " + studentScores.entrySet());
        System.out.println("Size of the map: " + studentScores.size());

        studentScores.clear();
        System.out.println("Map after clearing: " + studentScores);
    }
}
