package com.deadstock_manager.deadstock_manager.repository;


import com.deadstock_manager.deadstock_manager.security.entity.BlacklistedToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistedTokenRepository extends JpaRepository<BlacklistedToken, String> {
    boolean existsByToken(String token);
}

