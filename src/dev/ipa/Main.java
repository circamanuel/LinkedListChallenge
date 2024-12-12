package dev.ipa;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();

        // Add initial places
        addPlace(places, new Place("Sydney", 0));
        addPlace(places, new Place("Melbourne", 878));
        addPlace(places, new Place("Brisbane", 1000));
        addPlace(places, new Place("Canberra", 286));
        addPlace(places, new Place("Adelaide", 1374));
        addPlace(places, new Place("Melbourne", 878)); // Duplicate, will not be added

        // Start the menu system
        menu(places);
    }

    // Add new Places to LinkedList. Checks if place exists and maintains sorted order.
    public static void addPlace(LinkedList<Place> places, Place newPlace) {
        if (places.stream().anyMatch(place -> place.getName().equalsIgnoreCase(newPlace.getName()))) {
            System.out.println(newPlace + " already exists. This item was not added.");
            return;
        }

        ListIterator<Place> iterator = places.listIterator();
        while (iterator.hasNext()) {
            if (newPlace.getDistance() < iterator.next().getDistance()) {
                iterator.previous(); // Step back to insert at the correct position
                iterator.add(newPlace);
                System.out.println(newPlace + " added in sorted order.");
                return;
            }
        }

        // If we reach here, add to the end
        places.add(newPlace);
        System.out.println(newPlace + " added at the end.");
    }

    // Main menu for user interaction
    public static void menu(LinkedList<Place> places) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Place> iterator = places.listIterator();

        String menu = """
            --------------------------------
            Select Option:
            -> (F): Forwards
            -> (B): Backwards
            -> (L): List Places
            -> (M): Menu
            -> (Q): Quit
            --------------------------------
            """;

        System.out.println(menu);

        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "F" -> move(iterator, true);
                case "B" -> move(iterator, false);
                case "L" -> printList(places);
                case "M" -> System.out.println(menu);
                case "Q" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Print all places in the LinkedList
    public static void printList(LinkedList<Place> places) {
        if (places.isEmpty()) {
            System.out.println("No places to display.");
        } else {
            places.forEach(System.out::println);
        }
    }

    // Navigate through the list
    public static void move(ListIterator<Place> iterator, boolean forward) {
        if (forward) {
            if (iterator.hasNext()) {
                System.out.println("Moving forwards -> " + iterator.next());
            } else {
                System.out.println("You have reached the end of the list.");
            }
        } else {
            if (iterator.hasPrevious()) {
                System.out.println("Moving backwards -> " + iterator.previous());
            } else {
                System.out.println("You are at the beginning of the list.");
            }
        }
    }
}
