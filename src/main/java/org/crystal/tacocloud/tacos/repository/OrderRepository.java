package org.crystal.tacocloud.tacos.repository;

import org.crystal.tacocloud.tacos.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    //Order save(Order order);
    List<Order> findByZip(String deliveryZip);
    List<Order> readOrdersByZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);
}