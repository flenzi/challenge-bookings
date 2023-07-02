package f.l.challenge.mapper;

import f.l.challenge.dto.BookingDto;
import f.l.challenge.dto.BookingTypeEnum;
import f.l.challenge.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    @Named("localDateToInt")
    static int localDateToInt(LocalDate localDate) {
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        return (year * 10000) + (month * 100) + day;
    }

    @Named("intToLocalDate")
    static LocalDate intToLocalDate(int intDate) {
        int year = intDate / 10000;
        int month = (intDate / 100) % 100;
        int day = intDate % 100;
        return LocalDate.of(year, month, day);
    }

    default BookingTypeEnum problemStatusFromString(int type) {
        return BookingTypeEnum.fromValue(type);
    }

    default int problemStatusToString(BookingTypeEnum bookingTypeEnum) {
        return bookingTypeEnum.getValue();
    }

    @Mapping(source = "property.id", target = "propertyId")
    @Mapping(target = "fromDate", source = "fromDate", qualifiedByName = "intToLocalDate")
    @Mapping(target = "toDate", source = "toDate", qualifiedByName = "intToLocalDate")
    BookingDto bookingToBookingDto(Booking booking);

    @Mapping(source = "propertyId", target = "property.id")
    @Mapping(target = "fromDate", source = "fromDate", qualifiedByName = "localDateToInt")
    @Mapping(target = "toDate", source = "toDate", qualifiedByName = "localDateToInt")
    Booking bookingDtoToBooking(BookingDto bookingDto);

    List<BookingDto> bookingsToBookingDtos(List<Booking> bookings);
}
