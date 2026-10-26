public class Aircraft {
    String flightNo;
    String airline;
    String type;
    boolean isEmergency;

    public Aircraft(String flightNo, String airline, String type, boolean isEmergency) {
        this.flightNo = flightNo;
        this.airline = airline;
        this.type = type;
        this.isEmergency = isEmergency;
    }

    @Override
    public String toString() {
        if (isEmergency) {
            return "[EMERGENCY] " + flightNo + " (" + airline + ")";
        }
        return flightNo + " (" + airline + ")";
    }
}
