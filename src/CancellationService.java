import java.util.*;

public class CancellationService {

    // Stack to track released room IDs (LIFO rollback)
    private Stack<String> rollbackStack;

    // Track cancelled reservations to avoid duplicate cancellation
    private Set<String> cancelledReservations;

    public CancellationService() {
        rollbackStack = new Stack<>();
        cancelledReservations = new HashSet<>();
    }

    /**
     * Cancels a booking and performs rollback
     */
    public void cancelBooking(String reservationId,
                              String roomType,
                              String roomId,
                              RoomInventory inventory,
                              BookingHistory history) throws InvalidBookingException {

        // Validate reservation existence
        if (reservationId == null || reservationId.isEmpty()) {
            throw new InvalidBookingException("Invalid reservation ID.");
        }

        // Prevent duplicate cancellation
        if (cancelledReservations.contains(reservationId)) {
            throw new InvalidBookingException("Booking already cancelled.");
        }

        // --- Step 1: Push roomId to rollback stack ---
        rollbackStack.push(roomId);

        // --- Step 2: Restore inventory ---
        int current = inventory.getAvailableRooms(roomType);
        inventory.updateAvailability(roomType, current + 1);

        // --- Step 3: Mark as cancelled ---
        cancelledReservations.add(reservationId);

        // --- Step 4: Update booking history (simple log) ---
        System.out.println("Booking cancelled for Reservation ID: " + reservationId);
    }

    /**
     * View rollback stack (for debugging/demo)
     */
    public void printRollbackStack() {
        System.out.println("Rollback Stack: " + rollbackStack);
    }
}