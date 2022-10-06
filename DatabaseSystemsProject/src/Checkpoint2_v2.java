// Project Checkpoint 2
// Author: Austin Greer

import java.util.HashMap;
import java.util.Scanner;

public class Checkpoint2_v2 {
	
	// Displays the main menu
	public static void displayMainMenu() {
		System.out.println("--- Main Menu ---");
		System.out.println("Choose an option below.");
		System.out.println("[1] - Add");
		System.out.println("[2] - Edit");
		System.out.println("[3] - Delete");
		System.out.println("[4] - Search");
		System.out.println("[0] - Quit");
		System.out.print("Enter a number: ");
	}
	
	// Displays the menu for choosing a data type
	public static void displayTypeMenu() {
		System.out.println("[1] - Member");
		System.out.println("[2] - Equipment");
		System.out.println("[3] - Warehouse");
		System.out.println("[0] - Go Back");
		System.out.print("Enter a number: ");
	}
	
	// Gets the user to enter a name
	public static String getName(Scanner input) {
		System.out.print("Enter a name: ");
		String name = input.nextLine();
		return name;
	}
	
	// Get the user to enter an ID number
	public static int getNum(Scanner input) {
		System.out.print("Enter an ID number: ");
		int num = Integer.parseInt(input.nextLine());
		return num;
	}

	public static void main(String[] args) {
		// Declaring user input
		Scanner userInput = new Scanner(System.in);
		
		// Declaring variables for storing data (our database in this checkpoint)
		HashMap <Integer, String>memberData = new HashMap<Integer, String>();
		HashMap <Integer, String>equipmentData = new HashMap<Integer, String>();
		HashMap <Integer, String>warehouseData = new HashMap<Integer, String>();
		
		// Displays the main menu to start off, then asks the user to choose an option
		displayMainMenu();
		String mainChoice = userInput.nextLine();
		
		String typeChoice;
		String dataName;
		int dataID;
		
		// While the user does NOT enter 0 to quit.
		while (mainChoice != "0") {
			// Declaring a variable used for the user's choice of data type
			// (Member = 1 /Equipment = 2/Warehouse = 3/ Go Back = 0)
			// Also declaring variables for the data name and data ID
			
			switch (mainChoice) {
				// When the user enters 0 at the main menu
				case "0":
					mainChoice = "0";
					System.out.println();
					System.out.println("Qutting...");
					System.out.println();
					break;
				
				// When the user enters 1 to add
				case "1":
					System.out.println();
					System.out.println("Choose what to add.");
					displayTypeMenu();
					typeChoice = userInput.nextLine();
					System.out.println();
					switch(typeChoice){
					
						// If the user enters 0 to go back to the main menu
						// Switch cases for what type of data the user wants to add
						case "0":
							displayMainMenu();
							mainChoice = userInput.nextLine();
							break;
						case "1":
							System.out.println("--- Add Member ---");
							dataName = getName(userInput);
							dataID = getNum(userInput);
							memberData.put(dataID, dataName);
							System.out.println(dataName + " was added.");

							break;
						case "2":
							System.out.println("--- Add Equipment ---");
							dataName = getName(userInput);
							dataID = getNum(userInput);
							equipmentData.put(dataID, dataName);
							System.out.println(dataName + " was added.");
							break;
						case "3":
							System.out.println("--- Add Warehouse ---");
							dataName = getName(userInput);
							dataID = getNum(userInput);
							warehouseData.put(dataID, dataName);
							System.out.println(dataName + " was added.");
							break;						
						default: 
							System.out.println("Error: Invalid Input");
							break;						
					}
					
					break;
				
				// When the user enters 2 at the main menu
				// Switch cases for what type of data the user wants to edit
				case "2":
					String newName;
					System.out.println();
					System.out.println("Choose what to edit.");
					displayTypeMenu();
					typeChoice = userInput.nextLine();
					System.out.println();
					switch(typeChoice){
					case "0":
						displayMainMenu();
						mainChoice = userInput.nextLine();
						break;
					case "1":
						System.out.println("--- Edit Member ---");
						System.out.println("Enter a Member ID below to edit their name.");
						dataID = getNum(userInput);
						System.out.println("Enter a new name for Member ID: "+dataID+".");
						newName = getName(userInput);
						memberData.put(dataID, newName);
						System.out.println("Member ID: "+dataID+" was updated.");
						break;
					case "2":
						System.out.println("--- Edit Equipment ---");
						System.out.println("Enter an Equipment ID below to edit their name.");
						dataID = getNum(userInput);
						System.out.println("Enter a new name for Equipment ID: "+dataID+".");
						newName = getName(userInput);
						equipmentData.put(dataID, newName);
						System.out.println("Equipment ID: "+dataID+" was updated.");
						break;
					case "3":
						System.out.println("--- Edit Warehouse ---");
						System.out.println("Enter a Warehouse ID below to edit their name.");
						dataID = getNum(userInput);
						System.out.println("Enter a new name for Warehouse ID: "+dataID+".");
						newName = getName(userInput);
						warehouseData.put(dataID, newName);
						System.out.println("Warehouse ID: "+dataID+" was updated.");
						break;
					default: 
						System.out.println("Error: Invalid Input");
						break;
					}
					break;
				
				// When the user enters 3 at the main menu
				// Switch cases for what type of data the user wants to delete
				case "3":
					System.out.println();
					System.out.println("Choose what to delete.");
					displayTypeMenu();
					typeChoice = userInput.nextLine();
					System.out.println();
					switch(typeChoice){
					case "0":
						displayMainMenu();
						mainChoice = userInput.nextLine();
						break;
					case "1":
						System.out.println("--- Delete Member ---");
						dataID = getNum(userInput);
						System.out.println("Member: " + memberData.get(dataID) + " is being deleted.");
						memberData.remove(dataID);
						break;
					case "2":
						System.out.println("--- Delete Equipment ---");
						dataID = getNum(userInput);
						System.out.println("Equipment: " + equipmentData.get(dataID) + " is being deleted.");
						equipmentData.remove(dataID);
						break;
					case "3":
						System.out.println("--- Delete Warehouse ---");
						dataID = getNum(userInput);
						System.out.println("Warehouse: " + warehouseData.get(dataID) + " is being deleted.");
						warehouseData.remove(dataID);
						break;
					default: 
						System.out.println("Error: Invalid Input");
						break;
					}
					break;
				
				// When the user enters 4 at the main menu
				// Switch cases for what type of data the user wants to search
				case "4":
					System.out.println();
					System.out.println("Choose what to search.");
					displayTypeMenu();
					typeChoice = userInput.nextLine();
					System.out.println();
					switch(typeChoice){
					case "0":
						displayMainMenu();
						mainChoice = userInput.nextLine();
					break;
					case "1":
						System.out.println("--- Search Member ---");
						System.out.println("Enter a Member ID to search.");
						dataID = getNum(userInput);
						System.out.println("Member ID: " + dataID);
						System.out.println("Member Name: " + memberData.get(dataID));
					break;
					case "2":
						System.out.println("--- Search Equipment ---");
						System.out.println("Enter an Equipment ID to search.");
						dataID = getNum(userInput);
						System.out.println("Equipment ID: " + dataID);
						System.out.println("Equipment Name: " + equipmentData.get(dataID));
					break;
					case "3":
						System.out.println("--- Search Warehouse ---");
						System.out.println("Enter a Warehouse ID to search.");
						dataID = getNum(userInput);
						System.out.println("Warehouse ID: " + dataID);
						System.out.println("Warehouse Name: " + warehouseData.get(dataID));
					break;
					default: 
						System.out.println("Error: Invalid Input");
					break;
					}
					break;
				
				// For when the user enters a value not accepted by the main menu			
				default:
					System.out.println("Error: Invalid Input");
					System.out.println();
					displayMainMenu();
					mainChoice = userInput.nextLine();
					break;
			}
		}
		userInput.close();
	}
}
