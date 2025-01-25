package com.deadstock_manager.deadstock_manager.repository;

import com.deadstock_manager.deadstock_manager.entity.HistoryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryCardRepository extends JpaRepository<HistoryCard, Integer> {
    HistoryCard findByDsrNo(String id);
}
