package com.deadstock_manager.deadstock_manager.service;

import com.deadstock_manager.deadstock_manager.entity.Department;
import com.deadstock_manager.deadstock_manager.entity.Product;
import com.deadstock_manager.deadstock_manager.entity.Request;
import com.deadstock_manager.deadstock_manager.entity.Role;
import com.deadstock_manager.deadstock_manager.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> searchProductByDsrNo(String dsrNo) {
        return productRepository.findByDsrNoContainingIgnoreCase(dsrNo);
    }

    // Search by type
    public List<Product> searchProductByType(String type) {
        return productRepository.findByTypeContainingIgnoreCase(type);
    }

    // Search by roomNo
    public List<Product> searchProductByRoomNo(String roomNo) {
        return productRepository.findByRoomNoContainingIgnoreCase(roomNo);
    }

    // Search by category
    public List<Product> searchProductByCategory(String category) {
        return productRepository.findByCategoryContainingIgnoreCase(category);
    }

    public boolean deleteProduct(List<Product> products) {
        if(!products.isEmpty()){
            for(Product it : products){
                List<Product> product = searchProductByDsrNo(it.getDsrNo());
                productRepository.deleteById(product.getFirst().getId());
            }
            return true;
        }
        return false;
    }

    public Product updateProduct(Product updatedProduct) {

        Product product=productRepository.findById(updatedProduct.getId()).orElse(null);

        if(product!=null)
        {

            product.setScrap(updatedProduct.isScrap());
            product.setScrapOnDate(updatedProduct.getScrapOnDate());
            product.setCategory(updatedProduct.getCategory());
            product.setType(updatedProduct.getType());
            product.setDescription(updatedProduct.getDescription());
            product.setDsrNo(updatedProduct.getDsrNo());
            product.setQuantity(updatedProduct.getQuantity());
            product.setLabDsrPageNo(updatedProduct.getLabDsrPageNo());
            product.setLabDsrSrNo(updatedProduct.getLabDsrSrNo());
            product.setDdsrPageNo(updatedProduct.getDdsrPageNo());
            product.setDdsrSrNo(updatedProduct.getDdsrSrNo());
            product.setCdsrRegNo(updatedProduct.getCdsrRegNo());
            product.setCdsrPageNo(updatedProduct.getCdsrPageNo());
            product.setCdsrSrNo(updatedProduct.getCdsrSrNo());
            product.setCentralDeadstockDescription(updatedProduct.getCentralDeadstockDescription());
            product.setSupplierName(updatedProduct.getSupplierName());
            product.setPONo(updatedProduct.getPONo());
            product.setPODate(updatedProduct.getPODate());
            product.setInvoiceNo(updatedProduct.getInvoiceNo());
            product.setInvoiceDate(updatedProduct.getInvoiceDate());
            product.setAmount(updatedProduct.getAmount());
            product.setRemarks(updatedProduct.getRemarks());
            product.setPurchaseForLab(updatedProduct.getPurchaseForLab());
            product.setPermanentlyTransferToLab(updatedProduct.getPermanentlyTransferToLab());
            product.setRoomNo(updatedProduct.getRoomNo());
            return productRepository.save(product);
        }
        return null;
    }


    public List<Product> getAllByRoleAndDepartment(Role role, Department department, String labNo) {

        List<Product> filteredRequests = Collections.emptyList(); // Default to empty list

        try {
            if (role == Role.HOD) {
                filteredRequests = productRepository.findForHodByDepartment(department);
            } else if (role == Role.LAB_INCHARGE) {
                filteredRequests = productRepository.findForLabInchargeByDepartmentAndRoom(department,labNo);
            } else if (role == Role.DEPARTMENT_DSR_INCHARGE) {
                filteredRequests = productRepository.findForDeptDsrInchargeByDepartment(department);
            } else if (role == Role.CENTRAL_DSR_INCHARGE) {
                filteredRequests = productRepository.findForCentralDsrIncharge();
            } else if (role == Role.PRINCIPAL) {
                filteredRequests = productRepository.findForPrincipal();
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
