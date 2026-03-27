import java.util.Queue;
import java.util.LinkedList;

/**
 * CLASS - BookingRequestQueue
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * @version 5.0
 */
public class BookingRequestQueue {

    // Queue to store requests
    private Queue<Reservation> requestQueue;

    /**
     * Constructor
     */
    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /**
     * Add request to queue
     */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    /**
     * Get next request (FIFO)
     */
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    /**
     * Check if queue has pending requests
     */
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}