package com.laptrinhweb.repository;

import com.laptrinhweb.entity.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JwtTokenRepository extends JpaRepository<JwtToken, Long> {
    JwtToken findByToken(String jwtToken);

    List<JwtToken> findAllByUserId(@Param("user_id") Long id);
}
