public class DeluxeRoom extends Room{
    public DeluxeRoom(int roomNumber, double price) {
        super(roomNumber, price*1.20f);
    }
    
    @Override
    public void setPrice(double price) {
        this.price = price*1.20f;
    }
}
