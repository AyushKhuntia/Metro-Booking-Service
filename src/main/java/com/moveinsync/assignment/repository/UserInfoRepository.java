package com.moveinsync.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moveinsync.assignment.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
	
		@Query("SELECT u FROM UserInfo u WHERE u.username = ?1")
		public UserInfo getByUsername(String username);
	
}
