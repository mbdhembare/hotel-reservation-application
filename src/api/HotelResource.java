package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class HotelResource {

    private static final HotelResource SINGLETON = new HotelResource();
    private HotelResource(){}
    public static HotelResource getSingleton(){
        return SINGLETON;
    }
    private final CustomerService customerService = CustomerService.getSingleton();
    private final ReservationService reservationService = ReservationService.getSingleton();

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }
    public void createACustomer(String email, String firstName, String lastName){
    customerService.addCustomer(email, firstName, lastName);
    }
    public IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate){
        return reservationService.reservationRoom(getCustomer(customerEmail), room, checkInDate, checkInDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail){
        final Customer customer = getCustomer(customerEmail);

        if(customer==null){
            return Collections.emptyList();
        }
        return reservationService.getCustomersReservation(customer);
    }

    public Collection<IRoom> findARoom(final Date checkIn, final Date checkOut){
        return reservationService.findRooms(checkIn, checkOut);
    }

    public Collection<IRoom> findAlternativeRoom(final Date checkIn, final Date checkOut){
        return reservationService.findAlternativeRooms(checkIn, checkOut);
    }

    public Date addDefaultPlusDays(final Date date) {
        return reservationService.addDefaultPlusDays(date);
    }
}
