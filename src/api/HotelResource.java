package api;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    public Customer getCustomer(String email){

        return null;
    }
    public void createACustomer(String email, String firstName, String lastName){

    }
    public IRoom getRoom(String roomNumber){

        return null;
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate){

        return null;
    }
    public Collection<Reservation> getCustomersReservations(String customerEmail){

        return java.util.List.of();
    }
    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){

        return java.util.List.of();
    }
}
