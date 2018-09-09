package co.sys.generators.restaurants.lambdas;

import co.sys.generators.restaurants.Booking;
import co.sys.generators.restaurants.dto.BookingDTO;

@FunctionalInterface
public interface Bookable {
	Booking book(BookingDTO bookingDTO);
}
