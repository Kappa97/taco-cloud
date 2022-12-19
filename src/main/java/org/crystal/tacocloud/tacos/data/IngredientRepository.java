package org.crystal.tacocloud.tacos.data;

import org.crystal.tacocloud.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{
}
