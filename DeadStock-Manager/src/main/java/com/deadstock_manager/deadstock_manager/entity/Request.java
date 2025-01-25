package com.deadstock_manager.deadstock_manager.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Request {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean scrap;
//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date scrapOnDate;
    private String category;
    private String type;
    public String description;
    private String dsrNo;
    private int quantity;
    private int labDsrPageNo;
    private int labDsrSrNo;
    private int ddsrPageNo;
    private String ddsrSrNo;
    private String cdsrRegNo;
    private int cdsrPageNo;
    private int cdsrSrNo;
    private String centralDeadstockDescription;
    private String supplierName;
    private String PONo;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date PODate;
    private String invoiceNo;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date invoiceDate;
    private double amount;
    private String remarks;
    private String purchaseForLab;
    private String permanentlyTransferToLab;
    private String roomNo;

    @Enumerated(EnumType.ORDINAL)
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Enumerated(EnumType.ORDINAL) // This saves the enum as an integer (ordinal)
    @Column(name = "lab_status")
    private Status labStatus;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "hod_status")
    private Status hodStatus;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "central_dsr_ic_status")
    private Status centralDsrIcStatus;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "principal_status")
    private Status principalStatus;

    @Enumerated(EnumType.ORDINAL) // Added this for deptDsrIcStatus
    @Column(name = "dept_dsr_ic_status")
    private Status deptDsrIcStatus;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isScrap() {
        return scrap;
    }

    public void setScrap(boolean scrap) {
        this.scrap = scrap;
    }

    public Date getScrapOnDate() {
        return scrapOnDate;
    }

    public void setScrapOnDate(Date scrapOnDate) {
        this.scrapOnDate = scrapOnDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDsrNo() {
        return dsrNo;
    }

    public void setDsrNo(String dsrNo) {
        this.dsrNo = dsrNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLabDsrPageNo() {
        return labDsrPageNo;
    }

    public void setLabDsrPageNo(int labDsrPageNo) {
        this.labDsrPageNo = labDsrPageNo;
    }

    public int getLabDsrSrNo() {
        return labDsrSrNo;
    }

    public void setLabDsrSrNo(int labDsrSrNo) {
        this.labDsrSrNo = labDsrSrNo;
    }

    public int getDdsrPageNo() {
        return ddsrPageNo;
    }

    public void setDdsrPageNo(int ddsrPageNo) {
        this.ddsrPageNo = ddsrPageNo;
    }

    public String getDdsrSrNo() {
        return ddsrSrNo;
    }

    public void setDdsrSrNo(String ddsrSrNo) {
        this.ddsrSrNo = ddsrSrNo;
    }

    public String getCdsrRegNo() {
        return cdsrRegNo;
    }

    public void setCdsrRegNo(String cdsrRegNo) {
        this.cdsrRegNo = cdsrRegNo;
    }

    public int getCdsrPageNo() {
        return cdsrPageNo;
    }

    public void setCdsrPageNo(int cdsrPageNo) {
        this.cdsrPageNo = cdsrPageNo;
    }

    public int getCdsrSrNo() {
        return cdsrSrNo;
    }

    public void setCdsrSrNo(int cdsrSrNo) {
        this.cdsrSrNo = cdsrSrNo;
    }

    public String getCentralDeadstockDescription() {
        return centralDeadstockDescription;
    }

    public void setCentralDeadstockDescription(String centralDeadstockDescription) {
        this.centralDeadstockDescription = centralDeadstockDescription;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPONo() {
        return PONo;
    }

    public void setPONo(String PONo) {
        this.PONo = PONo;
    }

    public Date getPODate() {
        return PODate;
    }

    public void setPODate(Date PODate) {
        this.PODate = PODate;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPurchaseForLab() {
        return purchaseForLab;
    }

    public void setPurchaseForLab(String purchaseForLab) {
        this.purchaseForLab = purchaseForLab;
    }

    public String getPermanentlyTransferToLab() {
        return permanentlyTransferToLab;
    }

    public void setPermanentlyTransferToLab(String permanentlyTransferToLab) {
        this.permanentlyTransferToLab = permanentlyTransferToLab;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Status getDeptDsrIcStatus() {
        return deptDsrIcStatus;
    }

    public void setDeptDsrIcStatus(Status deptDsrIcStatus) {
        this.deptDsrIcStatus = deptDsrIcStatus;
    }

    public Status getLabStatus() {
        return labStatus;
    }

    public void setLabStatus(Status labStatus) {
        this.labStatus = labStatus;
    }

    public Status getHodStatus() {
        return hodStatus;
    }

    public void setHodStatus(Status hodStatus) {
        this.hodStatus = hodStatus;
    }

    public Status getPrincipalStatus() {
        return principalStatus;
    }

    public void setPrincipalStatus(Status principalStatus) {
        this.principalStatus = principalStatus;
    }

    public Status getCentralDsrIcStatus() {
        return centralDsrIcStatus;
    }

    public void setCentralDsrIcStatus(Status centralDsrIcStatus) {
        this.centralDsrIcStatus = centralDsrIcStatus;
    }


}
