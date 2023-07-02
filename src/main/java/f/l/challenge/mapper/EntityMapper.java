package f.l.challenge.mapper;

import f.l.challenge.dto.BookingDto;
import f.l.challenge.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    @Mapping(source = "property.id", target = "propertyId")
    BookingDto bookingToBookingDto(Booking booking);

    @Mapping(source = "propertyId", target = "property.id")
    Booking bookingDtoToBooking(BookingDto bookingDto);
}
