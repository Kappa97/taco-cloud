package org.crystal.tacocloud.tacos.data;

import org.crystal.tacocloud.tacos.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    //Order save(Order order);
    List<Order> findByZip(String deliveryZip);
    List<Order> readOrdersByZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);
}
