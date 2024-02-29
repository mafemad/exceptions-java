package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entites.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		System.out.print("Check in date: (dd/MM/yyyy)");
		String dateStringIN = sc.next();
		LocalDate checkIn = LocalDate.parse(dateStringIN, formatter);
		
		System.out.print("Check out date: (dd/MM/yyyy)");
		String dateStringOut = sc.next();
		LocalDate checkOut = LocalDate.parse(dateStringOut, formatter);
		
		if(!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation, check out must be after check in");
			
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation:" + reservation);
			
			System.out.println("Enter data to update the reservation");
			System.out.print("Check in date: (dd/MM/yyyy)");
			dateStringIN = sc.next();
			checkIn = LocalDate.parse(dateStringIN, formatter);
			
			System.out.print("Check out date: (dd/MM/yyyy)");
			dateStringOut = sc.next();
			checkOut = LocalDate.parse(dateStringOut, formatter);
			
			LocalDate dateNow = LocalDate.now();
			
			if(checkIn.isBefore(dateNow) || checkOut.isBefore(dateNow)) {
				System.out.println("Dates must be future dates to update");
			}
			else if(!checkOut.isAfter(checkIn)) {
				System.out.println("Error in reservation, check out must be after check in");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation:" + reservation);
			}
			
		}
		sc.close();
	}
}
