package co.sys.generators.xres;

import co.sys.generators.xres.control.Controller;
import co.sys.generators.xres.dto.ConfigurationDTO;
import co.sys.generators.xres.lambdas.Configurable;

public class User extends Controller<User> implements Configurable {

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}
}
