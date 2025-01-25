package com.deadstock_manager.deadstock_manager.controller;

import com.deadstock_manager.deadstock_manager.entity.HistoryCard;
import com.deadstock_manager.deadstock_manager.entity.Product;
import com.deadstock_manager.deadstock_manager.service.HistoryCardService;
import com.deadstock_manager.deadstock_manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history-card")
public class HistoryCardController {
    @Autowired
    HistoryCardService historyCardService;

    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody HistoryCard historyCard){
        HistoryCard res = historyCardService.addRecord(historyCard);
        if(historyCard!=null){
            return new ResponseEntity<>("Product Added",HttpStatus.OK);
        }
        return new ResponseEntity<>("Product Not Added",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-product")
    public ResponseEntity<HistoryCard> getProduct(@PathVariable String id){
        HistoryCard historyCard = historyCardService.getRecord(id);
        if (historyCard!=null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(historyCard, HttpStatus.OK);
        }
    }
}
