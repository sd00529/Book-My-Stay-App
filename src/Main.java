public class Main {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation & Inventory Rollback");

        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();
        CancellationService cancellationService = new CancellationService();

        // Sample reservation
        String reservationId = "R101";
        String roomType = "Single";
        String roomId = "S1";

        try {
            // Before cancellation
            System.out.println("Available Single Rooms BEFORE: "
                    + inventory.getAvailableRooms(roomType));

            // Perform cancellation
            cancellationService.cancelBooking(
                    reservationId,
                    roomType,
                    roomId,
                    inventory,
                    history
            );

            // After cancellation
            System.out.println("Available Single Rooms AFTER: "
                    + inventory.getAvailableRooms(roomType));

            // Show rollback stack
            cancellationService.printRollbackStack();

        } catch (InvalidBookingException e) {
            System.out.println("Cancellation failed: " + e.getMessage());
        }
    }
}