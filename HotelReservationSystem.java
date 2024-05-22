import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        initializeRooms();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchRooms(scanner);
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", 50.0));
        rooms.add(new Room(102, "Double", 75.0));
        rooms.add(new Room(103, "Suite", 120.0));
        rooms.add(new Room(104, "Single", 50.0));
        rooms.add(new Room(105, "Double", 75.0));
    }

    private static void searchRooms(Scanner scanner) {
        System.out.print("Enter room category (Single, Double, Suite): ");
        String category = scanner.next();
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && !room.isBooked()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        Room room = findRoomByNumber(roomNumber);

        if (room != null && !room.isBooked()) {
            System.out.print("Enter your name: ");
            scanner.nextLine(); // consume newline
            String name = scanner.nextLine();
            System.out.print("Enter check-in date (YYYY-MM-DD): ");
            String checkInDate = scanner.next();
            System.out.print("Enter check-out date (YYYY-MM-DD): ");
            String checkOutDate = scanner.next();
            System.out.print("Enter payment amount: ");
            double paymentAmount = scanner.nextDouble();

            if (paymentAmount >= room.getPrice()) {
                room.setBooked(true);
                reservations.add(new Reservation(name, room, checkInDate, checkOutDate));
                System.out.println("Reservation successful!");
            } else {
                System.out.println("Insufficient payment. Reservation failed.");
            }
        } else {
            System.out.println("Room not available or invalid room number.");
        }
    }

    private static void viewReservations() {
        System.out.println("\nCurrent Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    private static Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}

class Room {
    private int number;
    private String category;
    private double price;
    private boolean booked;

    public Room(int number, String category, double price) {
        this.number = number;
        this.category = category;
        this.price = price;
        this.booked = false;
    }

    public int getNumber() {
        return number;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "Room " + number + " (" + category + ") - $" + price + " per night";
    }
}

class Reservation {
    private String name;
    private Room room;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(String name, Room room, String checkInDate, String checkOutDate) {
        this.name = name;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation for " + name + " in room " + room.getNumber() + " (" + room.getCategory() + ") from " + checkInDate + " to " + checkOutDate;
    }
}
