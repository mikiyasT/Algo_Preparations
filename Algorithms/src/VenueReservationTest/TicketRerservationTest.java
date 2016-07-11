package VenueReservationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import VenueReservation.SeatHold;
import VenueReservation.Venue;

public class TicketRerservationTest {

	@Test
	public void numSeatsAvailableTest(){
		Venue vn = new Venue();
		int numSeatsAva_1 = vn.numSeatsAvailable(1);
		int numSeatsAva_2 = vn.numSeatsAvailable(2);
		int numSeatsAva_3 = vn.numSeatsAvailable(3);
		int numSeatsAva_4 = vn.numSeatsAvailable(4);
		
		System.out.println("Number of seats avaiable for test  " + numSeatsAva_1);
		assertEquals(1250,numSeatsAva_1);
		assertEquals(2000,numSeatsAva_2);
		assertEquals(1500,numSeatsAva_3);
		assertEquals(1500,numSeatsAva_4);
	}
	
	@Test
	public void findAndHoldSeatsTest(){
		Venue vn = new Venue();
		vn.findAndHoldSeats(50, 1, 2, "write2miki");		
		vn.findAndHoldSeats(2000, 1, 2, "write2miki");
		
		int numSeatsAva_1 = vn.numSeatsAvailable(1);
		int numSeatsAva_2 = vn.numSeatsAvailable(2);
		assertEquals(0,numSeatsAva_1);
		assertEquals(1200,numSeatsAva_2);
	}
	
	@Test
	public void reserveSeatsTest(){
		Venue vn = new Venue();
		SeatHold sho = vn.findAndHoldSeats(50, 1, 2, "write2miki");
		vn.reserveSeats(sho.getSeatHoldId(),"testEmail");
		int reservedSeats_1 = vn.NumberOfReservedSeats(1);
		int reservedSeats_2 = vn.NumberOfReservedSeats(2);
		assertEquals(50,reservedSeats_1);
		assertEquals(0,reservedSeats_2);
		
		SeatHold sho1 = vn.findAndHoldSeats(1300, 1, 2, "write2miki");
		vn.reserveSeats(sho1.getSeatHoldId(),"testEmail");
		reservedSeats_1 = vn.NumberOfReservedSeats(1);
		reservedSeats_2 = vn.NumberOfReservedSeats(2);
		assertEquals(1250,reservedSeats_1);
		assertEquals(100,reservedSeats_2);
		
	}
	
	
	
	

}
