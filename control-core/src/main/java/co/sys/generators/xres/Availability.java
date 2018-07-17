package co.sys.generators.xres;

import co.sys.generators.xres.control.Controller;
import co.sys.generators.xres.dto.ConfigurationDTO;
import co.sys.generators.xres.dto.ManagementDTO;
import co.sys.generators.xres.lambdas.Configurable;
import co.sys.generators.xres.lambdas.Manageable;

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
