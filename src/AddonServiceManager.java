import java.util.*;

public class AddonServiceManager {

    // Map: Reservation ID → List of Services
    private Map<String, List<AddonService>> servicesByReservation;

    // Constructor
    public AddonServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    // Add service to a reservation
    public void addService(String reservationId, AddonService service) {

        // If reservation not present, create new list
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());

        // Add service
        servicesByReservation.get(reservationId).add(service);
    }

    // Calculate total service cost
    public double calculateTotalServiceCost(String reservationId) {

        double total = 0.0;

        List<AddonService> services = servicesByReservation.get(reservationId);

        if (services != null) {
            for (AddonService service : services) {
                total += service.getCost();
            }
        }

        return total;
    }
}