package co.sys.generators.xres;

import co.sys.generators.xres.dto.ConfigurationDTO;
import co.sys.generators.xres.lambdas.Configurable;
import co.sys.generators.xres.service.Service;

public class User extends Service<User> implements Configurable {

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}
}
