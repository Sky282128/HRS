/**
 * Contains the details of a Reservation
*/
public class Reservation{
    private String guestName;
    private Date checkInDate;
    private Date checkOutDate;
    private Room roomInfo;
    private double totalPrice;
    /**
     * Initializes a Reservation object with guestName, checkInDate, checkOutDate, roomInfo, and totalPrice
     * @param guestName name of guest who owns this reservation
     * @param checkInDate Date when guest checks in
     * @param checkOutDate Date when guest checks out
     * @param roomInfo Room that the guest will stay in
     * @param totalPrice total price of the guest's reservation
     */
    public Reservation(String guestName, Date checkInDate, Date checkOutDate, Room roomInfo, double totalPrice) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomInfo = roomInfo;
        this.totalPrice = totalPrice;
    }
    /**
     * Returns the name of the guest
     * @return guestName 
     */
    public String getGuestName() {
        return guestName;
    }
    /**
     * Returns the date for check in
     * @return checkInDate 
     */
    public Date getCheckInDate() {
        return checkInDate;
    }
    /**
     * Returns the date for check out
     * @return checkOutDate 
     */
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    /**
     * Returns the reserved room
     * @return roomInfo 
     */
    public Room getRoomInfo() {
        return roomInfo;
    }
    /**
     * Returns the total price of this reservation
     * @return totalPrice 
     */
    public double getTotalPrice() {
        return totalPrice;
    }
}