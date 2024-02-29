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
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Check in date: (dd/MM/yyyy)");
			dateStringIN = sc.next();
			checkIn = LocalDate.parse(dateStringIN, formatter);
			
			System.out.print("Check out date: (dd/MM/yyyy)");
			dateStringOut = sc.next();
			checkOut = LocalDate.parse(dateStringOut, formatter);
			
			
			String error = reservation.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}else {
				System.out.println("Reservation:" + reservation);			
			}
		}
		sc.close();
	}
}
