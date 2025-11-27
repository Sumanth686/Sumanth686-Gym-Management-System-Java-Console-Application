package Gym_management;

public final class Trainer extends Person {
    private final String specialty;

    public Trainer(String name, String email, String specialty) {
        super(name, email);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }
}
