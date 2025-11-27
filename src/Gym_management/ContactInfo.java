package Gym_management;

public final class ContactInfo {
    private final String email;
    private final String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String email() {
        return email;
    }

    public String phone() {
        return phone;
    }
}
