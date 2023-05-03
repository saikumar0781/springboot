package com.spring.Book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Book.entity.Admin;
import com.spring.Book.entity.User;
import com.spring.Book.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepo;

	public boolean validateAdmin(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		try {
			Admin newAdmin = adminRepo.findByAdminEmailIgnoreCase(email);
			
			if(newAdmin.getPassword().equals(password)) return true;
		}
		catch (Exception e) {
			throw new Exception("Invalid Credentials...");	
		}
		
		
		return false;
	}

	public void insertAdmin(Admin newAdmin) throws Exception{
		
		try {
			adminRepo.save(newAdmin);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Admin getAdminByEmail(String email) throws Exception{
		// TODO Auto-generated method stub
		try {
			Admin newAdmin = adminRepo.findByAdminEmailIgnoreCase(email);
			return newAdmin;
		}
		catch(Exception e)
		{
			throw new Exception("User does not exist with this email...");
		}
	}

		
	}

