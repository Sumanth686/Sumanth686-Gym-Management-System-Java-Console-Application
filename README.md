# Gym Management System (Java 21)

Console-based Gym Management System built in Java 21 for an OOP1 assignment. A trainer logs in, books members into classes, and views membership details and statistics.

## Features
- Trainer login (only `sumanth` with password `Sumanth`).
- Book members into classes by schedule (reuses the same class for the same schedule).
- Membership types with fees: GOLD (20,000), SILVER (15,000), PLATINUM (30,000).
- View all classes, members, and per-class counts of GOLD/SILVER/PLATINUM members.

## Architecture & UML

The core domain is modelled with:

- `Person` (sealed superclass) → `Member`, `Trainer` (final subclasses).
- `GymClass` implementing sealed interface `Schedulable`.
- `Membership` (record) and immutable `ContactInfo`.
- Enums: `MembershipType`, `MembershipStatus`, `ClassType`.

A PlantUML class diagram is provided:

- Source: `uml/gym-system.puml`
- Image: `uml/gym-system.png`

Use any PlantUML renderer to regenerate the diagram from `gym-system.puml`.

## Java Language Features

- Sealed classes and interfaces (`Person`, `Schedulable`).
- Records (`Membership`) and custom immutable type (`ContactInfo`).
- Enums, streams, lambdas with `Predicate`, method references.
- Varargs, method overloading, LVTI (`var`), arrays, switch expressions.
- Interface default/static/private methods, unmodifiable lists, and basic exception handling.

## Run


Login with:

- Name: `sumanth`
- Password: `Sumanth`
