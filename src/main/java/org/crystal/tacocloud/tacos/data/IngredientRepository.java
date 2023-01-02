package org.crystal.tacocloud.tacos.data;

import org.crystal.tacocloud.tacos.Ingredient;
import org.crystal.tacocloud.tacos.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {
//    Ingredient findIngredientById(String id);
//
//    List<Ingredient> findAll();

}
