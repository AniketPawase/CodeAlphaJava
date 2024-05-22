import java.util.ArrayList;
import java.util.Scanner;

public class TravelItineraryPlanner {

    static class Destination {
        String name;
        String date;
        String preferences;

        Destination(String name, String date, String preferences) {
            this.name = name;
            this.date = date;
            this.preferences = preferences;
        }

        @Override
        public String toString() {
            return "Destination: " + name + ", Date: " + date + ", Preferences: " + preferences;
        }
    }

    private ArrayList<Destination> itinerary;
    private double budget;

    public TravelItineraryPlanner() {
        itinerary = new ArrayList<>();
        budget = 0.0;
    }

    public void addDestination(String name, String date, String preferences) {
        Destination destination = new Destination(name, date, preferences);
        itinerary.add(destination);
    }

    public void displayItinerary() {
        System.out.println("\nYour Travel Itinerary:");
        for (Destination destination : itinerary) {
            System.out.println(destination);
        }
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelItineraryPlanner planner = new TravelItineraryPlanner();

        System.out.println("Welcome to the Travel Itinerary Planner!");

        System.out.print("Enter your budget: $");
        double budget = scanner.nextDouble();
        planner.setBudget(budget);

        boolean addingDestinations = true;
        while (addingDestinations) {
            System.out.print("Enter destination name: ");
            String name = scanner.next();

            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.next();

            System.out.print("Enter preferences (e.g., sightseeing, adventure, relaxation): ");
            scanner.nextLine();  // consume the newline
            String preferences = scanner.nextLine();

            planner.addDestination(name, date, preferences);

            System.out.print("Would you like to add another destination? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                addingDestinations = false;
            }
        }

        planner.displayItinerary();
        System.out.printf("Your budget is: $%.2f\n", planner.getBudget());

        // Placeholder for additional features
        System.out.println("\nAdditional features like maps and weather information will be here.");

        scanner.close();
    }
}
