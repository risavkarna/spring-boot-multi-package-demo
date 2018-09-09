package co.sys.generators.restaurants;

import co.sys.generators.restaurants.control.Controller;
import co.sys.generators.restaurants.dto.ConfigurationDTO;
import co.sys.generators.restaurants.lambdas.Configurable;

public class User extends Controller<User> implements Configurable {

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}
}
