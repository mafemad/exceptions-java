package model.entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exception.*;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation(){
		
	}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Error in reservation, check out must be after check in");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		return ChronoUnit.DAYS.between(checkIn, checkOut);
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException{
		LocalDate dateNow = LocalDate.now();
		
		if(checkIn.isBefore(dateNow) || checkOut.isBefore(dateNow)) {
			throw new DomainException("Dates must be future dates to update");
		}
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Error in reservation, check out must be after check in");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		
		return "Room: " 
				+ roomNumber
				+ ",check in: "
				+ formatter.format(checkIn)
				+ ", check out: "
				+ formatter.format(checkOut)
				+ ", "
				+ duration()
				+ " nights ";
		
	}
	
	
}
