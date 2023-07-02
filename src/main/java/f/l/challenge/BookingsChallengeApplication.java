package f.l.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("f.l.challenge.model")
public class BookingsChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingsChallengeApplication.class,
                              args);
    }

}
