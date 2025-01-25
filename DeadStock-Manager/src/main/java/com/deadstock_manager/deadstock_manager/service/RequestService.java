package com.deadstock_manager.deadstock_manager.service;

import com.deadstock_manager.deadstock_manager.entity.Department;
import com.deadstock_manager.deadstock_manager.entity.Request;
import com.deadstock_manager.deadstock_manager.entity.Role;
import com.deadstock_manager.deadstock_manager.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Collections;

@Service
public class RequestService {

    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private RequestRepo requestRepo;

    public List<Request> getALL(Role role) {
        List<Request> pendingRequest = Collections.emptyList();  // Default to empty list

//        if (role == Role.HOD) {
//            pendingRequest = requestRepo.findRequestsForHod();
//        } else
//        else if (role == Role.LAB_INCHARGE) {
//            pendingRequest = requestRepo.findRequestsForLabIncharge();
//        }

//        else if(role == Role.DEPARTMENT_DSR_INCHARGE)
//        {
//            pendingRequest = requestRepo.findRequestsForDeptDsrIncharge();
//        }
        if (role == Role.CENTRAL_DSR_INCHARGE) {
            pendingRequest = requestRepo.findRequestsForCentralDsrIncharge();
        } else if (role == Role.PRINCIPAL) {
            pendingRequest = requestRepo.findRequestsForPrincipal();
       }
        else {
            logger.warn("Unrecognized role: {}", role);
        }

        if (pendingRequest == null) {
            logger.info("No requests found for role: {}", role);
            return Collections.emptyList();  // Return empty list if no data is found
        }

        logger.info("Found {} requests for role: {}", pendingRequest.size(), role);
        return pendingRequest;
    }

    public Request addProduct(Request request) {
        logger.info("Adding product with description: {}", request.getDescription());
        return requestRepo.save(request);
    }

    public List<Request> getAllByRoleAndDepartment(Role role, Department department,String labNo) {
        List<Request> filteredRequests = Collections.emptyList(); // Default to empty list

        try {
            if (role == Role.HOD) {
                filteredRequests = requestRepo.findRequestsForHodByDepartment(department);
            } else if (role == Role.LAB_INCHARGE) {
                filteredRequests = requestRepo.findRequestsForLabInchargeByDepartmentAndRoom(department,labNo);
            } else if (role == Role.DEPARTMENT_DSR_INCHARGE) {
                filteredRequests = requestRepo.findRequestsForDeptDsrInchargeByDepartment(department);
            } else if (role == Role.CENTRAL_DSR_INCHARGE) {
                filteredRequests = requestRepo.findRequestsForCentralDsrIncharge();
            } else if (role == Role.PRINCIPAL) {
                filteredRequests = requestRepo.findRequestsForPrincipal();
            } else {
                logger.warn("Unrecognized role: {}", role);
            }

            if (filteredRequests.isEmpty()) {
                logger.info("No requests found for role: {} and department: {}", role, department);
            } else {
                logger.info("Found {} requests for role: {} and department: {}", filteredRequests.size(), role, department);
            }
        } catch (Exception e) {
            logger.error("Error while fetching requests for role: {} and department: {}", role, department, e);
        }

        return filteredRequests;
    }

}
