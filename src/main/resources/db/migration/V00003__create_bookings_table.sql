CREATE TABLE booking_types (
    id INT PRIMARY KEY,
    name VARCHAR(32)
);

CREATE TABLE bookings (
    id INTEGER PRIMARY KEY,
    user_id INT,
    from_date DATE,
    to_date DATE,
    property_id INT,
    booking_type INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (property_id) REFERENCES properties(id)
    FOREIGN KEY (booking_type) REFERENCES booking_types(id)
);

CREATE INDEX idx_from_date ON bookings (from_date);
CREATE INDEX idx_to_date ON bookings (to_date);