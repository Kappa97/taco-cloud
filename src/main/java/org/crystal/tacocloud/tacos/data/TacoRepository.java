package org.crystal.tacocloud.tacos.data;

import org.crystal.tacocloud.tacos.Taco;

public interface TacoRepository {

    Taco save(Taco design);
}