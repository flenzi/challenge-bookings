package f.l.challenge.service.impl;

import f.l.challenge.dao.BookingEntityDAO;
import f.l.challenge.dto.BookingDto;
import f.l.challenge.exception.PropertyNotAvailableException;
import f.l.challenge.mapper.EntityMapper;
import f.l.challenge.model.Booking;
import f.l.challenge.model.User;
import f.l.challenge.service.EntityContext;
import f.l.challenge.service.EntityService;

import java.util.List;

import static f.l.challenge.dto.BookingTypeEnum.BLOCK;
import static f.l.challenge.dto.BookingTypeEnum.BOOKING;

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
        booking.setUser(User.builder().id(ctx.getUser()).build());

        List<Booking> bookings = bookingEntityDAO.searchBookings(ctx.getSearchFrom(), ctx.getSearchTo(), ctx.getPropertyId(), booking.getBookingType());

        if ((!bookings.isEmpty() && entity.getBookingType() == BOOKING)
                || (!bookings.isEmpty() && entity.getBookingType() == BLOCK && bookings.stream().anyMatch(b -> b.getBookingType() == BOOKING.getValue()))) {
            throw new PropertyNotAvailableException("There is a booking in the specified dates");
        }

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
