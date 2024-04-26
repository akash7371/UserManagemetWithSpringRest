package com.akash.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String username;
	private String emailid;
	private String name;
	private String password;
	private long contact;
}
