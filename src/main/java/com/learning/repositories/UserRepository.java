package com.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value="select * from taco_user t where t.username=?1 ",nativeQuery=true)
	User findUsername(String username);
}
