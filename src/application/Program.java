package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entites.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			
			System.out.print("Check in date: (dd/MM/yyyy)");
			String dateStringIN = sc.next();
			LocalDate checkIn = LocalDate.parse(dateStringIN, formatter);
			
			System.out.print("Check out date: (dd/MM/yyyy)");
			String dateStringOut = sc.next();
			LocalDate checkOut = LocalDate.parse(dateStringOut, formatter);
			
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
			
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation:" + reservation);			
		}
		catch(DateTimeParseException e) {
			System.out.println("Invalid data format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}
}
