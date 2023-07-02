package f.l.challenge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bookings_generator")
    @SequenceGenerator(name = "bookings_generator", sequenceName = "bookings_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Integer fromDate;

    private Integer toDate;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    private int bookingType;
}

