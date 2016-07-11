package VenueReservation;

public class TicketMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Venue ven=new Venue();
		System.out.println("test");
		System.out.println("Number of seats avaialbel in venu 2 before " + ven.numSeatsAvailable(2));
		System.out.println("Number of seats avaialbel in venu 3 before " + ven.numSeatsAvailable(3));
		
		SeatHold sho = ven.findAndHoldSeats(300, 2, 3, "test@gmail.com");
		System.out.println("Number of seats avaialbe in venue 2- " + ven.numSeatsAvailable(2));
		System.out.println("Number of seats avaialbe in venue 3- " + ven.numSeatsAvailable(3));
		
		System.out.println("------------");
		SeatHold sho1 = ven.findAndHoldSeats(1900, 2, 3, "test@gmail.com");
		System.out.println("Number of seats avaialbe in venue 2- " + ven.numSeatsAvailable(2));
		System.out.println("Number of seats avaialbe in venue 3- " + ven.numSeatsAvailable(3));
		
		System.out.println("------------");
		SeatHold sho2 = ven.findAndHoldSeats(400, 2, 3, "test@gmail.com");
		System.out.println("Number of seats avaialbe in venue 2- " + ven.numSeatsAvailable(2));
		System.out.println("Number of seats avaialbe in venue 3- " + ven.numSeatsAvailable(3));
		
		
		System.out.println("------------");
		SeatHold sho3 = ven.findAndHoldSeats(500, 2, 3, "test@gmail.com");
		System.out.println("Number of seats avaialbe in venue 2- " + ven.numSeatsAvailable(2));
		System.out.println("Number of seats avaialbe in venue 3- " + ven.numSeatsAvailable(3));
		
		ven.reserveSeats(sho.getSeatHoldId(),"testU");
		ven.reserveSeats(sho1.getSeatHoldId(),"testU");
		
		System.out.println("Reserved seats available is in venu 2 - " + ven.NumberOfReservedSeats(2));
		System.out.println("Reserved seats is in venu 3 - " + ven.NumberOfReservedSeats(3));

	}

}
