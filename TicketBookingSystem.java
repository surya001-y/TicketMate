import java.util.Scanner;

public class TicketBookingSystem {
    private static int totalTickets = 100; 
    private static int bookedTickets = 0;   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the TicketMate-Ticket Booking System!");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. View Available Tickets");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableTickets();
                    break;
                case 2:
                    bookTickets(scanner);
                    break;
                case 3:
                    cancelTickets(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the TicketMate-Ticket Booking System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    private static void viewAvailableTickets() {
        System.out.println("Available tickets: " + (totalTickets - bookedTickets));
    }

    private static void bookTickets(Scanner scanner) {
        System.out.print("Enter number of tickets to book: ");
        int ticketsToBook = scanner.nextInt();

        if (ticketsToBook <= 0) {
            System.out.println("Invalid number of tickets.");
        } else if (ticketsToBook <= (totalTickets - bookedTickets)) {
            bookedTickets += ticketsToBook;
            System.out.println(ticketsToBook + " tickets booked successfully.");
        } else {
            System.out.println("Sorry, only " + (totalTickets - bookedTickets) + " tickets are available.");
        }
    }

    private static void cancelTickets(Scanner scanner) {
        System.out.print("Enter number of tickets to cancel: ");
        int ticketsToCancel = scanner.nextInt();

        if (ticketsToCancel <= 0) {
            System.out.println("Invalid number of tickets.");
        } else if (ticketsToCancel <= bookedTickets) {
            bookedTickets -= ticketsToCancel;
            System.out.println(ticketsToCancel + " tickets cancelled successfully.");
        } else {
            System.out.println("You cannot cancel more tickets than booked.");
        }
    }
}