package countryList;

//created by Brian Seyferth on 8/1/2018

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CountryListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create the UtilityFile that holds the file methods
		CountriesFileUtil2 countryFile = new CountriesFileUtil2("");
		
		//use the created Utility file to read the file and create a list of objects called Country.
		List<Country> countryList = countryFile.readFile();
		
		
		//open the scanner and declares the needed variables
		Scanner scnr = new Scanner(System.in);
		int userOpt = 0;
		boolean restart = true;
		String newCountry = null;
		
		//checks for and creates a new file if necessary
		CountriesFileUtil2.createBlankFile("Countries.txt");
		
		
		
		
		//prints welcome statement
		System.out.println("Welcome to the Countries Maintenance Application");
		
		//this loop sets up the restart option through out the app
		while (restart == true) {
		
			//prints the initial options out to the user and collects a valid response
			System.out.println("Enter an option: (1,2,3)");
			System.out.println("1. Display a list of Countries");
			System.out.println("2. Add a country to the list");
			System.out.println("3. Quit");
			userOpt = getInt(scnr, "", 1, 3);
			
			//this if statement places out the only possible responses 1-3
			//starting with 1, than 2, than all else falls into 3
				if (userOpt == 1) {
					
					//count through the list now that its been read and print the names
					//continue through by making sure restart is true
					for (Country i : countryList) {
						System.out.println(i.getName());
					}
					restart = true;
					
				} else if (userOpt ==2) {
					
					//asks the user the country they want to add, stores response as a String,
					//the string is used to create a new country, the new country is appended to the file,
					//then added to the read list so it can show up in later list calls. restart is true
					System.out.println("What country would you like to add:");
					newCountry = scnr.nextLine();
					Country newCount = new Country(newCountry);
					countryFile.appendLine(newCount);
					countryList.add(newCount);
					System.out.println(newCountry + " has been saved!");
					restart = true;
					
				} else {
					
					//quit option makes restart false
					restart = false;
				}
		}
		
		//prints the good bye message
		System.out.println("Goodbye!");

	}
	
	
	//validation methods used for inputing the integer
	public static int getInt(Scanner scnr, String prompt) {
		// This approach uses exception handling.
		System.out.print(prompt);
		try {
			int num = scnr.nextInt();
			scnr.nextLine();
			return num;
		} catch (InputMismatchException e) {
			System.out.println("Enter a whole number, using digits.");
			scnr.nextLine();
			return getInt(scnr, prompt);
		}
	}
	
	//validation methods used for inputing the integer within a range
	public static int getInt(Scanner scnr, String prompt, int min, int max) {
		boolean isValid = false;
		int number;
		do {
			number = getInt(scnr, prompt);
			
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
}
