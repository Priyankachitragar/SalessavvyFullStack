package com.example.demo2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo2.entities.JWTToken;

import jakarta.transaction.Transactional;

@Repository
public interface JWTTokenRepository extends JpaRepository<JWTToken, Integer>{
	
	   Optional<JWTToken> findByToken(String token);
	   
	@Query("select t from JWTToken t where t.user.userId=:userId")
	JWTToken findyUserId(int userId);
	
	@Modifying
	@Transactional
	@Query("delete from JWTToken t where t.user.userId=:userId")
	void deleteByUserId(int userId);
}
