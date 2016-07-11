package VenueReservation;

public class Seat {
	
	private int id; //identifies which venue
	//private int row;
	//private int col;
	private int number;
	private boolean available; // neither held nor reserved
	private boolean held;
	private boolean reserved;
	//SeatStatus status;
	private String reservedFor; //customerEmail for who the seat is reserved
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	//public Seat(int id, int row, int col, boolean available, boolean held, boolean reserved, String reservedFor) {
	public Seat(int id, int num, boolean available, boolean held, boolean reserved, String reservedFor) {
		super();
		this.id = id;
//		this.row = row;
//		this.col = col;
		this.number  = num;
		this.available = available;
		this.held = held;
		this.reserved = reserved;
		this.reservedFor = reservedFor;
	}

	public String getReservedFor() {
		return reservedFor;
	}
	
	public void setReservedFor(String reservedFor) {
		this.reservedFor = reservedFor;
	}
	
/*	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}*/
	
	public boolean isHeld() {
		return held;
	}

	public void setHeld(boolean held) {
		this.held = held;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

/*	public void setCol(int col) {
		this.col = col;
	}
	*/
	public boolean isAvailable() {
		//a seat is available if it is not reserved and not held
		return (!isReserved() && !isHeld());
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}	

}
