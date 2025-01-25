package com.deadstock_manager.deadstock_manager.entity;

public enum Status {


        PENDING(0),
        APPROVED(1),
        DENIED(2);

        private final int value;

        Status(int value) {
                this.value = value;
        }

        public int getValue() {
                return this.value;
        }

        public static Status fromValue(int value) {
                for (Status status : Status.values()) {
                        if (status.getValue() == value) {
                                return status;
                        }
                }
                return null;
        }

}
