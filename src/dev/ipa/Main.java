package dev.ipa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    static LinkedList<Place> places = new LinkedList<>();
    static ListIterator<Place> iterator = places.listIterator();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        // Add Sydney as the starting point
        addPlace(places, new Place("Sydney", 0));

        // Add other places
        addPlace(places, new Place("Melbourne", 878));
        addPlace(places, new Place("Brisbane", 1000));
        addPlace(places, new Place("Canberra", 286));
        addPlace(places, new Place("Adelaide", 1374));
        addPlace(places, new Place("Melbourne", 878));

        iterator = places.listIterator();


        selectOption();
//          iterator();
    }
    // used to select class and call the right class
    public static void selectOption() {

        Scanner scanner = new Scanner(System.in);

        String menu = """
                    --------------------------------
                    Select Option\
                    
                    -> (F): Forwards\
                    
                    -> (B): Backwards\
                    
                    -> (L): List Places\
                    
                    -> (M): Menu\
                    
                    -> (Q): Quit
                    --------------------------------""";

        System.out.println(menu);

        while (true) {

            String input = scanner.nextLine();

            switch (input) {

                case "F" -> iteratorFrontwards();
                case "B" -> iteratorBackwards();
                case "L" -> printList(places);
                case "M" -> System.out.println("Menu");
                case "Q" ->{
                    System.out.println("Quit");
                    return;}
                default -> System.out.println("Error");
            };

            System.out.println(menu);
        }
    }
    // Iterates through  the places Linked list and prints every item.
    public static void printList(LinkedList<Place> places) {

        for (Place item: places) {
            System.out.println(item);
        }
    }

    // Add new Places to Linked list. Checks if exists
    public static void addPlace(LinkedList<Place> places, Place newPlace) {

       for (Place place: places) {
           if (place.name.equalsIgnoreCase(newPlace.name)) {
               System.out.println(newPlace + " Exists already. This item was not added to the List");
               return;
           }
       }

       System.out.println(newPlace + " added.");
       places.add(newPlace);


    }

    // Iterator go forward (maybe  switch case which chose forwards or backwards)
    public static void iteratorFrontwards() {
        if (iterator.hasNext()) {
             System.out.println("Moving forwards -> " + iterator.next());
        } else {
            System.out.println("Arrived at the end.");
        }
    }
    public static void iteratorBackwards() {
        if (iterator.hasPrevious()) {
            System.out.println("Moving backwards -> " + iterator.previous());
        } else {
            System.out.println("Arrived at the beginning of the list.");
        }
    }
}
