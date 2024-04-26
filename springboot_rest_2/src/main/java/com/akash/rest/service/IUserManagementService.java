package com.akash.rest.service;

import org.springframework.http.ResponseEntity;

import com.akash.rest.dto.PasswordDto;
import com.akash.rest.dto.UserDto;

public interface IUserManagementService {

	public String createUser(UserDto userData);

	public String changePassword(String uName, PasswordDto passwordDto);

	public UserDto getUserDetails(String uName);

}
