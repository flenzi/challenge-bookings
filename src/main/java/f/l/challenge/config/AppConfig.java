package f.l.challenge.config;

import f.l.challenge.dao.BookingEntityDAO;
import f.l.challenge.dao.impl.BookingJPAEntityDAO;
import f.l.challenge.dto.BookingDto;
import f.l.challenge.repository.BookingsRepository;
import f.l.challenge.service.EntityService;
import f.l.challenge.service.impl.BookingsEntityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookingEntityDAO entityDAO(BookingsRepository bookingsRepository) {
        return new BookingJPAEntityDAO(bookingsRepository);
    }

    @Bean
    public EntityService<BookingDto, Integer> bookingsEntityService(BookingEntityDAO entityDAO) {
        return new BookingsEntityService(entityDAO);
    }

}
