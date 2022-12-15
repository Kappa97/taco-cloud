package org.crystal.tacocloud.tacos.data;

import org.crystal.tacocloud.tacos.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
