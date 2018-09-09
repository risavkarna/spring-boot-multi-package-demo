package co.sys.concept.generators.restaurants;

import co.sys.concept.generators.restaurants.control.Controller;
import co.sys.concept.generators.restaurants.dto.ConfigurationDTO;
import co.sys.concept.generators.restaurants.dto.ManagementDTO;
import co.sys.concept.generators.restaurants.lambdas.Configurable;
import co.sys.concept.generators.restaurants.lambdas.Manageable;

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
