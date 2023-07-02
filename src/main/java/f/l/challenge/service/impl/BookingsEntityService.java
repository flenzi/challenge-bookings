package f.l.challenge.service.impl;

import f.l.challenge.dao.EntityDAO;
import f.l.challenge.dto.BookingDto;
import f.l.challenge.mapper.EntityMapper;
import f.l.challenge.model.Booking;
import f.l.challenge.service.EntityContext;
import f.l.challenge.service.EntityService;

public class BookingsEntityService implements EntityService<BookingDto, Integer> {

    private final EntityDAO<Booking, Integer> entityDAO;

    public BookingsEntityService(EntityDAO<Booking, Integer> entityDAO) {
        this.entityDAO = entityDAO;
    }

    @Override
    public BookingDto findById(Integer entityId,
                               EntityContext ctx) {
        Booking booking = entityDAO.findById(entityId);
        return EntityMapper.INSTANCE.bookingToBookingDto(booking);
    }

    @Override
    public BookingDto save(BookingDto entity,
                           EntityContext ctx) {
        Booking booking = EntityMapper.INSTANCE.bookingDtoToBooking(entity);
        Booking savedBooking = entityDAO.create(booking);
        return EntityMapper.INSTANCE.bookingToBookingDto(savedBooking);
    }

    @Override
    public BookingDto save(Integer entityId,
                           BookingDto entity,
                           EntityContext ctx) {
        Booking booking = EntityMapper.INSTANCE.bookingDtoToBooking(entity);
        Booking updatedBooking = entityDAO.update(entityId, booking);
        return EntityMapper.INSTANCE.bookingToBookingDto(updatedBooking);
    }

    @Override
    public BookingDto remove(Integer entityId,
                             EntityContext ctx) {
        Booking booking = entityDAO.delete(entityId);
        return EntityMapper.INSTANCE.bookingToBookingDto(booking);
    }
}
