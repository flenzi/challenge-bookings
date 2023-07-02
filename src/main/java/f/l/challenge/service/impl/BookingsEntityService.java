package f.l.challenge.service.impl;

import f.l.challenge.dao.BookingEntityDAO;
import f.l.challenge.dto.BookingDto;
import f.l.challenge.mapper.EntityMapper;
import f.l.challenge.model.Booking;
import f.l.challenge.service.EntityContext;
import f.l.challenge.service.EntityService;

import java.util.List;

public class BookingsEntityService implements EntityService<BookingDto, Integer> {

    private final BookingEntityDAO bookingEntityDAO;

    public BookingsEntityService(BookingEntityDAO bookingEntityDAO) {
        this.bookingEntityDAO = bookingEntityDAO;
    }

    @Override
    public BookingDto findById(Integer entityId,
                               EntityContext ctx) {
        Booking booking = bookingEntityDAO.findById(entityId);
        return EntityMapper.INSTANCE.bookingToBookingDto(booking);
    }

    @Override
    public BookingDto save(BookingDto entity,
                           EntityContext ctx) {
        Booking booking = EntityMapper.INSTANCE.bookingDtoToBooking(entity);
        Booking savedBooking = bookingEntityDAO.create(booking);
        return EntityMapper.INSTANCE.bookingToBookingDto(savedBooking);
    }

    @Override
    public BookingDto save(Integer entityId,
                           BookingDto entity,
                           EntityContext ctx) {
        Booking booking = EntityMapper.INSTANCE.bookingDtoToBooking(entity);
        Booking updatedBooking = bookingEntityDAO.update(entityId, booking);
        return EntityMapper.INSTANCE.bookingToBookingDto(updatedBooking);
    }

    @Override
    public BookingDto remove(Integer entityId,
                             EntityContext ctx) {
        Booking booking = bookingEntityDAO.delete(entityId);
        return EntityMapper.INSTANCE.bookingToBookingDto(booking);
    }

    @Override
    public List<BookingDto> search(EntityContext ctx) {
        List<Booking> bookings = bookingEntityDAO.searchBookings(ctx.getSearchFrom(), ctx.getSearchTo(), ctx.getPropertyId());
        return EntityMapper.INSTANCE.bookingsToBookingDtos(bookings);
    }
}
