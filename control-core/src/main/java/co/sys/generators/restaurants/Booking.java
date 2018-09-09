package co.sys.generators.restaurants;

import co.sys.generators.restaurants.control.Controller;
import co.sys.generators.restaurants.dto.ConfigurationDTO;
import co.sys.generators.restaurants.dto.ManagementDTO;
import co.sys.generators.restaurants.lambdas.Configurable;
import co.sys.generators.restaurants.lambdas.Manageable;

public class Booking extends Controller<Booking> implements Manageable<Booking>, Configurable {

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}

	@Override
	public Booking manage(ManagementDTO<Booking> managementDTO) {
		return null;
	}
}
