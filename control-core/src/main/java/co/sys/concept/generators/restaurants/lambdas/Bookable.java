package co.sys.concept.generators.restaurants.lambdas;

import co.sys.concept.generators.restaurants.Booking;
import co.sys.concept.generators.restaurants.dto.BookingDTO;

@FunctionalInterface
public interface Bookable {
	Booking book(BookingDTO bookingDTO);
}
