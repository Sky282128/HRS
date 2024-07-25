public class ExecutiveRoom extends Room{
    public ExecutiveRoom(int roomNumber, double price) {
        super(roomNumber, price*1.35f);
    }
    
    @Override
    public void setPrice(double price) {
        this.price = price*1.35f;
    }
}
