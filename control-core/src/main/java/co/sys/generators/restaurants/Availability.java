package co.sys.generators.restaurants;

import co.sys.generators.restaurants.control.Controller;
import co.sys.generators.restaurants.dto.ConfigurationDTO;
import co.sys.generators.restaurants.dto.ManagementDTO;
import co.sys.generators.restaurants.lambdas.Configurable;
import co.sys.generators.restaurants.lambdas.Manageable;

public class Availability extends Controller<Availability> implements Manageable<Availability>, Configurable {

	@Override
	public Availability manage(ManagementDTO<Availability> managementDTO) {
		return null;
	}

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}
}
