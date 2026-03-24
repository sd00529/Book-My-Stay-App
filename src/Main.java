public class Main {
    /**
     * MAIN CLASS - UseCase2RoomInitialization
     *
     * Use Case 2: Basic Room Types & Static Availability
     *
     * Demonstrates object-oriented modeling using
     * inheritance and abstraction.
     *
     * Availability is represented using simple variables.
     *
     * @version 2.0
     */

//UC2
        /**
         * Application entry point
         *
         * @param args command-line arguments
         */
        public static void main(String[] args) {

            System.out.println("Hotel Room Initialization\n");

            // Create room objects
            Room singleRoom = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suiteRoom = new SuiteRoom();

            // Static availability
            int singleAvailable = 5;
            int doubleAvailable = 3;
            int suiteAvailable = 2;

            // Display details
            System.out.println("Single Room:");
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + singleAvailable + "\n");

            System.out.println("Double Room:");
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + doubleAvailable + "\n");

            System.out.println("Suite Room:");
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + suiteAvailable);
        }

}
