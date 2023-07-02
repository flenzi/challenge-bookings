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
            "WHERE b.fromDate <= :fromDate " +
            "AND  b.toDate >= :fromDate " +
            "AND (:propertyId is null OR b.property.id = :propertyId)")
    List<Booking> findByFromPropertyId(@Param("fromDate") Integer fromDate, Integer propertyId);

    @Query("SELECT b FROM Booking b " +
            "WHERE b.fromDate <= :toDate " +
            "AND  b.toDate >= :toDate " +
            "AND (:propertyId is null OR b.property.id = :propertyId)")
    List<Booking> findByToPropertyId(@Param("toDate") Integer toDate, Integer propertyId);

}
