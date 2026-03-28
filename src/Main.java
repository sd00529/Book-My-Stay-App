public class Main{

    public static void main(String[] args) {

        // Create service manager
        AddonServiceManager manager = new AddonServiceManager();

        // Reservation ID
        String reservationId = "Single-1";

        // Create services
        AddonService breakfast = new AddonService("Breakfast", 500);
        AddonService airportPickup = new AddonService("Airport Pickup", 1000);

        // Add services to reservation
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, airportPickup);

        // Calculate total cost
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        // Output
        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}