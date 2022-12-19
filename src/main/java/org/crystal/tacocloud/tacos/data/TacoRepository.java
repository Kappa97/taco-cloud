package org.crystal.tacocloud.tacos.data;

import org.crystal.tacocloud.tacos.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}