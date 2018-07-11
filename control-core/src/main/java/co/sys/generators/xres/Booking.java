package co.sys.generators.xres;

import co.sys.generators.xres.dto.ConfigurationDTO;
import co.sys.generators.xres.dto.ManagementDTO;
import co.sys.generators.xres.lambdas.Configurable;
import co.sys.generators.xres.lambdas.Manageable;

public class Booking implements Manageable<Booking>, Configurable {

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}

	@Override
	public Booking manage(ManagementDTO<Booking> managementDTO) {
		return null;
	}
}
