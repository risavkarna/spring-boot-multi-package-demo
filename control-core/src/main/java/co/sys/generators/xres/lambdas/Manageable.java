package co.sys.generators.xres.lambdas;

import co.sys.generators.xres.dto.ManagementDTO;

@FunctionalInterface
public interface Manageable<T> {
	T manage(ManagementDTO<T> managementDTO);
}
