INSERT INTO users (id, name) VALUES
    (1, 'John'),
    (2, 'Michael'),
    (3, 'Thomas');

INSERT INTO properties (id, name, city) VALUES
    (1, 'Hotel the moon', 'San Francisco'),
    (2, 'Spa Mr Francisco', 'San Francisco'),
    (3, 'The best place to relax', 'Oakland');


INSERT INTO bookings (id, user_id, from_date, to_date, property_id, type_id) VALUES
    (1, 1, '2023-07-01 00:00:00.000', '2023-07-05 00:00:00.000', 1, 1),
    (2, 1, '2023-08-01 00:00:00.000', '2023-08-30 00:00:00.000', 2, 1);

