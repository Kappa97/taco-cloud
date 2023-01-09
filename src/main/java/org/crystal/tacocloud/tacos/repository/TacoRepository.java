package org.crystal.tacocloud.tacos.repository;

import org.crystal.tacocloud.tacos.models.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}