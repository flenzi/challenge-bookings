INSERT INTO users (id, name) VALUES
    (1, 'John'),
    (2, 'Michael'),
    (3, 'Thomas');

INSERT INTO properties (id, name, city) VALUES
    (1, 'Hotel the moon', 'San Francisco'),
    (2, 'Spa Mr Francisco', 'San Francisco'),
    (3, 'The best place to relax', 'Oakland');


INSERT INTO bookings (id, user_id, from_date, to_date, property_id, booking_type) VALUES
    (10001, 1, '20230701', '20230705', 1, 1),
    (10002, 1, '20230801', '20230830', 2, 1),
    (10003, 2, '20230901', '20230902', 2, 1);


