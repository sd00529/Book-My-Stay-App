import java.util.*;

/**
 * CLASS - RoomAllocationService
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.0
 */
public class RoomAllocationService {

    // Stores all allocated room IDs (global uniqueness)
    private Set<String> allocatedRoomIds;

    // Stores assigned rooms by type
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirm booking and allocate room
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        // Check availability
        int available = inventory.getRoomAvailability().getOrDefault(roomType, 0);

        if (available <= 0) {
            System.out.println("Booking failed for " + reservation.getGuestName() +
                    " (No rooms available)");
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Ensure uniqueness (extra safety)
        if (allocatedRoomIds.contains(roomId)) {
            System.out.println("Error: Duplicate room ID detected!");
            return;
        }

        // Store globally
        allocatedRoomIds.add(roomId);

        // Store by type
        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // Update inventory (CRITICAL STEP)
        inventory.updateAvailability(roomType, available - 1);

        // Confirm booking
        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: "
                + roomId);
    }

    /**
     * Generate unique room ID
     */
    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        return roomType + "-" + count;
    }
}