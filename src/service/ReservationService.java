package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ReservationService {
    private static final List<Reservation> reservations = new ArrayList<>();
    public void addRoom(IRoom room){

    }

    public IRoom getARoom(String roomId){

        return null;
    }

    public Reservation reservationRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        // Create a new reservation
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        // Add the reservation to the static list
        reservations.add(reservation);

        return reservation; // Return the newly created reservation
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        return java.util.List.of();
    }

    public Collection<Reservation> getCustomerReservation(Customer customer){
        // Filter reservations for the given customer
        List<Reservation> customerReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer)) {
                customerReservations.add(reservation);
            }
        }
        return customerReservations;
    }

    public void printAllReservation(){
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
