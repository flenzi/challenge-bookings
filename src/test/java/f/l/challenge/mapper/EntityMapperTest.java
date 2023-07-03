package f.l.challenge.mapper;

import f.l.challenge.dto.BookingDto;
import f.l.challenge.dto.BookingTypeEnum;
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
    int fromDateInt = 20230601;
    LocalDate toDate = LocalDate.of(2023,
            6,
            10);
    int toDateInt = 20230610;

    @Test
    public void testToDto() {
        Booking booking = Booking.builder()
                .id(bookingId)
                .fromDate(fromDateInt)
                .toDate(toDateInt)
                .property(Property.builder()
                        .id(propertyId)
                        .build())
                .bookingType(1)
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

        assertEquals(BookingTypeEnum.BOOKING,
                bookingDto.getBookingType());

    }

    @Test
    public void testFromDto() {

        BookingDto bookingDto = BookingDto.builder()
                .id(bookingId)
                .fromDate(fromDate)
                .toDate(toDate)
                .propertyId(propertyId)
                .bookingType(BookingTypeEnum.BLOCK)
                .build();

        Booking booking = entityMapper.bookingDtoToBooking(bookingDto);

        assertEquals(bookingId,
                booking.getId());
        assertEquals(fromDateInt,
                booking.getFromDate());
        assertEquals(toDateInt,
                booking.getToDate());
        assertEquals(propertyId,
                booking.getProperty()
                        .getId());
        assertEquals(2,
                booking.getBookingType());
    }
}