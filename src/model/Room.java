package model;

import java.util.Objects;

public class Room implements IRoom{
    private final String roomNumber;
    private final double price;
    private final RoomType enumeration;
    private static final double FREE_PRICE_THRESHOLD = 0.0;

    public Room(final String roomNumber, final double price, final RoomType enumeration){
        this.roomNumber=roomNumber;
        this.price=price;
        this.enumeration=enumeration;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomType getRoomTYpe() {
        return this.enumeration;
    }

    @Override
    public boolean isFree() {
        return this.price == FREE_PRICE_THRESHOLD;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", room type=" + enumeration +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(!(obj instanceof Room)) {
            return false;
        }

        final Room room = (Room) obj;
        return Objects.equals(this.roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}