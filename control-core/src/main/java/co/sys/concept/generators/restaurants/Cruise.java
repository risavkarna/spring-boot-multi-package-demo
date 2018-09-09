package co.sys.concept.generators.restaurants;

import co.sys.concept.generators.restaurants.control.Controller;
import co.sys.concept.generators.restaurants.dto.BookingDTO;
import co.sys.concept.generators.restaurants.dto.ConfigurationDTO;
import co.sys.concept.generators.restaurants.dto.ManagementDTO;
import co.sys.concept.generators.restaurants.lambdas.Bookable;
import co.sys.concept.generators.restaurants.lambdas.Configurable;
import co.sys.concept.generators.restaurants.lambdas.Manageable;

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
