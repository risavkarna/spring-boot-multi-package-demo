package co.sys.generators.xres;

import co.sys.generators.xres.dto.ConfigurationDTO;
import co.sys.generators.xres.lambdas.Configurable;
import co.sys.generators.xres.service.Service;

public class System extends Service<System> implements Configurable {

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}
}
