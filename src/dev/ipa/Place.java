package dev.ipa;

public class Place {

    public String name;
    public int distance;

    public Place(String town, int distance) {
        this.name = town;
        this.distance = distance;
    }

    public String getName() {

        return name;
    }

    public int getDistance(int distance) {

        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String toString() {
        return "Place{name='" + name + "', distance=" + distance + "}";
    }
}
