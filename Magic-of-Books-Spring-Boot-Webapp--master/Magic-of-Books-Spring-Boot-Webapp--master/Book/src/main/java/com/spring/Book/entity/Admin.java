package com.spring.Book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="AdminTable")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name="adminId")
	private int adminId;
	private String password;
	private String adminName;
	private String adminEmail;

}