package co.sys.generators.restaurants.lambdas;

import co.sys.generators.restaurants.dto.ManagementDTO;

@FunctionalInterface
public interface Manageable<T> {
	T manage(ManagementDTO<T> managementDTO);
}
