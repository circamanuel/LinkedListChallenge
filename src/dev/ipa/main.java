package dev.ipa;

import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        LinkedList<Place> places = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);


        // Add Sydney as the starting point
        addPlace(places, new Place("Sydney", 0));

        // Add other places
        addPlace(places, new Place("Melbourne", 878));
        addPlace(places, new Place("Brisbane", 1000));
        addPlace(places, new Place("Canberra", 286));
        addPlace(places, new Place("Adelaide", 1374));
        addPlace(places, new Place("Melbourne", 878));

        System.out.println("-----------------------------------------");
        printList(places);
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
}
