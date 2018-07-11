package co.sys.generators.xres.lambdas;

import co.sys.generators.xres.Booking;
import co.sys.generators.xres.dto.BookingDTO;

@FunctionalInterface
public interface Bookable {
	Booking book(BookingDTO bookingDTO);
}
