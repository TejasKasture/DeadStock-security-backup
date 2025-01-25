package com.deadstock_manager.deadstock_manager.repository;

import com.deadstock_manager.deadstock_manager.entity.Department;
import com.deadstock_manager.deadstock_manager.entity.Request;
import com.deadstock_manager.deadstock_manager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepo extends JpaRepository<Request, Long> {
//    @Query("SELECT r FROM Request r WHERE r.role = :role AND r.status = 'PENDING'")
//    List<Request> getPendingRequestByRole(@Param("role") Role role);


//    @Query("SELECT r FROM Request r WHERE r.labStatus = 'APPROVED' AND r.hodStatus = 'PENDING'")
//    List<Request> findRequestsForHod();
//
//    @Query("SELECT r FROM Request r WHERE r.labStatus = 'APPROVED' AND r.hodStatus = 'APPROVED' AND r.centralDsrIcStatus = 'PENDING'")
//    List<Request> findRequestsForCentralDsrIncharge();
//
//    @Query("SELECT r FROM Request r WHERE r.labStatus = 'APPROVED' AND r.hodStatus = 'APPROVED' AND r.centralDsrIcStatus = 'APPROVED' AND r.principalStatus = 'PENDING'")
//    List<Request> findRequestsForPrincipal();
//
//    @Query("SELECT r FROM Request r WHERE r.labStatus = 'PENDING' AND r.hodStatus = 'PENDING'")
//    List<Request> findRequestsForLabIncharge();
//
//    List<Request> findRequestsForDeptDsrIncharge();

//    @Query("SELECT r FROM Request r WHERE r.labStatus = 1 AND r.hodStatus = 0") // Assuming 1 for 'APPROVED' and 0 for 'PENDING'
//    List<Request> findRequestsForHod();
//
//    @Query("SELECT r FROM Request r WHERE r.labStatus = 1 AND r.hodStatus = 1 AND r.centralDsrIcStatus = 0") // Adjusted for 'APPROVED' and 'PENDING' integer values
//    List<Request> findRequestsForCentralDsrIncharge();
//
//    @Query("SELECT r FROM Request r WHERE r.labStatus = 1 AND r.hodStatus = 1 AND r.centralDsrIcStatus = 1 AND r.principalStatus = 0") // Same assumption for 'PENDING' and 'APPROVED'
//    List<Request> findRequestsForPrincipal();
//
//    @Query("SELECT r FROM Request r WHERE r.labStatus = 0 AND r.hodStatus = 0") // Assumed 0 for 'PENDING' statuses
//    List<Request> findRequestsForLabIncharge();
//
//    @Query("SELECT r FROM Request r WHERE r.deptDsrIcStatus IN (0, 1, 2)")
//    List<Request> findRequestsForDeptDsrIncharge();

    // Find requests for HOD based on department
    @Query("SELECT r FROM Request r WHERE r.labStatus = 1 AND r.hodStatus = 0 AND r.department = :department")
    List<Request> findRequestsForHodByDepartment(@Param("department") Department department);

    // Find requests for Central DSR Incharge
    @Query("SELECT r FROM Request r WHERE r.labStatus = 1 AND r.hodStatus = 1 AND r.centralDsrIcStatus = 0")
    List<Request> findRequestsForCentralDsrIncharge();

    // Find requests for Principal
    @Query("SELECT r FROM Request r WHERE r.labStatus = 1 AND r.hodStatus = 1 AND r.centralDsrIcStatus = 1 AND r.principalStatus = 0")
    List<Request> findRequestsForPrincipal();

//    // Find requests for Lab Incharge based on department
//    @Query("SELECT r FROM Request r WHERE r.labStatus = 0 AND r.hodStatus = 0 AND r.department = :department")
//    List<Request> findRequestsForLabInchargeByDepartment(@Param("department") Department department);
    @Query("SELECT r FROM Request r WHERE r.labStatus = 0 AND r.hodStatus = 0 AND r.department = :department AND r.roomNo = :roomNo")
    List<Request> findRequestsForLabInchargeByDepartmentAndRoom(@Param("department") Department department, @Param("roomNo") String roomNo);

    // Find requests for Department DSR Incharge based on department
    @Query("SELECT r FROM Request r WHERE r.deptDsrIcStatus IN (0, 1, 2) AND r.department = :department")
    List<Request> findRequestsForDeptDsrInchargeByDepartment(@Param("department") Department department);


}
