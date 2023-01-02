package org.crystal.tacocloud.tacos.services;

import org.crystal.tacocloud.tacos.Ingredient;

import java.util.List;

public interface IngerdientService {
    List<Ingredient> findAll();
}
