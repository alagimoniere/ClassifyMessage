/* ClassifyMessage.java

 * Author: Alyssa Lagimoniere
 * Submission Date: 2/6/15
 * 
 * Purpose: To use if-else statements and multi-branch statements, boolean variables, enumerations,
 * and to compare values of primitive data types and Strings.
 * 
 * Statement of Academic Honesty: 
 * 
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia. 
 */

import java.util.Scanner;
public class ClassifyMessage {
enum MessageCategory {NEED, OFFER, ALERT, INFO, UNKNOWN}

	public static void main(String[] args) {
	
	//Define scanner
	Scanner keyboard = new Scanner(System.in);
	
	//Declare variables
	String catString; //the raw text of message's category
	String payload; //the primary content of the message
	double latitude; //the latitude indicated in the message
	double longitude; //the longitude indicated in the message
	boolean isInRange; //A "flag" indicating whether lat and lng are in bounds
	MessageCategory category; //the message's category
	double south = 39.882343; //southernmost lat
	double north = 40.231315; //northernmost lat
	double west = -105.743511; //westernmost lng
	double east = -104.907864; //easternmost lng
	
	//Prompt user
	System.out.println("Please enter a formatted message: ");
	catString = keyboard.next();
	
	//Determine and print category
	if (catString.equalsIgnoreCase("fire") || catString.equalsIgnoreCase("smoke")) {
		category = MessageCategory.ALERT;
	} else if (catString.equalsIgnoreCase("need")) {
		category = MessageCategory.NEED;
	} else if (catString.equalsIgnoreCase("offer")) {
		category = MessageCategory.OFFER;
	} else if (catString.equalsIgnoreCase("structure") || catString.equalsIgnoreCase("road") || catString.equalsIgnoreCase("photo") || catString.equalsIgnoreCase("evac")) {
		category = MessageCategory.INFO;
	} else {
		category = MessageCategory.UNKNOWN;
	}
	System.out.println("Category: \t" + category);
	
	//Print raw category
	System.out.println("Raw Cat: \t" + catString.trim());
	
	//Print latitude and longitude
	latitude = keyboard.nextDouble();
	System.out.println("Latitude: \t" + latitude);
	longitude = keyboard.nextDouble();
	System.out.println("Longitude: \t" + longitude);
	
	//Print message
	payload = keyboard.nextLine();
	System.out.println("Message: \t" + payload.trim());
		
	//Determine and print is in range
	if (latitude >= south && latitude <= north && longitude >= west && longitude <= east)
		isInRange = true;
	else isInRange = false;
	System.out.print("In Range: \t" + isInRange);
	
	}

}
