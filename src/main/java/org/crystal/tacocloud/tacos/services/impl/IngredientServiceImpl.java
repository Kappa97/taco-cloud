//package org.crystal.tacocloud.tacos.services.impl;
//
//import org.crystal.tacocloud.tacos.Ingredient;
//import org.crystal.tacocloud.tacos.data.IngredientRepository;
//import org.springframework.stereotype.Service;
//import org.crystal.tacocloud.tacos.services.IngredientService;
//
//import java.util.List;
//
//@Service
//public class IngerdientServiceImpl implements IngredientService {
//
//    private IngredientRepository ingredientRepository;
//
//    public IngerdientServiceImpl(IngredientRepository ingredientRepository){
//        this.ingredientRepository=ingredientRepository;
//    }
//
//    @Override
//    public List<Ingredient> findAll() {
//        List<Ingredient> ingredients = ingredientRepository.findAll();
//        return ingredients;
//    }
//}
