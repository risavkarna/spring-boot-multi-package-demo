package co.sys.concept.generators.restaurants;

import co.sys.concept.generators.restaurants.control.Controller;
import co.sys.concept.generators.restaurants.dto.BookingDTO;
import co.sys.concept.generators.restaurants.dto.ConfigurationDTO;
import co.sys.concept.generators.restaurants.dto.ManagementDTO;
import co.sys.concept.generators.restaurants.lambdas.Bookable;
import co.sys.concept.generators.restaurants.lambdas.Configurable;
import co.sys.concept.generators.restaurants.lambdas.Manageable;

public class Event extends Controller<Event> implements Manageable<Event>, Bookable, Configurable {

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
