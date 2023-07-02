package f.l.challenge.controller;

import f.l.challenge.dto.BookingDto;
import f.l.challenge.service.EntityContext;
import f.l.challenge.service.EntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final EntityService<BookingDto, Integer> bookingsEntityService;

    public BookingController(EntityService<BookingDto, Integer> bookingsEntityService) {
        this.bookingsEntityService = bookingsEntityService;
    }

    @GetMapping(path = "/{bookingId}", produces = "application/json")
    public ResponseEntity<BookingDto> getEntityById(final @PathVariable("bookingId") int bookingId,
                                                    final @RequestHeader Map<String, Object> headers) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookingsEntityService.findById(bookingId,
                        new EntityContext(headers)));
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookingDto> createEntity(final @RequestBody BookingDto entity,
                                                   final @RequestHeader Map<String, Object> headers) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookingsEntityService.save(entity,
                        new EntityContext(headers)));
    }

    @DeleteMapping(path = "/{bookingId}", produces = "application/json")
    public ResponseEntity<BookingDto> deleteEntityById(
            final @PathVariable("bookingId") int bookingId,
            final @RequestHeader Map<String, Object> headers) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookingsEntityService.remove(bookingId,
                        new EntityContext(headers)));
    }

    @PutMapping(path = "/{bookingId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookingDto> updateEntity(final @PathVariable("bookingId") int bookingId,
                                                   final @RequestBody BookingDto entity,
                                                   final @RequestHeader Map<String, Object> headers) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookingsEntityService.save(bookingId,
                        entity,
                        new EntityContext(headers)));
    }


}
