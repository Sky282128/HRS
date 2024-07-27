/**
 * Contains the details of a Deluxe Room in a Hotel
*/
public class DeluxeRoom extends Room{
    /**
     * Initializes a Deluxe Room object with the room number and the price of the room
     * @param roomNumber number designated to the Deluxe Room
     * @param price price of this Deluxe Room
     */
    public DeluxeRoom(int roomNumber, double price) {
        super(roomNumber, price*1.20f);
    }
    /**
     * Sets a new value for price but multiplies it by the price rate of a Deluxe Room
     * @param price new value for price 
     */
    @Override
    public void setPrice(double price) {
        this.price = price*1.20f;
    }
}
