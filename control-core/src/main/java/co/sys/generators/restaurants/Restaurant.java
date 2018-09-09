package co.sys.generators.restaurants;

import co.sys.generators.restaurants.control.Controller;
import co.sys.generators.restaurants.dto.BookingDTO;
import co.sys.generators.restaurants.dto.ConfigurationDTO;
import co.sys.generators.restaurants.dto.ManagementDTO;
import co.sys.generators.restaurants.lambdas.Bookable;
import co.sys.generators.restaurants.lambdas.Configurable;
import co.sys.generators.restaurants.lambdas.Manageable;

public class Restaurant extends Controller<Restaurant> implements Manageable<Restaurant>, Bookable, Configurable {

	@Override
	public Booking book(BookingDTO bookingDTO) {
		return null;
	}

	@Override
	public Restaurant manage(ManagementDTO<Restaurant> managementDTO) {
		return null;
	}

	@Override
	public System configure(ConfigurationDTO configurationDTO) {
		return null;
	}
}
