package com.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entities.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
