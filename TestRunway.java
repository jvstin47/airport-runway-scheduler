// Module: File Handling & Testing (Devika Suresh)
// Automated verification for Single Unified Runway Queue

public class TestRunway {
    public static void main(String[] args) {
        FlightQueue runwayQueue = new FlightQueue();

        System.out.println("--- 1. Enqueue Operations ---");
        // Routine landing joins at tail
        runwayQueue.enqueue(new Aircraft("AI-101", "Air India", "Landing", false));
        // Routine takeoff joins at tail
        runwayQueue.enqueue(new Aircraft("6E-202", "IndiGo", "Takeoff", false));
        // Emergency flight jumps directly to head
        runwayQueue.enqueue(new Aircraft("EM-999", "Air Ambulance", "Landing", true));

        System.out.println("\nRunway Queue (Notice EM-999 is at position 1):\n" + runwayQueue.getDisplayList());

        System.out.println("--- 2. Dequeue Operations ---");
        Aircraft first = runwayQueue.dequeue();
        System.out.println("First processed: " + first);
        if (first.isEmergency && first.flightNo.equals("EM-999")) {
            System.out.println(">> SUCCESS: Emergency flight processed first!");
        }

        Aircraft second = runwayQueue.dequeue();
        System.out.println("Second processed: " + second);

        Aircraft third = runwayQueue.dequeue();
        System.out.println("Third processed: " + third);

        FileHandler.saveLog("TEST RUN: Verified Single Queue priority.");
    }
}
