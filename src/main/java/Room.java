import java.util.ArrayList;

/**
 * 1.(a)
 * This Room class allows you to interact with a collection of rooms.
 * You can book a room, print a list of rooms, get the guest, number and daily rate of
 * the customer, calculate the bill for a room,
 * verify the format of a room's number.
 *
 * @author (Javier Gonzalez Garcia)
 * @version (16/11/22)
 */
public class Room
{
    /*
     * 1.(b)
     * Giving private fields to the class
     */
    private String guest;
    private String number;
    private double dailyRate;

    /* 1.(c)
     * This is the constructor with three parameters.
     * Everytime a new instance of the Room class is created
     * using this constructor, it will assign the arguments
     * to the instance fields.
     */
    public Room(String aGuest, String aNumber, double aRate)
    {
        this.guest = aGuest;
        this.number = aNumber;
        this.dailyRate = aRate;
    }

    /*
     * 1.(d)i
     * When we invoke this method on a Room instance, it will return
     * the name of the guest, which is a String type
     */
    public String getGuest()
    {
        return this.guest;
    }

    /*
     * Calling this method on a Room instance it will return the String
     * number of the room.
     */
    public String getNumber()
    {
        return this.number;
    }

    /*
     * Calling this method on a Room object it will return the dailyRate
     * of the room. The returned value is a double primitive.
     */
    public double getDailyRate()
    {
        return this.dailyRate;
    }

    /*
     * 1.(d)ii
     * Here we start with the setter methods
     * This method set the value of the argument passed to the parameter
     * to the instance field guest.
     * It does not return anything because is void.
     * Setter methods does not return anything.
     */
    public void setGuest(String aGuest)
    {
        this.guest = aGuest;
    }

    /*
     * 1.(d)iii
     * This method gives to the instance field dailyRate the value
     * passed through the parameter. The value is the argument.
     */
    public void setDailyRate(double aDailyRate)
    {
        this.dailyRate = aDailyRate;;
    }

    /*
     * 1.(e)
     * This is a boolean method. Boolean methods normally start with the word 'is'
     * followed by the action they do. The return type is a boolean primitive.
     * It can return just true or false.
     * isAvailable() checks the length of the string word guest, and if it is bigger
     * than 0 it will return true, if not it will return false.
     * I made use of a ternary operator to give a shorter and clean solution,
     * instead a typical if-else statement.
     */
    public boolean isAvailable()
    {
        if (this.guest.length()==0){
            return true;
        }
        return false;
    }

    /*
     * 1.(f)
     * This boolean method returns true of false depending on if the room object
     * is a valid object by following 6 criteria, inside the if statement:
     * -First line checks if the number length is different than 3 -Needs to be exactly 3.
     * -Second line checks if any boolean value is true. It should be both false.
     * -Third line checks if the first digit is equal to 0, in that case check if the second
     * digit is 0, if this is the case is not valid, it should be any other number.
     * -Forth, Fith and Sixth line checks if the third digit is A, B or C, respectively.
     * It cannot be any other letter or number.
     * || means 'or', but if the first condition is not true it does not continue examinating
     * the second condition. To examine the second condition we could use just '|', but for me
     * it is more preferible to use ||.
     */
    public boolean verifyRoom()
    {
        /*
         * Let's check if the third character is one of these values: 'A', 'B', or 'C'.
         */
        char character = '?';
        boolean b = true;

        if(this.number.length()!=3) {
            return false;
        }
        boolean b1 = Character.isDigit(this.number.charAt(0));
        boolean b2 = Character.isDigit(this.number.charAt(1));
        character = this.number.charAt(2); // Third character value stored.

        // is the third value one of the cases? If not, take the default value.
        switch (character){
            case 'A':
            case 'B':
            case 'C':
                break; // If one of these cases is met: 'A', 'B' or 'C', then stop running the switch.
            default:
                b = !b; // The variable b will be change to false if 'default' statement is run.

        }

        // First and second characters should be ints, so b1 and b2 should be both true.
        if ((b1 && b2 != true)
                ||(this.number.charAt(0) == '0') && (this.number.charAt(1) == '0')
                || !b) {
            return false;
        }
        return true;
    }

    /*
     * 1.(g)
     * This method take the third character of the current room instance and check if the number on the 3rd character is an A, B or C.
     * If not, it will return a "Not a valid Type" String.
     */
    public String getType()
    {
        if (this.number.charAt(2)=='A'){
            return "Single";
        }
        if (this.number.charAt(2)=='B'){
            return "Double";
        }
        if (this.number.charAt(2)=='C'){
            return "Family";
        }
        return "Not a valid Type";
    }

    /*
     * 1.(h)
     * This method returns a String, It is built by a concatenation of methods and Strings.
     * You can concatenate a String to a non String but not the opposite.
     */
    public String description() {
        String message;
        if (this.isAvailable())
            message = this.getType() + " room " + this.number + " (available) " + this.guest;
        else {
            message = this.getType() + " room " + this.number + " (reserved) " + this.guest;
        }
        return message;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number='" + number + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("Bea");
        hotel1.addRooms();


    }
}












