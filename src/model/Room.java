package model;

public class Room implements IRoom{
    String roomNumber;
    double price;
    RoomType enumeration;

    public Room(String roomNumber, double price, RoomType enumeration){
        super();
        this.roomNumber=roomNumber;
        this.price=price;
        this.enumeration=enumeration;
    }

    @Override
    public String getRoomNumber() {
        return "";
    }

    @Override
    public Double getRoomPrice() {
        return 0.0;
    }

    @Override
    public RoomType getRoomTYpe() {
        return null;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", enumeration=" + enumeration +
                '}';
    }
}
