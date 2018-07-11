package co.sys.generators.xres;

import co.sys.generators.xres.dto.BookingDTO;
import co.sys.generators.xres.dto.ConfigurationDTO;
import co.sys.generators.xres.dto.ManagementDTO;
import co.sys.generators.xres.lambdas.Bookable;
import co.sys.generators.xres.lambdas.Configurable;
import co.sys.generators.xres.lambdas.Manageable;
import co.sys.generators.xres.service.Service;

public class Event extends Service<Event> implements Manageable<Event>, Bookable, Configurable {

	@Override
	public Booking book(BookingDTO bookingDTO) {
		return null;
	}

	@Override
	public Event manage(ManagementDTO<Event> managementDTO) {
		return null;
	}

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}
}
