package VenueReservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeatHold {
	
	static private int idGenerator = 0;
	private int seatHoldId;	
	public static HashMap<Integer,List<Seat>> heldSeatsMap = new HashMap<Integer,List<Seat>>();
	
	
	public SeatHold(List<Seat> s){
		seatHoldId = idGenerator++;
		heldSeatsMap.put(seatHoldId, s);
	}
	
	public HashMap<Integer,List<Seat>> getHeldSeatsMap(){
		return heldSeatsMap; 
	}
	
	public int getSeatHoldId(){
		return seatHoldId;
	}
	
	static public List<Seat> getHoldSeats(int id){
		return heldSeatsMap.get(id);
	}
	
	
	

}
