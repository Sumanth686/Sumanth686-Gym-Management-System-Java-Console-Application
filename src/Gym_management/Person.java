package Gym_management;

public sealed class Person permits Member, Trainer {
    private final String name;
    private final ContactInfo contactInfo;

    public Person(String name, String email) {
        this.name = name;
        this.contactInfo = new ContactInfo(email, "");
    }

    public String getName() {
        return name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }
}
