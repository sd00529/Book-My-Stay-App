public class AddonService {

    // Name of the service
    private String serviceName;

    // Cost of the service
    private double cost;

    // Constructor
    public AddonService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    // Getter for service name
    public String getServiceName() {
        return serviceName;
    }

    // Getter for cost
    public double getCost() {
        return cost;
    }
}