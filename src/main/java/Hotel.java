import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * (a) The Hotel class can create instances of itself providing a name and one ArrayList of Room objects.
 * This class interacts with the Room class for managing aspects like bookings, calculating the bill of the booking, check the available rooms...
 *
 * @author (Javier Gonzalez Garcia)
 * @version (24/11/2022)
 */

public class Hotel
{
    /*
     * (b) Instance fields provide a String name and one ArrayList of type of Rooms to every new Hotel instance.
     */
    private String name;
    private ArrayList<Room> rooms;

    /*
     * (c) Hotel constructor with two parameters, assigning a name and a new empty ArrayList for every Hotel object.
     */
    public Hotel(String aName)
    {
        this.name = aName;
        this.rooms = new ArrayList<Room>();
    }

    /**
     * (d) Adds some unoccupied test rooms to the hotel
     */
    public void addRooms()
    {
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
    }

    /*
     * (e) Calculate the bill according to the daily rate and the number of days.
     */
    public double calculateBill(Room room, int days)
    {
        double bill = room.getDailyRate() * days;
        if (days > 0 && days >= 4) {
            bill -= bill * 1 / 10;
        }
        return bill;
    }

    /*
     * (f) If the type of room requested is available, add it into a list of rooms.
     */
    public ArrayList<Room> getMatchingRooms(String roomType)
    {
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
     * (g) Check how many vacancies rooms there are in the hotel.
     */
    public int vacancies()
    {
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
     * (h) Book a room by its number and remove it from the ArrayList.
     */
    public void bookRoom(Room room)
    {
        for (int i = 0; i < rooms.size(); i++) {
            if (Objects.equals(rooms.get(i).getNumber(), room.getNumber())) {
                this.removeRoom(room.getNumber());
            }
        }
    }

    /*
     * (i) Remove a room by number if that room exists in the hotel (The addRoom method will set up first a list of empty rooms).
     */
    public void removeRoom(String roomNumber)
    {
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
