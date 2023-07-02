package f.l.challenge.mapper;

import f.l.challenge.dto.BookingDto;
import f.l.challenge.dto.BookingTypeEnum;
import f.l.challenge.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    default BookingTypeEnum problemStatusFromString(int type) {
        return BookingTypeEnum.fromValue(type);
    }

    default int problemStatusToString(BookingTypeEnum bookingTypeEnum) {
        return bookingTypeEnum.getValue();
    }

    @Mapping(source = "property.id", target = "propertyId")
    BookingDto bookingToBookingDto(Booking booking);

    @Mapping(source = "propertyId", target = "property.id")
    Booking bookingDtoToBooking(BookingDto bookingDto);
}
