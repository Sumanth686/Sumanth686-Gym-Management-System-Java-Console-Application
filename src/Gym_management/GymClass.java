package Gym_management;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class GymClass implements Schedulable {
    private final ClassType classType;
    private String schedule;
    private final Trainer trainer;
    private final List<Member> members = new ArrayList<>();
    private static final int MAX_CLASS_SIZE = 20;

    public GymClass(ClassType classType, String schedule, Trainer trainer) {
        this.classType = classType;
        this.schedule = schedule;
        this.trainer = trainer;
    }

    @Override
    public String getSchedule() {
        return schedule;
    }

    @Override
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public boolean addMember(Member m) {
        if (members.size() < MAX_CLASS_SIZE && !members.contains(m)) {
            members.add(m);
            return true;
        }
        return false;
    }

    // Overloaded + varargs
    public boolean addMember(Member... newMembers) {
        boolean allAdded = true;
        for (Member m : newMembers) {
            boolean added = addMember(m);
            if (!added) {
                allAdded = false;
            }
        }
        return allAdded;
    }

    public int getCurrentSize() {
        return members.size();
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    // Lambda/stream to filter members by membership type
    public List<Member> findMembersByType(MembershipType type) {
        return members.stream()
                .filter(m -> m.getMembership().type() == type)
                .collect(Collectors.toList());
    }

    // Generic filter using Predicate + lambdas
    public List<Member> filterMembers(Predicate<Member> predicate) {
        return members.stream()
                .filter(predicate)
                .toList();
    }

    // Method reference target
    public boolean isGoldMember(Member m) {
        return m.getMembership().type() == MembershipType.GOLD;
    }
}
