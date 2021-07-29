package com.moneylion.featureswitch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moneylion.featureswitch.entity.UsersEmployee;

public interface UsersEmployeeRepo extends JpaRepository<UsersEmployee, Integer> {
	
	@Query(value = "select * from users_employee where email=?1 and feature_name=?2", nativeQuery = true)
	UsersEmployee findByEmail_Featurename(String email, String featureName);

	
}
