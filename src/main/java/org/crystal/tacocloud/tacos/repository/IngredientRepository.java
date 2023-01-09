package org.crystal.tacocloud.tacos.repository;

import org.crystal.tacocloud.tacos.models.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;


//@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {
//    Ingredient findIngredientById(String id);
//
//    List<Ingredient> findAll();

}
