# Gym Management System (Java 21)

Console-based Gym Management System built in Java 21 for an OOP1 assignment. A trainer logs in, books members into classes, and views membership details and per-class statistics.

## Features

- Trainer login (only `sumanth` with password `Sumanth`).
- Book members into classes by schedule (reuses the same class for the same schedule).
- Membership types with fees:
  - GOLD (20,000)
  - SILVER (15,000)
  - PLATINUM (30,000)
- Store membership status and dates (ACTIVE / INACTIVE / SUSPENDED / EXPIRED).
- View all classes, enrolled members, and counts of GOLD / SILVER / PLATINUM members per class.

## Architecture & UML

Main domain types:

- `Person` (sealed superclass) with subclasses:
  - `Member` (final) – has a `Membership` and fitness goal.
  - `Trainer` (final) – has a specialty.
- `GymClass` (final) – represents a scheduled class with a `Trainer` and a list of `Member`s.
- `Schedulable` (sealed interface) – implemented by `GymClass` for schedule behaviour.
- `Membership` (record) – holds type, status, start date, and end date.
- `ContactInfo` (final) – custom immutable value object for person contact details.
- Enums: `MembershipType`, `MembershipStatus`, `ClassType`.

UML:

- Diagram file: `uml/gym-system.pdf` (uploaded in this repository).

## Java Language Features Demonstrated

- Sealed classes and interfaces (`Person`, `Schedulable`).
- Records (`Membership`) and custom immutable type (`ContactInfo`).
- Enums (`MembershipType`, `MembershipStatus`, `ClassType`).
- Method overloading and varargs (`GymClass.addMember`).
- LVTI (`var`) for local variables.
- Arrays (`Member[]`) alongside `List/ArrayList`.
- Interface default, static, and private methods (`Schedulable`).
- Lambdas with `Predicate` and method references (`filterMembers`, `gc::isGoldMember`).
- Switch expressions (modern `switch` on `MembershipType`).
- Basic exception handling for invalid user input.

## How to Run

Compile (Java 21+):

