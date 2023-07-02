package f.l.challenge.dao.impl;

import f.l.challenge.dao.BookingEntityDAO;
import f.l.challenge.exception.EntityDoesNotExistException;
import f.l.challenge.model.Booking;
import f.l.challenge.repository.BookingsRepository;

import java.util.List;
import java.util.Optional;

public class BookingJPAEntityDAO implements BookingEntityDAO {

    private final BookingsRepository bookingsRepository;

    public BookingJPAEntityDAO(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }

    @Override
    public Booking findById(Integer entityId) throws EntityDoesNotExistException {
        Booking booking;
        Optional<Booking> findByIdOptional = bookingsRepository.findById(entityId);
        if (findByIdOptional.isEmpty()) {
            throw new EntityDoesNotExistException("Entity not found");
        }
        booking = findByIdOptional.get();
        return booking;
    }

    @Override
    public Booking create(Booking entity) {
        return bookingsRepository.save(entity);
    }

    @Override
    public Booking update(Integer entityId,
                          Booking entity) throws EntityDoesNotExistException {
        Booking updatedEntity;
        if (!bookingsRepository.existsById(entityId)) {
            throw new EntityDoesNotExistException("Entity with id " + entityId + " does not exist");
        }
        updatedEntity = bookingsRepository.save(entity);
        return updatedEntity;
    }

    @Override
    public Booking delete(Integer entityId) throws EntityDoesNotExistException {
        Optional<Booking> entity = bookingsRepository.findById(entityId);
        bookingsRepository.deleteById(entityId);
        return entity.get();
    }

    @Override
    public List<Booking> searchBookings(Integer searchFrom, Integer searchTo, Integer propertyId) {
        return bookingsRepository.findByDateRangeAndPropertyId(searchFrom, searchTo, propertyId);
    }

    @Override
    public List<Booking> searchBookings(Integer searchFrom, Integer searchTo, Integer propertyId, Integer bookingType) {
        return bookingsRepository.findByDateRangeAndPropertyIdAndBookingType(searchFrom, searchTo, propertyId, bookingType);
    }
}
