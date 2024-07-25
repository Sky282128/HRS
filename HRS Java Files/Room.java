import java.util.ArrayList;
/**
 * Contains the details of a Room in a Hotel
*/
public class Room{
    private int roomNumber;
    protected double price;
    private ArrayList <Integer> daysOccupied;
    /**
     * Initializes a Room object with the room number and the price of the room
     * @param roomNumber number designated to the Room
     * @param price price of this Room
     */
    public Room(int roomNumber, double price){
        this.roomNumber = roomNumber;
        this.price = price;
        this.daysOccupied = new ArrayList <>();
    }
    /**
     * Returns the number of this Room
     * @return roomNumber 
     */
    public int getRoomNumber() {
        return roomNumber;
    }
    /**
     * Sets a new value for roomNumber
     * @param roomNumber new value for roomNumber 
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    /**
     * Returns the price of this Room
     * @return price 
     */
    public double getPrice() {
        return price;
    }
    /**
     * Sets a new value for price
     * @param price new value for price 
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Returns the list of days that this Room is occupied on
     * @return daysOccupied 
     */
    public ArrayList<Integer> getDaysOccupied() {
        return daysOccupied;
    }
    /**
     * Sets a new arayList for daysOccupied
     * @param daysOccupied new arrayList for daysOccupied 
     */
    public void setDaysOccupied(ArrayList<Integer> daysOccupied) {
        this.daysOccupied = daysOccupied;
    }
}