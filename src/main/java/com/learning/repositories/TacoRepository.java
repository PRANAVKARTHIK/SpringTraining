package com.learning.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entities.Taco;

@Repository
public interface TacoRepository extends JpaRepository<Taco, String> {

	Optional<Taco> findByName(String name);
}
