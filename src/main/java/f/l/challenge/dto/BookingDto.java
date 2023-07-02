package f.l.challenge.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookingDto {
    private int id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private int propertyId;
    private BookingTypeEnum bookingType;
}

