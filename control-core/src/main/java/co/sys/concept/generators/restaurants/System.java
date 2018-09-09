package co.sys.concept.generators.restaurants;

import co.sys.concept.generators.restaurants.control.Controller;
import co.sys.concept.generators.restaurants.dto.ConfigurationDTO;
import co.sys.concept.generators.restaurants.lambdas.Configurable;

public class System extends Controller<System> implements Configurable {

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}
}
