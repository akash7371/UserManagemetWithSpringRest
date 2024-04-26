package com.akash.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akash.rest.dto.PasswordDto;
import com.akash.rest.dto.UserDto;
import com.akash.rest.entity.UserDetails;
import com.akash.rest.repo.UserDetailsRepo;

@Service
public class UserManagementService implements IUserManagementService{

	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	@Override
	public String createUser(UserDto userData) {
		
		UserDetails details = new UserDetails();
		details.setUserName(userData.getUsername());
		details.setEmailId(userData.getEmailid());
		details.setName(userData.getName());
		details.setPassword(userData.getPassword());
		details.setContact(userData.getContact());
		
		if(userDetailsRepo.findById(details.getUserName()).isPresent())
			return "User already existed...Try another username!!!";
		else
			userDetailsRepo.save(details);
		return "User Added successfully....";
	}

	@Override
	public String changePassword(String uName, PasswordDto passwordDto) {
		
		int k = userDetailsRepo.updatePasswordWithUserNameAndPassword(passwordDto.getNewPass(), passwordDto.getOldPass(), uName);
		if(k<0)
			return "Invalid Email and Password";
		else
		return "Password Changed Successfully.....";
	}

	@Override
	public UserDto getUserDetails(String uName) {

		Optional<UserDetails> details=  userDetailsRepo.findById(uName);
		UserDto userDto = new UserDto();
		userDto.setUsername(details.get().getUserName());
		userDto.setEmailid(details.get().getEmailId());
		userDto.setName(details.get().getName());
		userDto.setPassword(details.get().getPassword());
		userDto.setContact(details.get().getContact());
		
		
		return userDto;
	}

}
