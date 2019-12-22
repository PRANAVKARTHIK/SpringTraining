package com.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.tacocloud.Taco;

@Repository
public interface TacoRepository extends JpaRepository<Taco, String> {

}
