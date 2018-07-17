package co.sys.generators.xres;

import co.sys.generators.xres.control.Controller;
import co.sys.generators.xres.dto.BookingDTO;
import co.sys.generators.xres.dto.ConfigurationDTO;
import co.sys.generators.xres.dto.ManagementDTO;
import co.sys.generators.xres.lambdas.Bookable;
import co.sys.generators.xres.lambdas.Configurable;
import co.sys.generators.xres.lambdas.Manageable;

public class Cruise extends Controller<Cruise> implements Bookable, Manageable<Cruise>, Configurable {

	@Override
	public Booking book(BookingDTO bookingDTO) {
		return null;
	}

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}

	@Override
	public Cruise manage(ManagementDTO<Cruise> managementDTO) {
		return null;
	}
}
