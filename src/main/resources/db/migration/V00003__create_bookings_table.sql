CREATE TABLE booking_types (
    id INT PRIMARY KEY,
    name VARCHAR(32)
);

create sequence bookings_seq increment by 1;

CREATE TABLE bookings (
    id INT PRIMARY KEY,
    user_id INT,
    from_date INT,
    to_date INT,
    property_id INT,
    booking_type INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (property_id) REFERENCES properties(id),
    FOREIGN KEY (booking_type) REFERENCES booking_types(id)
);

CREATE INDEX idx_from_date ON bookings (from_date);
CREATE INDEX idx_to_date ON bookings (to_date);