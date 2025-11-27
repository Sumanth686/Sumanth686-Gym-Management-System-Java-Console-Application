package Gym_management;

public final class Member extends Person {
    private final Membership membership;
    private final String goal;

    public Member(String name, String email, Membership membership, String goal) {
        super(name, email);
        this.membership = membership;
        this.goal = goal;
    }

    public Membership getMembership() {
        return membership;
    }

    public String getGoal() {
        return goal;
    }
}
