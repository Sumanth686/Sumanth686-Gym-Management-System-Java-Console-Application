package Gym_management;

public sealed interface Schedulable permits GymClass {

    String getSchedule();
    void setSchedule(String schedule);

    default void printSchedule() {
        System.out.println("Current schedule: " + normalized(getSchedule()));
    }

    static boolean isValidSchedule(String schedule) {
        return schedule != null && !schedule.isBlank();
    }

    private String normalized(String schedule) {
        return schedule == null ? "" : schedule.trim();
    }
}
