package com.spring.Book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Book.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByAdminEmailIgnoreCase(String email);

}
