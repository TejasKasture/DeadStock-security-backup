package com.deadstock_manager.deadstock_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.Date;

//enum for purchase detail
//ask sir for more details

@Entity
@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class HistoryCard {
    @Id
    private String dsrNo;
    private Date date;
    private String problemObserved;
    private String remedyTaken;
    private String remark;
    private String labEquipmentDetails;
    private int srNo;
    private String supplierDetails;
    //purchase details
}
