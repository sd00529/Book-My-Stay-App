/**
 * MAIN CLASS - UseCase6RoomAllocation
 *
 * @version 6.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing\n");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Booking queue (UC5)
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Allocation service
        RoomAllocationService allocator = new RoomAllocationService();

        // Process queue (FIFO)
        while (queue.hasPendingRequests()) {

            Reservation current = queue.getNextRequest();

            allocator.allocateRoom(current, inventory);
        }
    }
}