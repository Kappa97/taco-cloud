package org.crystal.tacocloud.tacos.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.crystal.tacocloud.tacos.models.Order;
import org.crystal.tacocloud.tacos.models.User;
import org.crystal.tacocloud.tacos.repository.OrderRepository;
import org.crystal.tacocloud.tacos.repository.UserRepository;
import org.crystal.tacocloud.tacos.web.OrderProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;
    private UserRepository userRepository;
    private OrderProps props;

    @Autowired
    public OrderController(OrderRepository orderRepo, UserRepository userRepository, OrderProps orderProps) {
        this.orderRepo = orderRepo;
        this.userRepository = userRepository;
        this.props= orderProps;
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Pageable pageable = PageRequest.of(0, props.getPageSize());
        User user = userRepository.findByEmail(userDetails.getUsername());
        model.addAttribute("orders",
                orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, Principal principal) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        String principalValue = principal.getName();
        System.out.println(principalValue);
        User user = userRepository.findByEmail(
                principal.getName());
        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();
        log.info("Order submitted: " + order);
        return "redirect:/orders";
    }
}