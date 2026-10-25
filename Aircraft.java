// Module: Aircraft Management (Justin Joe Mathew)
// Represents an aircraft with its flight details

public class Aircraft {
    String flightNo;
    String airline;
    String type;        // "Landing" or "Takeoff"
    boolean isEmergency; // true if medical/fuel emergency

    public Aircraft(String flightNo, String airline, String type, boolean isEmergency) {
        this.flightNo = flightNo;
        this.airline = airline;
        this.type = type;
        this.isEmergency = isEmergency;
    }

    // String representation to easily display in UI and queues
    @Override
    public String toString() {
        if (isEmergency) {
            return "[EMERGENCY] " + flightNo + " (" + airline + ")";
        }
        return flightNo + " (" + airline + ")";
    }
}
