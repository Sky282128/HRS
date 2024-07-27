import java.util.ArrayList;
/**
 * Contains the details of a Hotel
*/
public class Hotel{
    private String hotelName;
    private Room[] roomList;
    private ArrayList <Reservation> reserveList;
    private double basePrice;
    private double totalEarnings;
    private int numOfRooms;
    private double[] priceRates;
    /**
     * Initializes a Hotel object with only the name of the hotel
     * @param hotelName name of the Hotel
     */
    public Hotel(String hotelName) {
        int x;
        this.hotelName = hotelName;
        this.roomList = new Room[50];
        this.reserveList = new ArrayList <>();
        this.basePrice = 1299.00f;
        this.totalEarnings = 0.00f;
        this.numOfRooms = 0;
        this.priceRates = new double[31];

        roomList[0] = new Room(0, 0);

        for (x = 0; x < 31; x++){
            priceRates[x] = 1.00f;
        }
    }
    /**
     * Initializes a Hotel object with the name of the Hotel and the number of rooms in the Hotel
     * @param hotelName name of the Hotel
     * @param numOfRooms total number of Rooms in the Hotel
     * @param standardRooms number of Standard Rooms the Hotel
     * @param deluxeRooms number of Deluxe Rooms the Hotel
     * @param executiveRooms number of Executive Rooms the Hotel
     */
    public Hotel(String hotelName, int numOfRooms, int standardRooms, int deluxeRooms, int executiveRooms) {
        int i, j = 0;
        int x;
        this.hotelName = hotelName;
        this.roomList = new Room[50];
        this.reserveList = new ArrayList <>();
        this.basePrice = 1299.00f;
        this.totalEarnings = 0.00f;
        this.numOfRooms = numOfRooms;
        this.priceRates = new double[31];

        for (x = 0; x < 31; x++){
            priceRates[x] = 1.00f;
        }
        for (i = 0; i < standardRooms; i++){
            roomList[i] = new Room(101 + j, basePrice);
            j++; 
        }
        for (i = 0; i < deluxeRooms; i++){
            roomList[j] = new DeluxeRoom(101 + j, basePrice);
            j++;
        }
        for (i = 0; i < executiveRooms; i++){
            roomList[j] = new ExecutiveRoom(101 + j, basePrice);
            j++; 
        }
    }
    /**
     * Returns the name of this Hotel
     * @return hotelName 
     */
    public String getHotelName() {
        return hotelName;
    }
    /**
     * Sets a new String for hotelName
     * @param hotelName new String for hotelName 
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    /**
     * Returns the Base Price of this Hotel
     * @return basePrice 
     */
    public double getBasePrice() {
        return basePrice;
    }
    /**
     * Sets a new value for basePrice
     * @param basePrice new value for basePrice 
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    /**
     * Returns the Total earnings of this Hotel
     * @return totalEarnings 
     */
    public double getTotalEarnings() {
        return totalEarnings;
    }
    /**
     * Sets a new value for totalEarnings
     * @param totalEarnings new String for totalEarnings 
     */
    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }
    /**
     * Returns the list of Rooms in this Hotel
     * @return roomList 
     */
    public Room[] getRoomList() {
        return roomList;
    }
    /**
     * Sets a new Room array for roomList
     * @param roomList new array for roomList 
     */
    public void setRoomList(Room[] roomList) {
        this.roomList = roomList;
    }
    /**
     * Returns the list of Reservations in this Hotel
     * @return reserveList 
     */
    public ArrayList<Reservation> getReserveList() {
        return reserveList;
    }
    /**
     * Sets a new Reservation arrayList for reserveList
     * @param reserveList new arrayList for reserveList 
     */
    public void setReserveList(ArrayList<Reservation> reserveList) {
        this.reserveList = reserveList;
    }
    /**
     * Returns the number of Rooms in this Hotel
     * @return numOfRooms 
     */
    public int getNumOfRooms() {
        return numOfRooms;
    }
    /**
     * Sets a new value for numOfRooms
     * @param numOfRooms new value for numOfRooms 
     */
    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }
    /**
     * Returns the list of price rates for each day of the month
     * @return priceRates 
     */
    public double[] getPriceRates() {
        return priceRates;
    }
    /**
     * Sets a new double array for priceRates
     * @param priceRates new array for priceRates 
     */
    public void setPriceRates(double[] priceRates) {
        this.priceRates = priceRates;
    }
}