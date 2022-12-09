import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


/**
 * (a)
 * Write a description of class Hotel here.
 *
 * @author (Javier Gonzalez Garcia)
 * @version (24/11/2022)
 */

public class Hotel {
    /*
     * (b)
     */
    private String name;
    private ArrayList<Room> rooms;

    /*
     * (c)
     */
    public Hotel(String aName) {
        this.name = aName;
        this.rooms = new ArrayList<Room>();
    }

    /**
     * (d) Adds some unoccupied test rooms to the hotel
     */
    public void addRooms() {
        int i = 10;
        while (i < 19) {
            String number = "" + i;
            double rate;

            if (i % 3 == 1) {
                number += "A";
                rate = 100;
            } else if (i % 3 == 2) {
                number += "B";
                rate = 180;
            } else {
                number += "C";
                rate = 250;
            }

            Room r = new Room("", number, rate);

            rooms.add(r);
            i++;
        }
        Room room = rooms.get(1);
        String number = room.getNumber();
        double rate = room.getDailyRate();
        System.out.println(number);
        System.out.println(rate);
    }

    /*
     * (e)
     */
    public double calculateBill(Room room, int days) {
        double bill = room.getDailyRate() * days;
        if (days > 0 && days >= 4) {
            bill -= bill * 1 / 10;
        }
        return bill;
    }

    /*
     * (f)
     */
    public ArrayList<Room> getMatchingRooms(String roomType) {
        ArrayList<Room> matchingRooms = new ArrayList<>();
        int numberOfRooms = rooms.size();
        for (int i = 0; i < numberOfRooms; i++) {
            Room room = rooms.get(i);
            if (room.isAvailable() == true && room.getType() == roomType) {
                matchingRooms.add(room);
            }
        }
        return matchingRooms;
    }

    /*
     * (g)
     */
    public int vacancies() {
        int vacancies = 0;
        Room room;
        ArrayList<Room> roomsAvailable = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            room = rooms.get(i);
            if (room.isAvailable()) {
                if (Objects.equals(room.getType(), "Single")) {
                    roomsAvailable.add(room);
                    vacancies++;
                }
                if (Objects.equals(room.getType(), "Double")) {
                    vacancies += 2;
                }
                if (Objects.equals(room.getType(), "Family")) {
                    vacancies += 4;
                }
            }
        }
        return vacancies;
    }

    /*
     * (h)
     */
    public void bookRoom(Room room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (Objects.equals(rooms.get(i).getNumber(), room.getNumber())) {
                this.removeRoom(room.getNumber());
            }
        }
    }

    /*
     * (i)
     */
    public void removeRoom(String roomNumber) {
        Iterator<Room> it = rooms.iterator();
        boolean found = false;
        while (it.hasNext()) {
            Room room = it.next();
            String number = room.getNumber();
            if (number.equals(roomNumber)) {
                it.remove();
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Room " + roomNumber + " not found!");
        }
    }
}
