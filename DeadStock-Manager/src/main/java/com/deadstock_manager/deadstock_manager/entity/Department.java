package com.deadstock_manager.deadstock_manager.entity;



public enum Department {

    COMPUTER(1, "Computer"),
    IT(2, "Information Technology"),
    ENTC(3, "Electronics and Telecommunication"),
    ECE(4, "Electronics and Communication"),
    AIDS(5, "Artificial Intelligence and Data Science");

    private final int value;
    private final String fullName;

    Department(int value, String fullName) {
        this.value = value;
        this.fullName = fullName;
    }

    public int getValue() {
        return this.value;
    }

    public String getFullName() {
        return this.fullName;
    }

    public static Department fromValue(int value) {
        for (Department department : Department.values()) {
            if (department.getValue() == value) {
                return department;
            }
        }
        return null;
    }

    public static Department fromFullName(String fullName) {
        for (Department department : Department.values()) {
            if (department.getFullName().equalsIgnoreCase(fullName)) {
                return department;
            }
        }
        return null;
    }
}
