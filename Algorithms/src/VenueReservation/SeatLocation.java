package VenueReservation;

import java.util.ArrayList;
import java.util.List;

public class SeatLocation {
	
	private int levelId;
	private String levelName;
	private double price;
	private int rows;
	private int seatsInRow;
	Seat[] seats;// = new SeatHold[34];
	
	public SeatLocation(){
		
	}

	public SeatLocation(int levelId, String levelName, double price, int rows, int seatsInRow) {
		super();
		this.levelId = levelId;
		this.levelName = levelName;
		this.price = price;
		this.rows = rows;
		this.seatsInRow = seatsInRow;
		seats = new Seat[rows * seatsInRow];
		
		for(int r=0; r<rows;r++){
			for(int c=0; c<seatsInRow;c++){
				//seats[r*seatsInRow + c] = new  Seat(levelId,r,c,true,false,false,null);
				seats[r*seatsInRow + c] = new Seat(levelId,r*seatsInRow + c,true,false,false,null);
				}
			}
	}
	
	public int numberOfSeats(){
		int no_available = 0;
		for(Seat s:seats){
			if(s.isAvailable())
				no_available++;
		}
		return no_available;
			
	}
	
	public void reserveSeat(int i){
		seats[i].setAvailable(false);
	}
	
	public void unReserveSeat(int i){
		seats[i].setAvailable(true);
	}
	
	public List<Seat> getAvailableSeat(int reqNum){
		List<Seat> seatsForReservation = new ArrayList<Seat>();
		
		if(reqNum > numberOfSeats())
			return null;
		else
		{
			int currReservedSeats = 0;
			for(int i = 0; i <rows * seatsInRow;i++){
				if(currReservedSeats < reqNum)
				if(seats[i].isAvailable()){
					seatsForReservation.add(seats[i]);
					currReservedSeats++;
				}
					
			}
		}
		return seatsForReservation;
	}
	
	public int numberOfreservedSeats(){
		int cnt = 0;
		for(Seat s:seats)
			if(s.isReserved()){
				++cnt;
			}
		return cnt;
		
	}
    
}
