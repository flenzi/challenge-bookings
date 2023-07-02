package f.l.challenge.mapper;

import f.l.challenge.dto.BookingDto;
import f.l.challenge.model.Booking;
import f.l.challenge.model.Property;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityMapperTest {

    private final EntityMapper entityMapper = EntityMapper.INSTANCE;


    int bookingId = 1;
    int propertyId = 2;
    LocalDate fromDate = LocalDate.of(2023,
                                      6,
                                      1);
    LocalDate toDate = LocalDate.of(2023,
                                    6,
                                    10);

    @Test
    public void testToDto() {
        Booking booking = Booking.builder()
                                 .id(bookingId)
                                 .fromDate(fromDate)
                                 .toDate(toDate)
                                 .property(Property.builder()
                                                   .id(propertyId)
                                                   .build())
                                 .build();


        BookingDto bookingDto = entityMapper.bookingToBookingDto(booking);

        assertEquals(bookingId,
                     bookingDto.getId());
        assertEquals(fromDate,
                     bookingDto.getFromDate());
        assertEquals(toDate,
                     bookingDto.getToDate());

        assertEquals(propertyId,
                     bookingDto.getPropertyId());

    }

    @Test
    public void testFromDto() {

        BookingDto bookingDto = BookingDto.builder()
                                          .id(bookingId)
                                          .fromDate(fromDate)
                                          .toDate(toDate)
                                          .propertyId(propertyId)
                                          .build();

        Booking booking = entityMapper.bookingDtoToBooking(bookingDto);

        assertEquals(bookingId,
                     booking.getId());
        assertEquals(fromDate,
                     booking.getFromDate());
        assertEquals(toDate,
                     booking.getToDate());
        assertEquals(propertyId,
                     booking.getProperty()
                            .getId());
    }
}