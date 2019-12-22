package com.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.tacocloud.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
