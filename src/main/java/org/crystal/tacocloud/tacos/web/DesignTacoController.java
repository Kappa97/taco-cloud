package org.crystal.tacocloud.tacos.web;

import java.util.*;
import java.util.stream.Collectors;


import jakarta.validation.Valid;
import org.crystal.tacocloud.tacos.Ingredient;
import org.crystal.tacocloud.tacos.Order;
import org.crystal.tacocloud.tacos.Taco;
import org.crystal.tacocloud.tacos.data.IngredientRepository;
import org.crystal.tacocloud.tacos.data.TacoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    //@Autowired
    private IngredientRepository ingredientRepo;
    //@Autowired
    private TacoRepository designRepo;


    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors,
                                @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }
        Taco saved = designRepo.save(design);
        order.addDesign(saved);
        return "redirect:/orders/current";
    }


    @GetMapping
    public String showDesignFormMyMethod(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.addAll(ingredientRepo.findAll());
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}