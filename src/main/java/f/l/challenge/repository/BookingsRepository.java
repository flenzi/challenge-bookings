package f.l.challenge.repository;

import f.l.challenge.model.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends CrudRepository<Booking, Integer> {

    @Query("SELECT b FROM Booking b " +
            "WHERE (:fromDate is null OR b.fromDate >= :fromDate) " +
            "AND (:toDate is null OR b.toDate <= :toDate) " +
            "AND (:propertyId is null OR b.property.id = :propertyId)")
    List<Booking> findByDateRangeAndPropertyId(@Param("fromDate") Integer fromDate, @Param("toDate") Integer toDate, Integer propertyId);

    @Query("SELECT b FROM Booking b " +
            "WHERE (:fromDate is null OR b.fromDate >= :fromDate) " +
            "AND (:toDate is null OR b.toDate <= :toDate) " +
            "AND (:propertyId is null OR b.property.id = :propertyId)" +
            "AND (:bookingType is null OR b.bookingType = :bookingType)")
    List<Booking> findByDateRangeAndPropertyIdAndBookingType(@Param("fromDate") Integer fromDate, @Param("toDate") Integer toDate, Integer propertyId, Integer bookingType);

}
