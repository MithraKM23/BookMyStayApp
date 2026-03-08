**#Use Case 4 - Reservation Confirmation & Room Allocation**

**##Purpose**

This feature confirms reservations and assigns unique room IDs.

**##Data Structures**

Set < String >  bookedRoomIds

HashMap < String, Set< String > > roomAssignments

**##Features**

- Assign unique room IDs
- Prevent duplicate bookings
- Update inventory after booking
