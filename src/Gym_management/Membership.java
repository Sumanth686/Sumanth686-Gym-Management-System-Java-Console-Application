package Gym_management;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record Membership(MembershipType type, MembershipStatus status, String start, String end) {

    public String formattedDetails() {
        var builder = new StringBuilder();
        builder.append("Type: ").append(type)
               .append(", Status: ").append(status);

        try {
            var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.parse(start, formatter);
            LocalDate endDate = LocalDate.parse(end, formatter);
            builder.append(", From: ").append(startDate)
                   .append(" To: ").append(endDate);
        } catch (Exception e) {
            builder.append(", From: ").append(start)
                   .append(" To: ").append(end);
        }
        return builder.toString();
    }
}
