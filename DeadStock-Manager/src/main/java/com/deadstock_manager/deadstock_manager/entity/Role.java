package com.deadstock_manager.deadstock_manager.entity;


public enum Role {
    LAB_ASSISTANT,
    LAB_INCHARGE,
    DEPARTMENT_DSR_INCHARGE,
    HOD,
    CENTRAL_DSR_INCHARGE
    ,PRINCIPAL;


    // Optionally, you can add descriptions or custom methods
    public String getRoleDescription() {
        switch (this) {
            case LAB_ASSISTANT:
                return "Handles requests and inventory for the assigned lab.";
            case LAB_INCHARGE:
                return "Manages lab-level approvals and oversees lab operations.";
            case DEPARTMENT_DSR_INCHARGE:
                return "Responsible for managing deadstock within the department.";
            case HOD:
                return "Head of Department; oversees department operations.";
            case CENTRAL_DSR_INCHARGE:
                return "Manages deadstock operations across the entire institution.";
            case PRINCIPAL:
                return "Head of Institute ; oversees institute operations..";
            default:
                return "Unknown role.";
        }
    }
}