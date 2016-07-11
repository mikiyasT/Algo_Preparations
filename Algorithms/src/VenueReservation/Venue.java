package VenueReservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public class Venue implements TicketService{
	
	private HashMap<Integer, SeatLocation> seatsMap = new HashMap<Integer,SeatLocation>();
	
	public Venue(){
		SeatLocation orchestra = new SeatLocation(1,"Orchestra",100,25,50);
		seatsMap.put(1, orchestra);
		SeatLocation main = new SeatLocation(2,"Main",75,20,100);
		seatsMap.put(2, main);
		SeatLocation balcony1 = new SeatLocation(3,"Balcony 1",50,15,100);
		seatsMap.put(3, balcony1);
		SeatLocation balcony2 = new SeatLocation(4,"Balcony 2",40,15,100);
		seatsMap.put(4, balcony2);
	}
	
	public int numSeatsAvailable(int venueLevel){
		SeatLocation st = seatsMap.get(venueLevel);
		int numberOfseats = st.numberOfSeats();
		return numberOfseats;
	}
	
	public SeatHold findAndHoldSeats(int numSeats, int minLevel, int maxLevel, String customerEmail){
		
		List<Seat> seatsToBeHold = new ArrayList<Seat>();
		int requiredNoOfSeats = numSeats;
		
		for(int levelId = minLevel; levelId <= maxLevel; levelId++){
			
			int seatAvailable = seatsMap.get(levelId).numberOfSeats();
			if(requiredNoOfSeats > seatAvailable){
				
				//get all the availabe seats in this level and add it to the seatsToBeHold
				//and go to the next higher seat Level, reduct the required no of seats since some is already added from this level
				
				addAvailableSeats(levelId,seatAvailable,seatsToBeHold);
				requiredNoOfSeats-=seatAvailable;
			}
			else{
				//get all the availabe seats in this level and add it to the seatsToBeHold.
				//then break out of the loop. Since all required seats are now aquired.
				addAvailableSeats(levelId,requiredNoOfSeats,seatsToBeHold);
				break;
				
			}
		}
		
		for(Seat s:seatsToBeHold)
		{
			//s.setAvailable(false);
			s.setHeld(true);
			s.setReservedFor(customerEmail);
		}
		SeatHold seatHold = new SeatHold(seatsToBeHold);
		
		return seatHold;
	}

	private void addAvailableSeats(int levelId,int seatAvailable, List<Seat> seatsToBeHold) {
		SeatLocation seat = seatsMap.get(levelId);
		seatsToBeHold.addAll(seat.getAvailableSeat(seatAvailable));
		
		
	}
	public int NumberOfReservedSeats(int levelId){
		return seatsMap.get(levelId).numberOfreservedSeats();
	}
	
	public String reserveSeats(int seatHoldId, String customerEmail){
		
		List<Seat> holdSeats = SeatHold.getHoldSeats(seatHoldId);
		//List<Seat> holdSeats = shold.getHeldSeatsMap().get(seatHoldId);
		if(holdSeats != null)
		{
			for(Seat s:holdSeats)
				s.setReserved(true);
		}
		
		String id  = Integer.toString(seatHoldId) + customerEmail;
		
		return id;
	}
}
