package org.crystal.tacocloud.tacos.data;

import org.crystal.tacocloud.tacos.Order;

public interface OrderRepository {
    Order save(Order order);
}
