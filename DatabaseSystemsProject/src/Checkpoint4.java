import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Scanner;

/** 
 * @author Austin Greer
 */

public class Checkpoint4 {
	
	/**
	 *  The database file name.
	 */
	private static String DATABASE = "cp4v1.db";
	
    /**
     * Connects to the database if it exists, creates it if it does not, and returns the connection object.
     * 
     * @param databaseFileName the database file name
     * @return a connection object to the designated database
     */
    public static Connection initializeDB(String databaseFileName) {
        String url = "jdbc:sqlite:" + databaseFileName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("The connection to the database was successful.");
            } else {
            	System.out.println("Null Connection");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("There was a problem connecting to the database.");
        }
        return conn;
    }
    
    /**
     * Queries the database and prints the results.
     * 
     * @param conn a connection object
     * @param sql a SQL statement that returns rows
     * This query is written with the Statement class, typically 
     * used for static SQL SELECT statements
     */
    public static void sqlSelectQuery(Connection conn, String sql){
        try {
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int columnCount = rsmd.getColumnCount();
        	for (int i = 1; i <= columnCount; i++) {
        		String value = rsmd.getColumnName(i);
        		System.out.print(value);
        		if (i < columnCount) System.out.print(",  ");
        	}
			System.out.print("\n");
        	while (rs.next()) {
        		for (int i = 1; i <= columnCount; i++) {
        			String columnValue = rs.getString(i);
            		System.out.print(columnValue);
            		if (i < columnCount) System.out.print(",  ");
        		}
    			System.out.print("\n");
        	}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void sqlAddQuery(Connection conn, String sql){
        try {
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Displays the main menu
 	public static void displayMainMenu() {
 		System.out.println("--- Main Menu ---");
 		System.out.println("Choose an option below.");
 		System.out.println("[1] - Add");
 		System.out.println("[2] - Edit");
 		System.out.println("[3] - Delete");
 		System.out.println("[4] - Search");
 		System.out.println("[5] - View All");
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
    //Connecting to database
    Connection conn = initializeDB(DATABASE);
    			
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
    // Also declaring variables for the data name and data I
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
    								//TODO
    								break;
    							case "2":
    								System.out.println("--- Add Equipment ---");
    								//TODO
    								break;
    							case "3":
    								System.out.println("--- Add Warehouse ---");
    								//TODO
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
    							//TODO
    							break;
    						case "2":
    							System.out.println("--- Edit Equipment ---");
    							//TODO
    							break;
    						case "3":
    							System.out.println("--- Edit Warehouse ---");
    							//TODO
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
    							//TODO;
    							break;
    						case "2":
    							System.out.println("--- Delete Equipment ---");
    							//TODO
    							break;
    						case "3":
    							System.out.println("--- Delete Warehouse ---");
    							//TODO
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
    							System.out.println("--- Search Members ---");
    							//TODO
    						break;
    						case "2":
    							System.out.println("--- Search Equipment ---");
    							//TODO
    						break;
    						case "3":
    							System.out.println("--- Search Warehouses ---");
    							//TODO
    						break;
    						default: 
    							System.out.println("Error: Invalid Input");
    						break;
    						}
    						break;
    						
    					case "5":
    						System.out.println();
    						System.out.println("Choose what to view.");
    						displayTypeMenu();
    						typeChoice = userInput.nextLine();
    						System.out.println();
    						switch(typeChoice){
    						
    							// If the user enters 0 to go back to the main menu
    							// Switch cases for what type of data the user wants to view
    							case "0":
    								displayMainMenu();
    								mainChoice = userInput.nextLine();
    								break;
    							case "1":
    								System.out.println("--- Viewing All Members ---");
    								sqlSelectQuery(conn, "SELECT * FROM Member;");
    								break;
    							case "2":
    								System.out.println("--- Viewing All Equipment ---");
    								sqlSelectQuery(conn, "SELECT * FROM Equipment;");
    								break;
    							case "3":
    								System.out.println("--- Viewing All Warehouses ---");
    								sqlSelectQuery(conn, "SELECT * FROM Warehouse;");
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
