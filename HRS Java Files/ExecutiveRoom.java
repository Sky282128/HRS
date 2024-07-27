/**
 * Contains the details of an Executive Room in a Hotel
*/
public class ExecutiveRoom extends Room{
    /**
     * Initializes an Executive Room object with the room number and the price of the room
     * @param roomNumber number designated to the Executive Room
     * @param price price of this Executive Room
     */
    public ExecutiveRoom(int roomNumber, double price) {
        super(roomNumber, price*1.35f);
    }
    /**
     * Sets a new value for price but multiplies it by the price rate of an Executive Room
     * @param price new value for price 
     */
    @Override
    public void setPrice(double price) {
        this.price = price*1.35f;
    }
}
