package com.learning.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.tacocloud.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
