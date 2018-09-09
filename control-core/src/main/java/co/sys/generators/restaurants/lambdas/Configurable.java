package co.sys.generators.restaurants.lambdas;

import co.sys.generators.restaurants.System;
import co.sys.generators.restaurants.dto.ConfigurationDTO;

@FunctionalInterface
public interface Configurable {
	System configure(ConfigurationDTO configurationDTO);
}
