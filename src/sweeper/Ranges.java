package sweeper;

import java.util.ArrayList;

public class Ranges {
    private static Coord size;

    private static ArrayList<Coord> allCoords;

    public static ArrayList<Coord> getAllCoords() {
        return allCoords;
    }

    public static void setSize(Coord _size){

        size = _size;
        allCoords = new ArrayList<>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoords.add(new Coord(x, y));
            }
        }

    }

    public static Coord getSize() {
        return size;
    }

    static boolean inRange(Coord coord){

        return  0 <= coord.x && coord.x < size.x &&
                coord.y >= 0 && coord.y < size.y;

    }

}