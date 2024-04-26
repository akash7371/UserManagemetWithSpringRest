package com.akash.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_dtls2")
public class UserDetails {

	@Id
	private String userName;
	private String emailId;
	private String name;
	private String password;
	private long contact;
	
}
