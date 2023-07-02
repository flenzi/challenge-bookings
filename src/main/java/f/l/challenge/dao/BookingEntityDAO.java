package f.l.challenge.dao;

import f.l.challenge.model.Booking;

import java.util.List;

public interface BookingEntityDAO extends EntityDAO<Booking, Integer> {

    List<Booking> searchBookings(Integer searchFrom, Integer searchTo, Integer propertyId);
}
