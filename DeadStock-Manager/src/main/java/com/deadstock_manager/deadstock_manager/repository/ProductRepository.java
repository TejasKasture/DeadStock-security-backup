package com.deadstock_manager.deadstock_manager.repository;

import com.deadstock_manager.deadstock_manager.entity.Department;
import com.deadstock_manager.deadstock_manager.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByDsrNoContainingIgnoreCase(String dsrNo);

    List<Product> findByTypeContainingIgnoreCase(String type);

    List<Product> findByRoomNoContainingIgnoreCase(String roomNo);

    List<Product> findByCategoryContainingIgnoreCase(String category);


    // Find products for HOD by department (without status conditions)
    @Query("SELECT p FROM Product p WHERE p.department = :department")
    List<Product> findForHodByDepartment(@Param("department") Department department);

    // Find products for Lab Incharge by department and room (lab number) (without status conditions)
    @Query("SELECT p FROM Product p WHERE p.department = :department AND p.roomNo = :labNo")
    List<Product> findForLabInchargeByDepartmentAndRoom(@Param("department") Department department, @Param("labNo") String labNo);

    // Find products for Department DSR Incharge by department (without status conditions)
    @Query("SELECT p FROM Product p WHERE p.department = :department")
    List<Product> findForDeptDsrInchargeByDepartment(@Param("department") Department department);

    // Find products for Central DSR Incharge (without status conditions)
    @Query("SELECT p FROM Product p")
    List<Product> findForCentralDsrIncharge();

    // Find products for Principal (without status conditions)
    @Query("SELECT p FROM Product p")
    List<Product> findForPrincipal();
}
