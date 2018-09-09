package co.sys.concept.generators.restaurants.lambdas;

import co.sys.concept.generators.restaurants.dto.ManagementDTO;

@FunctionalInterface
public interface Manageable<T> {
	T manage(ManagementDTO<T> managementDTO);
}
