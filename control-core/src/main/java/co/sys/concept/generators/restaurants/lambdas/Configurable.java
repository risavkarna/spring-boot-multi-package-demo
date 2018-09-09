package co.sys.concept.generators.restaurants.lambdas;

import co.sys.concept.generators.restaurants.System;
import co.sys.concept.generators.restaurants.dto.ConfigurationDTO;

@FunctionalInterface
public interface Configurable {
	System configure(ConfigurationDTO configurationDTO);
}
