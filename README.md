## Build project
`./gradlew clean build`


## Run the app
`./gradlew bootRun`


### Notes
The file V00005__insert_testdata.sql contains test data

### Example calls to test
Find a booking by Id

`curl http://localhost:8080/booking/10001`

Delete a booking

`curl -X DELETE http://localhost:8080/booking/10003`

Create a booking
```
curl -X POST -H "Content-Type: application/json" -H "userId: 1" -d '{
"fromDate": "2027-07-08",
"toDate": "2027-07-09",
"propertyId": 1,
"bookingType": "BOOKING"
} 'http://localhost:8080/booking/
```

Search bookings

`curl 'http://localhost:8080/booking/search?searchFrom=2020-07-01&searchTo=2033-07-07&propertyId=1'`
