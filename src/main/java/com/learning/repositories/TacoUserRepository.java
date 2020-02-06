package com.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.entities.TacoUser;

@Repository
public interface TacoUserRepository extends JpaRepository<TacoUser, Integer> {

	@Query(value="SELECT * FROM taco_user tu WHERE tu.username=(?1) AND tu.pwd=(?2) AND tu.user_role='customer'",nativeQuery=true)
	public Object[] getUserDetails(String username,String password); 
}
