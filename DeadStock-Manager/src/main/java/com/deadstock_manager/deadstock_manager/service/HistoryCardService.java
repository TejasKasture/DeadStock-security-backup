package com.deadstock_manager.deadstock_manager.service;

import com.deadstock_manager.deadstock_manager.entity.HistoryCard;
import com.deadstock_manager.deadstock_manager.entity.Product;
import com.deadstock_manager.deadstock_manager.repository.HistoryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryCardService {
    @Autowired
    HistoryCardRepository historyCardRepository;

    public HistoryCard addRecord(HistoryCard historyCard) {
        return historyCardRepository.save(historyCard);
    }

    public HistoryCard getRecord(String id) {
        return historyCardRepository.findByDsrNo(id);
    }
}
