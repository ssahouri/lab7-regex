import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lab7RegEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		validateName(null, sc);
		
		validateEmail(null, sc);
		
		validatePhoneNumber(null, sc);
		
		getDate(sc, "Enter a valid date in the format mm/dd/yyy: ");
		

		sc.close();
	}
	
	public static String validateName(String name, Scanner sc) {
		System.out.println("Enter a valid name: ");
		String input = sc.nextLine();
		if (input.matches("[A-Z][a-z]{1,30}")) {
			System.out.println("Name is valid!");
		} else {
			System.out.println("Sorry, name is not valid!");
		}

		return name;
		
		
	}
	
	public static String validateEmail(String email, Scanner sc) {
		System.out.println("Enter a valid email: ");
		String input = sc.nextLine();
		if (input.matches("\\S+@\\S+\\.\\S+")) {
			System.out.println("Email is valid!");
		} else {
			System.out.println("Sorry, email is not valid!");
		}

		return email;
		
	}
	
	public static String validatePhoneNumber(String phoneNumber, Scanner sc) {
		System.out.println("Enter a valid phone number in format (000)-000-0000: ");
		String input = sc.nextLine();
		if (input.matches("[\\(][0-9]{3}[\\)][-][0-9]{3}[-][0-9]{4}")) {
			System.out.println("Phone number is valid!");
		} else {
			System.out.println("Sorry, phone number is not valid!");
		}

		return phoneNumber;
		
	}
	
	public static String getString(Scanner scnr, String prompt) {
		// This approach uses exception handling.
		System.out.print(prompt);
		return scnr.nextLine();
	}
	
	
	
	public static Date getDate(Scanner scnr, String prompt) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		format.setLenient(false); // <-- date format must match
		boolean isValid = false;
		Date date = null;
		String input;
		do {
			// Step 1: get the raw string
			input = getString(scnr, prompt);
			// Step 2: convert it to a date
			try {
				// format.parse throws a ParseException, which is a checked exception and MUST be caught.
				date = format.parse(input);
				// If exception doesn't occur, it's valid.
				System.out.println("Date is valid!");
				isValid = true;
			} catch (ParseException ex) {
				// If exception occurs, it's invalid.
				isValid = false;
				System.out.println("Sorry, date is not valid!");
			}
			
		} while (!isValid);
		return date;

		
	}



}
