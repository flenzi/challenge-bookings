package f.l.challenge;

import f.l.challenge.dto.BookingDto;
import f.l.challenge.service.EntityContext;
import f.l.challenge.service.impl.BookingsEntityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BookingsChallengeApplicationTests {

    @Autowired
    public BookingsEntityService bookingsEntityService;

    @Test
    void contextLoads() {
    }

    @Test
    public void findByIdTest() {
        BookingDto bookingDto = bookingsEntityService.findById(1, new EntityContext(Map.of()));
        assertNotNull(bookingDto);
    }

    @Test
    public void searchTest() {
        EntityContext entityContext = new EntityContext(Map.of());
        entityContext.setSearchFrom(LocalDate.of(2023, 8, 1));
        entityContext.setSearchTo(LocalDate.of(2023, 10, 1));
        entityContext.setPropertyId(2);

        List<BookingDto> bookingDtos = bookingsEntityService.search(entityContext);
        assertEquals(2, bookingDtos.size());
    }

    @Test
    public void searchWithoutPropertyIdTest() {
        EntityContext entityContext = new EntityContext(Map.of());
        entityContext.setSearchFrom(LocalDate.of(2021, 8, 1));
        entityContext.setSearchTo(LocalDate.of(2024, 10, 1));

        List<BookingDto> bookingDtos = bookingsEntityService.search(entityContext);
        assertEquals(3, bookingDtos.size());
    }

}
