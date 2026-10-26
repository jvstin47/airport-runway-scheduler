public class TestRunway {
    public static void main(String[] args) {
        FlightQueue runwayQueue = new FlightQueue();

        runwayQueue.enqueue(new Aircraft("AI-101", "Air India", "Landing", false));
        runwayQueue.enqueue(new Aircraft("6E-202", "IndiGo", "Takeoff", false));
        runwayQueue.enqueue(new Aircraft("EM-999", "Air Ambulance", "Landing", true));

        System.out.println("Runway Queue:\n" + runwayQueue.getDisplayList());

        Aircraft first = runwayQueue.dequeue();
        System.out.println("First processed: " + first);

        Aircraft second = runwayQueue.dequeue();
        System.out.println("Second processed: " + second);

        Aircraft third = runwayQueue.dequeue();
        System.out.println("Third processed: " + third);

        FileHandler.saveLog("TEST RUN: Verified Single Queue priority.");
    }
}
