package Gym_management;

import java.util.*;

public class GymDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Secure Trainer login (only "sumanth" with password "Sumanth" allowed)
        String trainerName = "";
        String password = "";
        final String allowedName = "sumanth";
        final String allowedPassword = "Sumanth";

        do {
            System.out.println("=== Trainer Login ===");
            System.out.print("Enter your name: ");
            trainerName = scanner.nextLine().trim();
            System.out.print("Enter your password: ");
            password = scanner.nextLine().trim();

            if (!trainerName.equalsIgnoreCase(allowedName) || !password.equals(allowedPassword)) {
                System.out.println("Access denied. Only the authorized trainer can log in.\n");
            }
        } while (!trainerName.equalsIgnoreCase(allowedName) || !password.equals(allowedPassword));

        System.out.print("Enter your specialty: ");
        String specialty = scanner.nextLine();
        Trainer t = new Trainer(trainerName, "sumanth@default.com", specialty);

        List<GymClass> allClassBookings = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Book a new member");
            System.out.println("2. View all bookings");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter class schedule for this booking (e.g., Monday 7am): ");
                String schedule = scanner.nextLine();

                // Reuse existing GymClass for the same schedule if it exists
                GymClass gymClass = null;
                for (GymClass gc : allClassBookings) {
                    if (gc.getSchedule().equalsIgnoreCase(schedule)) {
                        gymClass = gc;
                        break;
                    }
                }
                if (gymClass == null) {
                    gymClass = new GymClass(ClassType.YOGA, schedule, t);
                    allClassBookings.add(gymClass);
                }

                System.out.println("Enter details for Member:");
                System.out.print("  Name: ");
                String name = scanner.nextLine();
                System.out.print("  Email: ");
                String email = scanner.nextLine();
                System.out.print("  Goal: ");
                String goal = scanner.nextLine();

                MembershipType type = null;
                while (type == null) {
                    System.out.println("  Membership categories/fees:");
                    System.out.println("    GOLD (20,000)");
                    System.out.println("    SILVER (15,000)");
                    System.out.println("    PLATINUM (30,000)");
                    System.out.print("  Membership type (GOLD/SILVER/PLATINUM): ");
                    String input = scanner.nextLine().trim().toUpperCase();
                    try {
                        type = MembershipType.valueOf(input);
                        String feeText = switch (type) {
                            case GOLD -> "Selected: GOLD (20,000)";
                            case SILVER -> "Selected: SILVER (15,000)";
                            case PLATINUM -> "Selected: PLATINUM (30,000)";
                        };
                        System.out.println("  " + feeText);
                    } catch (IllegalArgumentException e) {
                        System.out.println("    Invalid input! Please enter: GOLD, SILVER, or PLATINUM.");
                    }
                }

                MembershipStatus status = null;
                while (status == null) {
                    System.out.print("  Membership status (ACTIVE/INACTIVE/SUSPENDED/EXPIRED): ");
                    String input = scanner.nextLine().trim().toUpperCase();
                    try {
                        status = MembershipStatus.valueOf(input);
                    } catch (IllegalArgumentException e) {
                        System.out.println("    Invalid input! Please enter: ACTIVE, INACTIVE, SUSPENDED, or EXPIRED.");
                    }
                }

                System.out.print("  Start date (YYYY-MM-DD): ");
                String start = scanner.nextLine();
                System.out.print("  End date (YYYY-MM-DD): ");
                String end = scanner.nextLine();

                var membership = new Membership(type, status, start, end); // LVTI
                var member = new Member(name, email, membership, goal);    // LVTI

                // Simple array example (not used further, just to demonstrate arrays)
                Member[] lastTwoMembers = new Member[2];
                lastTwoMembers[0] = member;

                gymClass.addMember(member);

                System.out.println(">> Member booked for schedule: " + schedule + "\n");

            } else if (choice.equals("2")) {
                if (allClassBookings.isEmpty()) {
                    System.out.println("No bookings yet.");
                } else {
                    for (GymClass gc : allClassBookings) {
                        System.out.println("\nTrainer: " + gc.getTrainer().getName());
                        System.out.println("Class schedule: " + gc.getSchedule());
                        gc.printSchedule(); // default method from Schedulable
                        System.out.println("Members in class: " + gc.getCurrentSize());
                        System.out.println("All Members booked:");
                        for (Member m : gc.getMembers()) {
                            System.out.println(" - " + m.getName() + " -> " + m.getMembership().formattedDetails());
                        }

                        // counts per membership type for this class
                        var goldMembers = gc.findMembersByType(MembershipType.GOLD);
                        var silverMembers = gc.findMembersByType(MembershipType.SILVER);
                        var platinumMembers = gc.findMembersByType(MembershipType.PLATINUM);

                        System.out.println("  Gold members in this class: " + goldMembers.size());
                        System.out.println("  Silver members in this class: " + silverMembers.size());
                        System.out.println("  Platinum members in this class: " + platinumMembers.size());
                    }
                }
            } else if (choice.equals("3")) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}
