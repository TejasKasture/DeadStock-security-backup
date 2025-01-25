package com.deadstock_manager.deadstock_manager.controller;

import com.deadstock_manager.deadstock_manager.entity.Department;
import com.deadstock_manager.deadstock_manager.entity.Product;
import com.deadstock_manager.deadstock_manager.entity.Request;
import com.deadstock_manager.deadstock_manager.entity.Role;
import com.deadstock_manager.deadstock_manager.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request/")
public class RequestController {

    @Autowired
    private RequestService requestService;


    @GetMapping("/{role}/get-all")
    public ResponseEntity<List<Request>> listResponseEntity(@PathVariable String role)
    {
        Role roleEnum = Role.valueOf(role.toUpperCase());

        List<Request> request = requestService.getALL(roleEnum);
        if(request!=null) {
            return new ResponseEntity<>(request, HttpStatus.OK);
        }

        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{role}/{dept}/{labNo}/get-all")
    public ResponseEntity<List<Request>> listResponseEntity(@PathVariable String role, @PathVariable String dept,@PathVariable String labNo) {
        try {
            // Convert role and department to enums
            Role roleEnum = Role.valueOf(role.toUpperCase());

            // Handle 'null' department
            Department departmentEnum = null;
            if (!"null".equalsIgnoreCase(dept)) {
                departmentEnum = Department.valueOf(dept.toUpperCase());
            }

            // Fetch data based on role and department
            List<Request> requests = requestService.getAllByRoleAndDepartment(roleEnum, departmentEnum,labNo);

            // Return the result
            if (requests != null && !requests.isEmpty()) {
                return new ResponseEntity<>(requests, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No data found
            }
        } catch (IllegalArgumentException e) {
            // Handle invalid role or department
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Handle general exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody Request request){
        Request product = requestService.addProduct(request);
        System.out.println("desc: " +product.description);
        if(product!=null){
            return new ResponseEntity<>("Product Added",HttpStatus.OK);
        }
        return new ResponseEntity<>("Product Not Added",HttpStatus.BAD_REQUEST);
    }



}
