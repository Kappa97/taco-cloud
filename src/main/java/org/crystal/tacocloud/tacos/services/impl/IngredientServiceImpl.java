//package org.crystal.tacocloud.tacos.services.impl;
//
//import org.crystal.tacocloud.tacos.Ingredient;
//import org.crystal.tacocloud.tacos.data.IngredientRepository;
//import org.crystal.tacocloud.tacos.dto.IngredientDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.crystal.tacocloud.tacos.services.IngredientService;
//
//import java.util.List;
//
//@Service
//public class IngredientServiceImpl implements IngredientService {
//
//    private IngredientRepository ingredientRepository;
//
//    @Autowired
//    public IngredientServiceImpl(IngredientRepository ingredientRepository){
//        this.ingredientRepository=ingredientRepository;
//    }
//
//    @Override
//    public List<IngredientDto> findAll() {
//        List<IngredientDto> ingredients = ingredientRepository.findAll();
//        return ingredients;
//    }
//}
