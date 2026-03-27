import java.util.Map;
public class RoomSearchService {

    /**
     * Displays available rooms along with details
     *
     * @param inventory centralized inventory
     * @param singleRoom single room object
     * @param doubleRoom double room object
     * @param suiteRoom suite room object
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        // Get availability (READ-ONLY)
        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search Results\n");

        // ✅ Single Room
        if (availability.get("Single") > 0) {
            System.out.println("Single Room:");
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Single"));
            System.out.println();
        }

        // ✅ Double Room
        if (availability.get("Double") > 0) {
            System.out.println("Double Room:");
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Double"));
            System.out.println();
        }

        // ✅ Suite Room
        if (availability.get("Suite") > 0) {
            System.out.println("Suite Room:");
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Suite"));
        }
    }
}