/**
 * MAIN CLASS - UseCase5BookingRequestQueue
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * @version 5.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Booking Request Queue\n");

        // Create queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create reservations
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process requests (FIFO)
        while (bookingQueue.hasPendingRequests()) {

            Reservation current = bookingQueue.getNextRequest();

            System.out.println(
                    "Processing booking for Guest: " +
                            current.getGuestName() +
                            ", Room Type: " +
                            current.getRoomType()
            );
        }
    }
}