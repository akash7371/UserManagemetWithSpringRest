package com.akash.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.rest.dto.PasswordDto;
import com.akash.rest.dto.UserDto;
import com.akash.rest.service.IUserManagementService;

@RestController
@RequestMapping("/user")
public class UserManagementController {

	@Autowired
	IUserManagementService userManagementService;
	
	@PostMapping(path = "/adduser" )
	public String createUser(@RequestBody UserDto userData) {
		System.out.println(userData);
		return userManagementService.createUser(userData);
	}
	
	@PutMapping(path = "/update/{uName}")
	public String changePassword(@PathVariable String uName, @RequestBody PasswordDto passwordDto) {
		
		return userManagementService.changePassword(uName, passwordDto);
		
	}
	
	@GetMapping(path = "/getuser/{uName}")
	public ResponseEntity<UserDto> getUserDetails(@PathVariable String uName){
		
		return new ResponseEntity<UserDto>(userManagementService.getUserDetails(uName), HttpStatus.PARTIAL_CONTENT);
		
	}
}
