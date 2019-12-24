package com.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

	@Query("select count(o.id) from Order o where o.name=?1")
	int getCountOfCustomer(String name);
}
