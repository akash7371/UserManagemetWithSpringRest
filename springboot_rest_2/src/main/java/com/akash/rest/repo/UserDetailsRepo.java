package com.akash.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.akash.rest.entity.UserDetails;

import jakarta.transaction.Transactional;

public interface UserDetailsRepo extends JpaRepository<UserDetails, String>{

	@Transactional
	@Modifying
	@Query(value = "update user_dtls2 set password= :newPass where user_name= :uname AND password= :oldPass", nativeQuery = true)
	int updatePasswordWithUserNameAndPassword(@Param(value = "newPass") String newPass, @Param(value = "oldPass") String oldPass, @Param(value = "uname") String uname);;
}
